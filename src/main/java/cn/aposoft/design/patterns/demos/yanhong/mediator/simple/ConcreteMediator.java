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
public class ConcreteMediator implements Mediator {
	// 持有并维护同事A
	private ConcreteColleagueA colleagueA;
	// 持有并维护同事B
	private ConcreteColleagueB colleagueB;

	public void setColleagueA(ConcreteColleagueA colleagueA) {
		this.colleagueA = colleagueA;
	}

	public void setColleagueB(ConcreteColleagueB colleagueB) {
		this.colleagueB = colleagueB;
	}

	/**
	 * 当Colleague change时发生
	 */
	@Override
	public void changed(Colleague c) {
		// 这样会产生死循环
		// 某一个同事类发生了变化，通常需要与其他同事交互 具体协调相应的同事对象来实现协作行为
		if (c instanceof ConcreteColleagueA) {
			colleagueB.reminded();
		} else {
			colleagueA.reminded();
		}
	}
}
