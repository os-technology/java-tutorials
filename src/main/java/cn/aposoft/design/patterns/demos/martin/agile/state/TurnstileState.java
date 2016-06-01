/**
 * 
 */
package cn.aposoft.design.patterns.demos.martin.agile.state;

/**
 * @author LiuJian
 * 
 */
public interface TurnstileState {
	void Coin(Turnstile t);

	void Pass(Turnstile t);
}
