package cn.aposoft.design.patterns.demos.ak47.com.bankht.factory;

/**
 * @创建时间：2012-6-18 下午02:27:40
 * <p>
 * @author： 特种兵—AK47
 * 
 * @类说明 ：口令认证
 */
public class PasswordLogin implements Login {

	@Override
	public boolean verify(String name, String password) {
		/**
		 * 业务逻辑
		 */
		return true;
	}

}
