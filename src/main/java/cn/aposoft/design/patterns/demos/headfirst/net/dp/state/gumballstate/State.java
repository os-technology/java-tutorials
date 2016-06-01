package cn.aposoft.design.patterns.demos.headfirst.net.dp.state.gumballstate;

/**
 * 
 * @author LiuJian
 *
 */
public interface State {

	public void insertQuarter();

	public void ejectQuarter();

	public void turnCrank();

	public void dispense();
}
