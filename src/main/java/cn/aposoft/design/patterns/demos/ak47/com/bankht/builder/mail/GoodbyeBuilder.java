/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.builder.mail;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-25 下午02:34:15
 * 
 * @类说明 ：具体建造者GoodbyeBuilder
 */
public class GoodbyeBuilder extends Builder {

	public GoodbyeBuilder() {
		msg = new GoodbyeMessage();
	}

	@Override
	public void buildBody() {
		msg.setBody("欢送内容");
	}

	@Override
	public void buildSubject() {
		msg.setSubject("欢送标题");
	}
}