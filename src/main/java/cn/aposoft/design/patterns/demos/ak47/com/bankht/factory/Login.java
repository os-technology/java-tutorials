/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.factory;

/**
 * @创建时间：2012-6-18 下午02:20:00
 * <p>
 * @author： 特种兵—AK47
 * 
 * @类说明 ：建立一个各种登录方式都适用的接口
 */
public interface Login {
	public boolean verify(String name, String password);
}