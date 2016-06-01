/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.push;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-28 下午09:43:26
 * 
 * @类说明 ：抽象主题角色类
 */
public abstract class Subject {
	/**
	 * 用来保存注册的观察者对象
	 */
	private List<Observer> list = new ArrayList<Observer>();

	/**
	 * 注册观察者对象
	 * 
	 * @param observer
	 *            观察者对象
	 */
	public void attach(Observer observer) {
		list.add(observer);
		System.out.println("Attached an observer");
	}

	/**
	 * 删除观察者对象
	 * 
	 * @param observer
	 *            观察者对象
	 */
	public void detach(Observer observer) {
		list.remove(observer);
		System.out.println("Detached an observer");
	}

	/**
	 * 通知所有注册的观察者对象
	 */
	public void nodifyObservers(String newState) {
		for (Observer observer : list) {
			observer.update(newState);
		}
	}
}