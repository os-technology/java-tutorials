/**
 * 
 */
package cn.aposoft.basic.number;

/**
 * @author LiuJian
 *
 */
public class DataStorageStructure {

	public final static int swapInt(int v) {
		return (v >>> 24) | (v << 24) | ((v << 8) & 0x00FF0000)
				| ((v >> 8) & 0x0000FF00);
	}

	public final static int strLength(int i) {
		return String.valueOf(i).length();
	}

	public final static int strLength(long l) {
		return String.valueOf(l).length();
	}

	public final static void testSwapInt() {
		// before 0x01020304
		// after 0x04030201
		int v = 0x01020304;
		System.out.println("before : 0x" + Integer.toString(v, 16));
		System.out.println("after  : 0x" + Integer.toString(swapInt(v), 16));

		// take 16-bit short apart into two 8-bit bytes.
		short x = (short) 0xabcd;
		byte high = (byte) (x >>> 8);
		byte low = (byte) x;
		System.out.println("x=" + x + " high=" + high + " low=" + low);
	}

	public final static void testMaxNumericStringLength() {
		System.out.println(strLength(Integer.MAX_VALUE));
		System.out.println(strLength(Long.MAX_VALUE));
	}

	public static void main(String argv[]) {
		testIntegerBitMove();
		// testMaxIntValue();
		// testMaxNumericStringLength();
	}

	public static void testMaxIntValue() {
		long value = 0xFFFFFFFFL;
		int intValue = (int) value;
		System.out.println(intValue);

	}

	public static void testIntegerBitMove() {
		//
		int dst = 0;
		for (int i = 0; i < 32; i++) {
			dst = (dst << 1) | 1;
			System.out.println(Integer.toBinaryString(dst));
		}
		dst = 0xFFFFFFFF;
		for (int i = 0; i < 4; i++) {

			 System.out.println(Integer.toBinaryString(dst));
			dst >>= 8;
		}

		 System.out.println(Integer.toBinaryString(dst));
		dst = 0xFFFFFFFF;
		for (int i = 0; i < 4; i++) {
			 System.out.println(Integer.toBinaryString(dst));
			dst >>>= 8;
		}

		// System.out.println(Integer.toBinaryString(dst));
	}
}
