/**
 * 
 */
package cn.aposoft.design.patterns.demos.martin.agile.state;

/**
 * @author LiuJian
 *
 */
public class LockedTurnstileState implements TurnstileState {

	@Override
	public void Coin(Turnstile t) {
		t.setUnlocked();
		t.unlock();
	}

	@Override
	public void Pass(Turnstile t) {
		t.alarm();
	}

}
