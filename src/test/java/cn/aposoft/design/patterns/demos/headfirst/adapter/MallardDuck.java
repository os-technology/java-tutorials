/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.adapter;

/**
 * @author LiuJian
 *
 */
public class MallardDuck implements Duck {
	public void quack() {
		System.out.println("Quack");
	}

	public void fly() {
		System.out.println("I’m flying");
	}
}
