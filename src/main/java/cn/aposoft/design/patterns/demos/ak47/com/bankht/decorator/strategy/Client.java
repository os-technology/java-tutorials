/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-26 下午10:19:48
 * 
 * @类说明 ：客户端
 */
public class Client {

	public static void main(String[] args) {
		// 选择并创建需要使用的策略对象
		MemberStrategy strategy = new AdvancedMemberStrategy();

		// 创建环境
		Price price = new Price(strategy);
		// 计算价格
		double quote = price.quote(300);
		System.out.println("图书的最终价格为：" + quote);
	}
}
