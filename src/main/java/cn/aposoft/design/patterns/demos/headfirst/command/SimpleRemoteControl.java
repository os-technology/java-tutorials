/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.command;

/**
 * @author LiuJian
 *
 */
public class SimpleRemoteControl {
	private Command slot;

	public SimpleRemoteControl() {
	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
}
