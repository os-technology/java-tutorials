package cn.aposoft.design.patterns.demos.ak47.com.bankht.factory;

/**
 * @创建时间：2012-6-19 下午02:26:45
 * <p>
 * @author: 特种兵—AK47
 * 
 * @类说明 ：
 */
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String loginType = "password";
		String name = "name";
		String password = "password";
		// 处理口令认证
		if (loginType.equals("password")) {
			PasswordLogin passwordLogin = new PasswordLogin();
			boolean bool = passwordLogin.verify(name, password);
			if (bool) {
				/**
				 * 业务逻辑
				 */
			} else {
				/**
				 * 业务逻辑
				 */
			}
		}
		// 处理域认证
		else if (loginType.equals("passcode")) {
			DomainLogin domainLogin = new DomainLogin();
			boolean bool = domainLogin.verify(name, password);
			if (bool) {
				/**
				 * 业务逻辑
				 */
			} else {
				/**
				 * 业务逻辑
				 */
			}
		} else {
			/**
			 * 业务逻辑
			 */
		}
	}
}