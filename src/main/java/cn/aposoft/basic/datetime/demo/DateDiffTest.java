/**
 * 
 */
package cn.aposoft.basic.datetime.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 本测试用例用来验证JAVA的时间数字位置 经验证:
 * <p>
 * Java new Date(0L) = 0 时间: 1970-01-01 00:00:00.000
 * <p>
 * Java new Date(0,0,0) = -2209104000000 时间:1899-12-31 00:00:00.000
 * <p>
 * Java new Date(0,0,1) = -2209017600000 时间:1900-01-01 00:00:00.000
 * 
 * @author LiuJian
 *
 */
public class DateDiffTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date0L = new Date(0L);
		System.out.println(format.format(date0L) + "," + date0L.getTime());
		@SuppressWarnings("deprecation")
		Date date000 = new Date(0, 0, 0);
		System.out.println(format.format(date000) + "," + date000.getTime());
		@SuppressWarnings("deprecation")
		Date date001 = new Date(0, 0, 1);
		System.out.println(format.format(date001) + "," + date001.getTime());
	}

}
