package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy;

/**
 * @创建时间：2012-6-26 下午10:16:58
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：抽象折扣类
 */
public interface MemberStrategy {
	/**
	 * 计算图书的价格
	 * 
	 * @param booksPrice
	 *            图书的原价
	 * @return 计算出打折后的价格
	 */
	public double calcPrice(double booksPrice);
}