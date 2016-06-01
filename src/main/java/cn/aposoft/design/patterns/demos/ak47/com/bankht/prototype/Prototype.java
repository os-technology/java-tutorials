/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.prototype;

/**
 * @创建时间：2012-6-25 下午03:58:33
 * 
 * @author: 特种兵—AK47
 * 
 * 
 * @类说明 ：抽象原型角色
 */
public interface Prototype {
	/**
	 * 克隆自身的方法
	 * 
	 * @return 一个从自身克隆出来的对象
	 */
	public Prototype clone();
}
