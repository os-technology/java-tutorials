package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.wukong;

/**
 * @创建时间：2012-6-26 上午09:29:47
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：具体装饰角色“鱼儿”
 */
public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
	}

	@Override
	protected void beforeMove() {
		System.out.println("the Greatest Sage changes to fish.");
	}

	@Override
	protected void afterMove() {
		System.out.println("the Greatest Saga changes back from fish.");
	}

}
