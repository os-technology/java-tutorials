package cn.aposoft.design.patterns.demos.ak47.com.bankht.factory;

/**
 * @创建时间：2012-6-18 下午02:25:06
 * <p>
 * @author： 特种兵—AK47
 * 
 * @类说明 ：域认证
 */
public class DomainLogin implements Login {

	@Override
	public boolean verify(String name, String password) {
		/**
		 * 业务逻辑
		 */
		return true;
	}

}
