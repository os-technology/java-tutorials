/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.iterator;

import java.util.Iterator;

/**
 * @author LiuJian
 *
 */
public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu cafeMenu;

	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		// System.out.println("MENU\n----\nBREAKFAST");
		printIterableMenu(pancakeHouseMenu);
		// System.out.println("\nLUNCH");
		printIterableMenu(dinerMenu);
		// System.out.println("\nDINNER");
		printIterableMenu(cafeMenu);

		//
		// Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.iterator();
		// Iterator<MenuItem> dinerIterator = dinerMenu.iterator();
		// Iterator<MenuItem> cafeIterator = cafeMenu.iterator();
		// System.out.println("MENU\n----\nBREAKFAST");
		// printMenu(pancakeIterator);
		// System.out.println("\nLUNCH");
		// printMenu(dinerIterator);
		// System.out.println("\nDINNER");
		// printMenu(cafeIterator);
	}

	private void printIterableMenu(Menu menu) {
		for (MenuItem item : menu) {
			printItem(item);
		}
		printMenu(menu.iterator());
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			printItem(menuItem);
		}

	}

	private void printItem(MenuItem item) {
		System.out.print(item.getName() + ", ");
		System.out.print(item.getPrice() + " -- ");
		System.out.println(item.getDescription());
	}
	// other methods here
}
