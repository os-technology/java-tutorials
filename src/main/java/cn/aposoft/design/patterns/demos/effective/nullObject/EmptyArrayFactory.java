/**
 * 
 */
package cn.aposoft.design.patterns.demos.effective.nullObject;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * this factory create 0 length arrays for all types and primitives.
 * 
 * @author LiuJian
 */
public class EmptyArrayFactory {
	private final static Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

	//// 长度检测因本方法不暴露创建array的方法,因此不再需要
	// private static void checkLength(int length) {
	// if (length < 0) {
	// throw new IllegalArgumentException("the length of an array must not be
	// less than 0.");
	// }
	// }

	private static final Object[] oa = new Object[0];

	// WARNING: NEVER DO LIKE THIS
	@SuppressWarnings("unchecked")
	public static final <T> T[] emptyArray() {
		return (T[]) oa;
	}

	public static void main(String[] args) {
		Integer[] o = emptyArray();
		System.out.println("run successful." + o);
	}

	/**
	 * 本实例通过传入类型的clazz,返回该实例的长度为0的E[]对象实例.
	 * 因为0长度数组是不可变的(immutable),所以本方法会返回对应实例的单例模式.
	 * 
	 * @return a 0 length array of the given type.
	 * @throws NullPointerException
	 *             when clazz is null,this exception will be throw away.
	 * @throws IllegalArgumentException
	 *             when length < 0 ,this exception will be throw away.
	 */
	@SuppressWarnings("unchecked")
	public static final <E> E[] array(final Class<E> clazz) {
		if (clazz == null) {
			throw new NullPointerException("the param clazz must not be null.");
		}
		// Effective Java解释,通过对本地变量的使用,对整个函数会有一定的性能提升,他的机器是25%.
		E[] result = (E[]) map.get(clazz);
		if (result == null) {
			synchronized (map) {
				result = (E[]) map.get(clazz);
				if (result == null) {
					result = createArray(clazz, 0);
					map.put(clazz, result);
				}
			}
		}
		return (E[]) result;
	}

	/**
	 * 本实例通过传入类型的clazz,返回该实例的长度为0的E[]对象实例.
	 * 因为0长度数组是不可变的(immutable),所以本方法会返回对应实例的单例模式.
	 * <p>
	 * 本方法没有校验输入的合法性,因PrimitiveType枚举和返回值之间没有强对应关系,因此本方法不具有类型安全性,
	 * 需要有client对安全性进行保证.
	 * 
	 * @return a 0 length array of the given type.
	 * @throws NullPointerException
	 *             when clazz is null,this exception will be throw away.
	 * @throws IllegalArgumentException
	 *             when length < 0 ,this exception will be throw away.
	 */
	@SuppressWarnings("unchecked")
	public static final <E> E[] array(final PrimitiveType type) {
		if (type == null) {
			throw new NullPointerException("the param type must not be null.");
		}
		// Effective Java解释,通过对本地变量的使用,对整个函数会有一定的性能提升,他的机器是25%.
		return (E[]) type.array();
	}

	/**
	 * the input clazz must be the type of E
	 * 
	 * @param clazz
	 *            the type of the new array
	 * @param length
	 *            the length of the new array.
	 * @return an array of for type e with the length {@code length}
	 * @throws NullPointerException
	 *             when clazz is null,this exception will be throw away.
	 * @throws IllegalArgumentException
	 *             when length < 0 ,this exception will be throw away.
	 */
	@SuppressWarnings("unchecked")
	private static final <E> E[] createArray(final Class<E> clazz, final int length) {
		// used to check if the class object is null
		return (E[]) Array.newInstance(clazz, length);
	}

	public static enum PrimitiveType {
		BOOLEAN {
			boolean[] ba = new boolean[0];

			@Override
			public Object array() {
				return ba;
			}
		},
		BYTE {
			byte[] ba = new byte[0];

			@Override
			public Object array() {
				return ba;
			}
		},
		CHAR {
			char[] ba = new char[0];

			@Override
			public Object array() {
				return ba;
			}
		},
		SHORT {
			short[] ba = new short[0];

			@Override
			public Object array() {
				return ba;
			}
		},
		INT {
			int[] ba = new int[0];

			@Override
			public Object array() {
				return ba;
			}
		},
		LONG {
			long[] ba = new long[0];

			@Override
			public Object array() {
				return ba;
			}
		},
		FLOAT {
			float[] ba = new float[0];

			@Override
			public Object array() {
				return ba;
			}
		},
		DOUBLE {
			double[] ba = new double[0];

			@Override
			public Object array() {
				return ba;
			}
		};
		protected abstract Object array();
	}

}
