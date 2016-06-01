/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.pull;

/**
 * @创建时间：2012-6-28 下午10:03:25
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ： 拉模型的具体观察者类
 */
public class ConcreteObserver implements Observer {
	// 观察者的状态
	private String observerState;

	@Override
	public void update(Subject subject) {
		/**
		 * 更新观察者的状态，使其与目标的状态保持一致
		 */
		observerState = ((ConcreteSubject) subject).getState();
		System.out.println("观察者状态为：" + observerState);
	}

}
