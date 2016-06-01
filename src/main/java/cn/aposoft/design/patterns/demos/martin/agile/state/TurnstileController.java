/**
 * 
 */
package cn.aposoft.design.patterns.demos.martin.agile.state;

/**
 * 门锁控制器
 * 
 * @author LiuJian
 *
 */
public interface TurnstileController {
	void lock();

	void unlock();

	void thankyou();

	void alarm();
}
