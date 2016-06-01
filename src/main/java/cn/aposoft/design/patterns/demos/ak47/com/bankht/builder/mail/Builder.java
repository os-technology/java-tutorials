/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.builder.mail;

import java.util.Date;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-25 下午02:33:07
 * 
 * @类说明 ：抽象建造者类
 */
public abstract class Builder {
	protected AutoMessage msg;

	// 标题零件的建造方法
	public abstract void buildSubject();

	// 内容零件的建造方法
	public abstract void buildBody();

	// 收件人零件的建造方法
	public void buildTo(String to) {
		msg.setTo(to);
	}

	// 发件人零件的建造方法
	public void buildFrom(String from) {
		msg.setFrom(from);
	}

	// 发送时间零件的建造方法
	public void buildSendDate() {
		msg.setSendDate(new Date());
	}

	/**
	 * 邮件产品完成后，用此方法发送邮件 此方法相当于产品返还方法
	 */
	public void sendMessage() {
		msg.send();
	}
}
