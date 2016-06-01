/**
 * 
 */
package cn.aposoft.basic.number;

/**
 * 
 * @author LiuJian
 *
 */
public class NegativeNumberModDemo {
	public static void main(String[] args) {
		System.out.println(-1 % 2); // result: -1
		System.out.println(-1 % 1); // result: 0
		System.out.println(-5 % 6);// result: -5
		System.out.println(-50 % 6);// result: -2
		// System.out.println(1 % 0);// result: throw java.lang.ArithmeticException: / by zero
	}
}
