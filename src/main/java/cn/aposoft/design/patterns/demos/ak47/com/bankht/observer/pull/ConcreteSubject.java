/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.pull;

/**
 * @创建时间：2012-6-28 下午10:04:24
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：跟推模型相比，有一点变化，就是调用通知观察者的方法的时候，不需要传入参数了。
 */
public class ConcreteSubject extends Subject {

	private String state;

	public String getState() {
		return state;
	}

	public void change(String newState) {
		state = newState;
		System.out.println("主题状态为：" + state);
		// 状态发生改变，通知各个观察者
		this.nodifyObservers();
	}
}
