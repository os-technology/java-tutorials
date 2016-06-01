/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.observer.push;

/**
 * @创建时间：2012-6-28 下午09:45:20
 * 
 * @author: 特种兵—AK47
 * 
 * 
 * @类说明 ： 抽象观察者角色类
 */
public interface Observer {
	/**
	 * 更新接口
	 * 
	 * @param state
	 *            更新的状态
	 */
	public void update(String state);
}