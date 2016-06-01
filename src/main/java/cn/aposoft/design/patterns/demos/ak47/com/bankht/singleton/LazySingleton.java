/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.singleton;

/**
 * @author LiuJian
 *
 */
public class LazySingleton implements Singleton {
	private volatile static LazySingleton instance = null;

	private LazySingleton() {
	}

	public static Singleton getInstance() {
		// 先检查实例是否存在，如果不存在才进入下面的同步块
		if (instance == null) {
			// 同步块，线程安全的创建实例
			synchronized (LazySingleton.class) {
				// 再次检查实例是否存在，如果不存在才真正的创建实例
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}
