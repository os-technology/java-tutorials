package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.jdk;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-28 下午10:25:43
 * 
 * @类说明 ：测试类源代码
 */
public class Test {

	public static void main(String[] args) {

		// 创建被观察者对象
		Watched watched = new Watched();
		// 创建观察者对象，并将被观察者对象登记
		for (int i = 0; i < 3; i++) {
			watched.addObserver(new Watcher());
		}
		new Watcher(watched);
		// 给被观察者状态赋值
		watched.setData("start");
		watched.setData("run");
		watched.setData("stop");

	}

}