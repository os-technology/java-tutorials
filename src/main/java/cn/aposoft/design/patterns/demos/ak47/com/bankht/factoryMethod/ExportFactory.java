package cn.aposoft.design.patterns.demos.ak47.com.bankht.factoryMethod;

/**
 * @创建时间：2012-6-19 下午02:53:10
 * <p>
 * 
 * @author: 特种兵—AK47
 * 
 * 
 * @类说明 ：抽象工厂角色
 */
public interface ExportFactory {
	public ExportFile factory(String type);
}
