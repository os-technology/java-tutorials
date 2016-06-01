/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.command;

/**
 * @author LiuJian
 *
 */
public class GarageDoorOpenCommand implements Command {
	private GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.design.patterns.demos.headfirst.command.Command#execute()
	 */
	@Override
	public void execute() {
		garageDoor.open();
	}

}
