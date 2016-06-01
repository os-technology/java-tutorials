/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.command;

/**
 * @author LiuJian
 *
 */
public class GarageDoorDemo implements GarageDoor {

	private String room;

	public GarageDoorDemo(String room) {
		this.room = room;
	}

	@Override
	public void open() {
		System.out.println(room + " the garage 's door is open now.");
	}

}
