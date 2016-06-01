package cn.aposoft.basic;

/**
 * 空 强转测试
 * @author LiuJian
 *
 */
public class NullConverterDemo {

	private static void print() {
		System.out.println("this is a text.");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String s = null;
		Object o = (Object) null;
		s = "12345";
		Integer i = Integer.valueOf(s);
		System.out.println(i);
		System.out.println(o);
		// 本语句通过强转调用类的静态方法,因此不会报错.
		((NullConverterDemo) null).print();
	}
}
