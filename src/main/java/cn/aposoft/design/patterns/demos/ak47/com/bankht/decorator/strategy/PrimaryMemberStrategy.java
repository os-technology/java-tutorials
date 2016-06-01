package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy;

/**
 * @创建时间：2012-6-26 下午10:17:28
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：初级会员折扣类
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于初级会员的没有折扣");
		return booksPrice;
	}

}