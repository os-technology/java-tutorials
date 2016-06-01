package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.wukong;

/**
 * @创建时间：2012-6-26 上午09:30:32
 * 
 * @author: 特种兵—AK47
 * 
 * @类说明 ：客户端类
 */
public class Client {

	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();
		// 第一种写法
		TheGreatestSage bird = new Bird(sage);
		
		TheGreatestSage fish = new Fish(sage);
		// 第二种写法
		// TheGreatestSage fish = new Fish(new Bird(sage));
		fish.move();
		bird.move();
	}

}