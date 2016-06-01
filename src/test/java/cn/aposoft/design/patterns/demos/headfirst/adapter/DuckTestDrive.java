/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.adapter;

/**
 * @author LiuJian
 *
 */
public class DuckTestDrive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyToDuckAdapter(turkey);
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
		System.out.println("\nThe Duck says...");
		testDuck(duck);
		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
	}

	private static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}

}
