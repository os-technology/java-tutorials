package cn.aposoft.design.patterns.demos.ak47.com.bankht.factoryMethod;

import org.junit.Test;

/**
 * @创建时间：2012-6-19 下午02:59:25
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：测试工厂方法模式类
 */
public class TestFactoryMethod {

	@Test
	public void testFactoryMethod() {
		String data = "";
		ExportFactory exportFactory = new ExportHtmlFactory();
		ExportFile ef = exportFactory.factory("financial");
		ef.export(data);
	}

}
