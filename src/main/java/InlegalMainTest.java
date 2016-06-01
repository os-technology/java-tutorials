import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 */

/**
 * @author LiuJian
 * 
 */
public class InlegalMainTest {

	/**
	 * public static void main(String[] args) : true
	 * <p>
	 * static public void main(String[] args) : true
	 * <p>
	 * public final static void main(String... args) : true
	 * <p>
	 * public static void main(String... args) :true
	 * <p>
	 * public static void main(String args[]) : true
	 * <p>
	 * static void main(String[] args) : false
	 * <p>
	 * public void main(String[] args) : false
	 * <p>
	 * public static int main(String[] args) : false
	 * <p>
	 * public static int main(String[] args) : false
	 * <p>
	 * public static void Main(String[] args) : false
	 * <p>
	 * public static void main(String args...) : false
	 * <p>
	 * final static public void main(String... args) : true
	 * @param args
	 */
	final static public void main(String... args) {
		System.out.println("test");
		String[] arr = new String[10];
		System.out.println(arr.length);
		// Class implements List interface synchronized
		// Interface
		// Interface

		String str = "01234567890";
		System.out.println(str.substring(0, 5));

	}

	public void testExceptionInheritences() {
		try {
			throw new FileNotFoundException();
		} catch (IOException e) {

		}
		// Unreachable catch block for EOFException.
		// It is already handled by the catch block for IOException
		// catch(EOFException eofe)
		// {}
	}
}
