package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy;

/**
 * @创建时间：2012-6-26 下午10:18:59
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：高级会员折扣类
 */
public class AdvancedMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于高级会员的折扣为20%");
		return booksPrice * 0.8;
	}
}
