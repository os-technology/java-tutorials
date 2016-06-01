/**
 * 
 */
package cn.aposoft.design.patterns.demos.martin.agile.state;

/**
 * @author LiuJian
 *
 */
public class UnlockedTurnstileState implements TurnstileState {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.design.patterns.demos.agile.state.TurnstileState#Coin(io.
	 * aposoft.design.patterns.demos.agile.state.Turnstile)
	 */
	@Override
	public void Coin(Turnstile t) {
		t.Thankyou();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.design.patterns.demos.agile.state.TurnstileState#Pass(io.
	 * aposoft.design.patterns.demos.agile.state.Turnstile)
	 */
	@Override
	public void Pass(Turnstile t) {
		t.setLocked();
		t.lock();
	}

}
