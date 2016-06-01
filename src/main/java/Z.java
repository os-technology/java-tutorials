
/**
 * 
 */

/**
 * @author LiuJian
 *
 */
public class Z {

	public static void main(String[] args) {
		System.out.println(name(new boolean[0]));
		System.out.println(name(new byte[0]));
		System.out.println(name(new char[0]));
		System.out.println(name(new short[0]));
		System.out.println(name(new int[0]));
		System.out.println(name(new long[0]));
		System.out.println(name(new float[0]));
		System.out.println(name(new double[0]));
		System.out.println(name(new Z[0]));
		System.out.println(name(Z.class));
	}

	private static String name(Object object) {
		return name(object.getClass());
	}

	private static String name(Class<?> clazz) {
		return clazz.getName();
	}
}
