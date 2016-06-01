/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.push;

/**
 * @创建时间：2012-6-28 下午09:45:58
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：具体观察者角色类
 */
public class ConcreteObserver implements Observer {
	// 观察者的状态
	private String observerState;

	@Override
	public void update(String state) {
		/**
		 * 更新观察者的状态，使其与目标的状态保持一致
		 */
		observerState = state;
		System.out.println("状态为：" + observerState);
	}

}