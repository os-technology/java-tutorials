/**
 * 用于将javabeans里面的null Value 设置为 "" (空字符串) ,用于某些特殊的数据传输环境
 * 例如  : 可以避免在使用AXIS2 进行数据发送时,null值引发异常.
 */
package com.oracle.java.tutorials.reflection.tools;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * 对符合javaBeans 规范的数据中的String类型值为null的自动转换为 ""
 * warning:传入的数据类型如果不符合javabean规范,则无法对其进行正确替换
 * 
 * @author LiuJian
 * @version 1.0
 */
public class NullFieldFiller {
	public static final String Empty = "";

	public static void fillNull(Collection<?> collection)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException {
		for (Object obj : collection) {
			fillNull(obj);
		}
	}

	/**
	 * 对数组中的数据类型的字符串属性进行处理
	 * 
	 * @param array
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 */
	public static void fillArrayNull(Object array)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException {
		if (array.getClass().isArray()) {
			int length = Array.getLength(array);
			for (int i = 0; i < length; i++) {
				fillNull(Array.get(array, i));
			}
		}
	}

	public static void fillNull(Object o) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, InstantiationException {

		if (o == null) {
			return;
		}

		// 读取全部公有方法 public methods
		// 假定传入数据符合JavaBean 规范
		Class<?> clazz = o.getClass();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get")
					&& method.getParameterTypes().length == 0) {
				Object value = method.invoke(o);
				Class<?> returnType = method.getReturnType();
				// 处理字符串的形式
				if (returnType == String.class) {

					// System.out.println("Class:" + clazz.getName() +
					// "; Method: "
					// + method.toGenericString() + "; Value:" + value);
					if (value == null) {
						String setMethodName = method.getName().replaceFirst(
								"get", "set");
						Method setMethod = clazz.getMethod(setMethodName,
								String.class);
						setMethod.invoke(o, Empty);
					}
				} else if (returnType.isArray()) {
					// 如果传入值为空,则创建空Array
					if (value == null) {
						Object array = Array.newInstance(returnType, 0);
						String setMethodName = method.getName().replaceFirst(
								"get", "set");
						Method setMethod = clazz.getMethod(setMethodName,
								String.class);
						setMethod.invoke(o, array);
					} else {
						fillArrayNull(value);
					}

				} else if (value instanceof Collection) {
					fillNull((Collection<?>) value);
				}
			}
		}
	}
}
