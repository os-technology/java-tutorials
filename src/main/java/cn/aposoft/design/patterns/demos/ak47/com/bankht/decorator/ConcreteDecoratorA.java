/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator;

/**
 * @创建时间：2012-6-26 上午09:23:34
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：具体装饰角色
 */
public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}

	@Override
	public void sampleOperation() {
		super.sampleOperation();
		// 写相关的业务代码
	}
}
