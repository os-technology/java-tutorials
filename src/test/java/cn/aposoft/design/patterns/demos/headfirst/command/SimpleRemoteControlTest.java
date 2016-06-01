/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.command;

import org.junit.Test;

/**
 * @author LiuJian
 *
 */
public class SimpleRemoteControlTest {
	@Test
	public void testSimpleRemoteControlTurnOn() {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new LightDemo("");
		Command lightOn = new LightOnCommand(light);
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		GarageDoor door = new GarageDoorDemo("");
		Command garageDoorOpen = new GarageDoorOpenCommand(door);
		remote.setCommand(garageDoorOpen);
		remote.buttonWasPressed();

	}
}
