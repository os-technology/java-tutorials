/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.jdk;

import java.util.Observable;

/**
 * @创建时间：2012-6-28 下午10:23:14
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：被观察者Watched类源代码
 */
public class Watched extends Observable {

	private String data = "";

	public String getData() {
		return data;
	}

	public void setData(String data) {

		if (!this.data.equals(data)) {
			this.data = data;
			setChanged();
		}
		notifyObservers();
	}

}