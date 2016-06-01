/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.adapter;

/**
 * @author LiuJian
 * class Adapter for Duck to Turkey
 */
public class DuckToTurkeyAdapter extends MallardDuck implements Turkey {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.design.patterns.demos.headfirst.adapter.Turkey#gobble()
	 */
	@Override
	public void gobble() {
		super.quack();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.design.patterns.demos.headfirst.adapter.Turkey#fly()
	 */
	@Override
	public void fly() {
		super.fly();
	}

}
