/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy;

/**
 * @创建时间：2012-6-26 下午10:18:15
 * 
 * @author: 特种兵—AK47
 * 
 * 
 * @类说明 ：中级会员折扣类
 */
public class IntermediateMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于中级会员的折扣为10%");
		return booksPrice * 0.9;
	}

}