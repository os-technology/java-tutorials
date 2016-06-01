/**
 * 
 */
package cn.aposoft.design.patterns.demos.martin.agile.extensionObject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author LiuJian
 *
 */
public class BomXmlCreationTest extends BomXmlTest {
	@Test
	public void createPart() {
		assertEquals("997624", p1.getPartNumber());
		assertEquals("MyPart", p1.getDescription());
		assertEquals(3.20d, p1.getCost(), 0.01d);
	}

	@Test
	public void createAssembly() {
		assertEquals("5879", a.getPartNumber());
		assertEquals("MyAssembly", a.getDescription());
	}

	@Test
	public void assembly() {
		a.add(p1);
		a.add(p2);
		assertEquals(2, a.getParts().size());
		assertEquals(a.getParts().get(0), p1);
		assertEquals(a.getParts().get(1), p2);
	}

	@Test
	public void assemblyOfAssemblies() {
		Assembly subAssembly = new Assembly("1234", "SubAssembly");
		subAssembly.add(p1);
		a.add(subAssembly);

		assertEquals(subAssembly, a.getParts().get(0));
	}
}
