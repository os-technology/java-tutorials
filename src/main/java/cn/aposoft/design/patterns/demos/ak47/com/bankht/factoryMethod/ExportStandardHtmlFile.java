package cn.aposoft.design.patterns.demos.ak47.com.bankht.factoryMethod;

/**
 * 
 * @创建时间：2012-6-19 下午02:54:54
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：导出标准HTML文件
 */
public class ExportStandardHtmlFile implements ExportFile {

	@Override
	public boolean export(String data) {
		/**
		 * 业务逻辑
		 */
		System.out.println("导出标准HTML文件");
		return true;
	}

}
