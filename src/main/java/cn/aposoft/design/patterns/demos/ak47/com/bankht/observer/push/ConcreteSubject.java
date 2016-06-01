/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.push;

/**
 * @创建时间：2012-6-28 下午09:44:36
 * @author: 特种兵—AK47 
 * 
 * @类说明 ：具体主题角色类
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
		this.nodifyObservers(state);
	}
}