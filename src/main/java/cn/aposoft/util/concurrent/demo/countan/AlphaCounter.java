/**
 * 
 */
package cn.aposoft.util.concurrent.demo.countan;

/**
 * 
 * 数字母:A 通知CountNumeric, B 通知,,and so on
 * 
 * @author LiuJian
 * @version 1.0
 */
public class AlphaCounter extends Counter {
	public AlphaCounter(Synchronizer sync) {
		super(sync);
	}

	@Override
	protected void execute() {
		signalRunnerAndWait();
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println("Thread:" + Thread.currentThread().getName() + ",Alpha:" + c);
			if (c != 'Z') {
				signalAndWait();
			}
		}
	}
}
