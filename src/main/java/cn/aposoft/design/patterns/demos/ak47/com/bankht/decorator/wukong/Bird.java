package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.wukong;

/**
 * @创建时间：2012-6-26 上午09:30:11
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：具体装饰角色“鸟儿”
 */
public class Bird extends Change {

	public Bird(TheGreatestSage sage) {
		super(sage);
	}

	@Override
	protected void beforeMove() {
		System.out.println("the Greatest Sage changes to a Bird.");
	}

	@Override
	protected void afterMove() {
		System.out.println("the Greatest Saga changes back from the Bird.");
	}

}