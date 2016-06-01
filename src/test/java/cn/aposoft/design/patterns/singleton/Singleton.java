/**
 * 
 */
package cn.aposoft.design.patterns.singleton;

/**
 * The best practice for singleton since jdk 1.5
 * 
 * @author LiuJian
 * 
 */
public enum Singleton {
	INSTANCE;

	public void leaveTheBuilding() {
		// do something
		// String s = new String("stringette"); // DON'T DO THIS!
		// String s = "stringette"; // DO LIKE THIS!
	}
}
