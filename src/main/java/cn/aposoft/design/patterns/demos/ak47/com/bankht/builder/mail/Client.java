/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.builder.mail;

/**
 * <p>
 * @创建时间：2012-6-25 下午02:35:36
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：客户端Client
 */
public class Client {
	public static void main(String[] args) {
		Builder builder = new WelcomeBuilder();
		Director director = new Director(builder);
		director.construct("toAddress@126.com", "fromAddress@126.com");
	}
}