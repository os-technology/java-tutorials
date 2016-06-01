/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.pull;

/**
 * @创建时间：2012-6-28 下午09:45:58
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：具体观察者角色类
 */
public class Client {

	public static void main(String[] args) {
		// 创建主题对象
		ConcreteSubject subject = new ConcreteSubject();
		// 创建观察者对象
		Observer observer = new ConcreteObserver();
		// 将观察者对象登记到主题对象上
		subject.attach(observer);
		subject.attach(observer);
		// subject.detach(observer);
		// 改变主题对象的状态
		subject.change("new state");
		subject.detach(observer);
		subject.change("newer state");
		subject.detach(observer);
		subject.change("newest state");
	}

}