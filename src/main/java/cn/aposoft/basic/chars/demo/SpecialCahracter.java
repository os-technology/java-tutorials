package cn.aposoft.basic.chars.demo;

public class SpecialCahracter {

	/**
	 * 主入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = getName();
		System.out.println(s.substring(7).length());
	}

	public static String getName() {
		return "VERSION";
	}
}
