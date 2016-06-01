/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-28 下午10:23:44
 * 
 * @类说明 ： 观察者类源代码
 */
public class Watcher implements Observer {

	public Watcher() {
	}

	public Watcher(Observable o) {
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Watched)
			System.out.println("状态发生改变：" + ((Watched) o).getData());
	}

}
