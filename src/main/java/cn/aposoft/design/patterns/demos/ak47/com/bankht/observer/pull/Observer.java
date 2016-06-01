package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.pull;

/**
 * @author: 特种兵—AK47 @创建时间：2012-6-28 下午10:03:02
 * 
 * @类说明 ：拉模型通常都是把主题对象当做参数传递。
 */
public interface Observer {
	/**
	 * 更新接口
	 * 
	 * @param subject
	 *            传入主题对象，方面获取相应的主题对象的状态
	 */
	public void update(Subject subject);
}