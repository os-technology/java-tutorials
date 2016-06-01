package cn.aposoft.design.patterns.demos.martin.agile.state;

/**
 * 转换锁状态器
 * 
 * @author LiuJian
 *
 */
public class Turnstile {
	private static TurnstileState lockedState = new LockedTurnstileState();

	private static TurnstileState unlockedState = new UnlockedTurnstileState();

	private TurnstileController turnstileController;
	private TurnstileState state = unlockedState;

	public Turnstile(TurnstileController action) {
		turnstileController = action;
	}

	public void coin() {
		state.Coin(this);
	}

	public void pass() {
		state.Pass(this);
	}

	protected void setUnlocked() {
		state = unlockedState;
	}

	protected void alarm() {
		turnstileController.alarm();
	}

	protected void Thankyou() {
		turnstileController.thankyou();
	}

	protected void setLocked() {
		state = lockedState;
	}

	protected void lock() {
		turnstileController.lock();
	}

	protected void unlock() {
		turnstileController.unlock();
	}
}
