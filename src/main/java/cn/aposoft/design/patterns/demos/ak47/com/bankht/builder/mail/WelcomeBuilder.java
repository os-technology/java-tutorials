/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.builder.mail;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-25 下午02:33:36
 * 
 * @类说明 ：具体建造者WelcomeBuilder
 */
public class WelcomeBuilder extends Builder {
	public WelcomeBuilder() {
		msg = new WelcomeMessage();
	}

	@Override
	public void buildBody() {
		msg.setBody("欢迎内容");
	}

	@Override
	public void buildSubject() {
		msg.setSubject("欢迎标题");
	}
}
