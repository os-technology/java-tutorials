/**
 * 
 */
package cn.aposoft.basic.classloader;

/**
 * @author Jann Liu
 *
 */
public class ClassLoadingDemo {
	public static void main(String[] args) {
		System.out.println("app is start.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("after 2000.");
		StaticRegionCase case1 = new StaticRegionCase();
		case1.execute();
	}
}
