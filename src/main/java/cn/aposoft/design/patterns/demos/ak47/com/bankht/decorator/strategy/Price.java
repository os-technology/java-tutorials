package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy;

/**
 * @创建时间：2012-6-26 下午10:19:22
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：价格类
 */
public class Price {
	// 持有一个具体的策略对象
	private MemberStrategy strategy;

	/**
	 * 构造函数，传入一个具体的策略对象
	 * 
	 * @param strategy
	 *            具体的策略对象
	 */
	public Price(MemberStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 计算图书的价格
	 * 
	 * @param booksPrice
	 *            图书的原价
	 * @return 计算出打折后的价格
	 */
	public double quote(double booksPrice) {
		return this.strategy.calcPrice(booksPrice);
	}
}
