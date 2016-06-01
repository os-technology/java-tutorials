/**
 * 
 */
package cn.aposoft.design.patterns.demos.yanhong.mediator.movie;

import cn.aposoft.design.patterns.demos.yanhong.mediator.Colleague;
import cn.aposoft.design.patterns.demos.yanhong.mediator.Mediator;

/**
 * @author LiuJian
 *
 */
public class VideoCard extends Colleague  {
	/**
	 * 构造函数
	 */
	public VideoCard(Mediator mediator) {
		super(mediator);
	}

	/**
	 * 显示视频数据
	 */
	public void showData(String data) {
		System.out.println("您正在观看的是：" + data);
	}
}