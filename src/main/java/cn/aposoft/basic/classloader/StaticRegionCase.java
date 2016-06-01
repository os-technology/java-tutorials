/**
 * 
 */
package cn.aposoft.basic.classloader;

/**
 * @author Jann Liu
 *
 */
public class StaticRegionCase {

	public StaticRegionCase() {
		System.out.println("this is in StaticRegionCase 's constructor.");
	}

	static {
		System.out.println("this is in StaticRegionCase 's static region.");
	}

	public void execute() {
		System.out.println("this is execute.");
	}
}
