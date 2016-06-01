/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.templateMethod;

/**
 * @author LiuJian
 *
 */
public class Coffee extends CaffeineBeverage {

	@Override
	protected void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}
}
