package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.wukong;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-26 上午09:29:24
 * 
 * @类说明 ：抽象装饰角色“七十二变”
 */
public abstract class Change implements TheGreatestSage {
	private TheGreatestSage sage;

	public Change(TheGreatestSage sage) {
		this.sage = sage;
	}

	protected abstract void beforeMove();

	protected abstract void afterMove();

	@Override
	public void move() {
		// 代码
		beforeMove();
		sage.move();
		afterMove();
	}
}
