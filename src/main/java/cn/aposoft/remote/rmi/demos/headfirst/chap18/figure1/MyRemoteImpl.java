/**
 * 
 */
package cn.aposoft.remote.rmi.demos.headfirst.chap18.figure1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicInteger;;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	private static final long serialVersionUID = 4720158211154239723L;
	private AtomicInteger requestCount = new AtomicInteger(0);

	private final State initState = new InitState(this);
	private final State normalSate = new NormalState();
	private volatile State state = initState();
	private volatile int lastTime = (int) (System.currentTimeMillis() % (1000 * 100) / 1000);

	private final int resetLastTime() {
		int prev = lastTime;
		lastTime = (int) (System.currentTimeMillis() % (1000 * 100) / 1000);
		return prev;
	}

	private State initState() {
		return initState;
	}

	private State normalState() {
		return normalSate;
	}

	private void setNormalState() {
		state = normalState();
	}

	private interface State {
		void onCall();
	}

	private class InitState implements State {
		// should not be modified after first assignment
		private final MyRemoteImpl outer;

		private InitState(MyRemoteImpl outer) {
			this.outer = outer;
		}

		@Override
		public void onCall() {
			outer.resetLastTime();
			outer.setNormalState();
		}
	}

	private class NormalState implements State {
		// should not be modified after first assignment
		private NormalState() {
		}

		@Override
		public void onCall() {
		}
	}

	private MyRemoteImpl() throws RemoteException {
		super();
	}

	public String sayHello() {
		state.onCall();
		int i = ifReport();
		return "Server says, ‘Hey’ + requestTimes:" + i;
	}

	private int ifReport() {
		int i = requestCount.incrementAndGet();
		if (i % 10000 == 0) {
			int last = resetLastTime();
			System.out.println(last);
		}
		return 0;
	}

	/**
	 * 服务启动方法:
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
