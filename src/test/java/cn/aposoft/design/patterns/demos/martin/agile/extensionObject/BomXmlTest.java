package cn.aposoft.design.patterns.demos.martin.agile.extensionObject;

import org.junit.Before;

public abstract class BomXmlTest {
	protected PiecePart p1;
	protected PiecePart p2;
	protected Assembly a;

	@Before
	public void setUp() {
		p1 = new PiecePart("997624", "MyPart", 3.20);
		p2 = new PiecePart("7734", "Hell", 666);
		a = new Assembly("5879", "MyAssembly");
	}

	public static void main(String[] args) {
		BomXmlTest test = new BomXmlTest() {
		};
		test.setUp();
		testPieceParts(test);
	}

	private static void testPieceParts(BomXmlTest test) {
		testPiecePart(test.p1);
		testPiecePart(test.p2);
	}

	/**
	 * 
	 * @param p
	 */
	private static void testPiecePart(PiecePart p) {
		testAttribute(p);
		testExtension(p);
	}

	private static void testExtension(PiecePart p) {
		XmlPartExtension xml = (XmlPartExtension) p.getExtension("XML");
		System.out.println(xml);
		testXmlPartExtension(xml);
	}

	private static void testXmlPartExtension(XmlPartExtension xml) {
		System.out.println(xml.getXmlElement());
	}

	private static void testAttribute(PiecePart p) {
		System.out.println(p.getPartNumber());
		System.out.println(p.getDescription());
		System.out.println(p.getCost());
	}
}
