/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.command;

/**
 * @author LiuJian
 *
 */
public class LightDemo implements Light {

	private String room;

	public LightDemo(String room) {
		this.room = room;
	}

	@Override
	public void on() {
		System.out.println("The simple light in " + room + " is on.");
	}

	@Override
	public void off() {
		System.out.println("The simple light " + room + " is off.");
	}

}
