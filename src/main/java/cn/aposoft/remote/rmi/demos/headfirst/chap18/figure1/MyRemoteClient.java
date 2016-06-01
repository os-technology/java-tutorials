/**
 * 
 */
package cn.aposoft.remote.rmi.demos.headfirst.chap18.figure1;

import java.io.Serializable;
import java.rmi.Naming;

/**
 * @author LiuJian
 *
 */
public class MyRemoteClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyRemoteClient().go();
	}

	public void go() {
		try {
			String result = null;
			long begin = System.currentTimeMillis();
			// 一个是服务端口（默认是 1099）
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");

			for (int i = 0; i < 1000 * 100; i++) {
				result = service.sayHello();
			}
			long end = System.currentTimeMillis();
			System.out.println(result + "," + (end - begin));
			System.out.println(service instanceof Serializable);
			System.out.println(service.getClass().getName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
