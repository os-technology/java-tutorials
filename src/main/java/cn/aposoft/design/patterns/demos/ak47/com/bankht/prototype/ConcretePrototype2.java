/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.prototype;

/**
 * 
 * @创建时间：2012-6-25 下午03:59:15
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：具体原型角色
 */
public class ConcretePrototype2 implements Prototype {
	public Prototype clone() {
		// 最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
		Prototype prototype = new ConcretePrototype2();
		return prototype;
	}
}
