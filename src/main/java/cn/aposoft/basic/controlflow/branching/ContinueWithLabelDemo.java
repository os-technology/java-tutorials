package cn.aposoft.basic.controlflow.branching;

public class ContinueWithLabelDemo {
	public static void main(String[] args) {

		String searchMe = "Look for a substring in me";
		String substring = "sub";
		boolean foundIt = false;

		int max = searchMe.length() - substring.length();

		// label : test
		test: for (int i = 0; i <= max; i++) {
			int n = substring.length();
			int j = i;
			int k = 0;
			while (n-- != 0) {
				if (searchMe.charAt(j++) != substring.charAt(k++)) {
					// continue: test
					continue test;
				}
			}
			foundIt = true;
			break test;
		}
		// end of label : test
		System.out.println(foundIt ? "Found it" : "Didn't find it");
	}

}
