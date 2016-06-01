/**
 * 
 */
package cn.aposoft.design.patterns.demos.yanhong.mediator.simple;

import cn.aposoft.design.patterns.demos.yanhong.mediator.Colleague;
import cn.aposoft.design.patterns.demos.yanhong.mediator.Mediator;

/**
 * @author LiuJian
 *
 */
public class ConcreteColleagueA extends Colleague {
	public ConcreteColleagueA(Mediator mediator) {
		super(mediator);
	}

	/**
	 * 示意方法，执行某些操作
	 */
	public void operation() {
		// 在需要跟其他同事通信的时候，通知调停者对象
		getMediator().changed(this);
	}
}
