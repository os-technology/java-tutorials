/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.templateMethod;

/**
 * @author LiuJian
 *
 */
public class TeaWithHook extends CaffeineBeverageWithHook {

	@Override
	protected void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Adding Lemon");
	}

}
