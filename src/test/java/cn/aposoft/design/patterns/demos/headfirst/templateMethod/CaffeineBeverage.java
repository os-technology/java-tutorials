/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.templateMethod;

/**
 * @author LiuJian
 *
 */
public abstract class CaffeineBeverage {
	protected final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	protected abstract void brew();

	protected abstract void addCondiments();

	void boilWater() {
		System.out.println("Boiling water");
	}

	void pourInCup() {
		System.out.println("Pouring into cup");
	}
}
