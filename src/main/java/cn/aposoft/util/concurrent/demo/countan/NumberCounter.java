/**
 * 
 */
package cn.aposoft.util.concurrent.demo.countan;

/**
 * @author LiuJian
 * @version 1.0
 */
public class NumberCounter extends Counter {

	public NumberCounter(Synchronizer sync) {
		super(sync);
	}

	@Override
	protected void execute() {
		for (int c = 1; c <= 52;) {
			System.out.println("Thread:" + Thread.currentThread().getName() + ",Number:" + c++);
			System.out.println("Thread:" + Thread.currentThread().getName() + ",Number:" + c++);
			signalAndWait();
		}
	}
}
