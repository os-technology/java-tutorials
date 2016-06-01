/**
 * 
 */
package cn.aposoft.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author LiuJian
 *
 */
public class AtomicIntegerArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test array.clone();
		int[] arr = new int[2];
		arr[0] = 10;
		arr[1] = 12;

		// 数组
		AtomicIntegerArray atomicArray = new AtomicIntegerArray(arr);
		// 验证结果正确 :clone实现了值复制
		assert (atomicArray.get(0) == 10);
		assert (atomicArray.get(1) == 12);

		//
		
	}
}
