/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator;

/**
 * @创建时间：2012-6-26 上午09:23:03
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：装饰角色
 */
public class Decorator implements Component {
	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void sampleOperation() {
		// 委派给构件
		component.sampleOperation();
	}

}
