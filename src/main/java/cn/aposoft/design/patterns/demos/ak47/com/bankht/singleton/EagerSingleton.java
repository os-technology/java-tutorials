/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.singleton;

/**
 * Singleton ,单例模式样例
 * 
 * @author LiuJian
 * @version 1.0
 */
public class EagerSingleton implements Singleton {
	private static EagerSingleton instance = new EagerSingleton();

	/**
	 * 私有默认构造子
	 */
	private EagerSingleton() {
	}

	/**
	 * 静态工厂方法
	 */
	public static Singleton getInstance() {
		return instance;
	}
}
