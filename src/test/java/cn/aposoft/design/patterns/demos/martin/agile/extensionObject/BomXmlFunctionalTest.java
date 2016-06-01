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
public class BomXmlFunctionalTest extends BomXmlTest {
	private String getChildText(XmlElement element, String childName) {
		return getChild(element, childName).getInnerText();
	}

	private XmlElement getChild(XmlElement element, String childName) {
		XmlNodeList children = element.getElementsByTagName(childName);
		return (XmlElement) children.getItem(0);
	}

	@Test
	public void piecePart1Xml() {
		PartExtension e = p1.getExtension("XML");
		XmlPartExtension xe = (XmlPartExtension) e;
		XmlElement xml = xe.getXmlElement();
		assertEquals("PiecePart", xml.getName());
		assertEquals("997624", getChildText(xml, "PartNumber"));
		assertEquals("MyPart", getChildText(xml, "Description"));
		// double 相等有精度要求
		assertEquals(3.2d, Double.valueOf(getChildText(xml, "Cost")).doubleValue(), .01d);
	}

	@Test
	public void piecePart2Xml() {
		PartExtension e = p2.getExtension("XML");
		XmlPartExtension xe = (XmlPartExtension) e;
		XmlElement xml = xe.getXmlElement();
		assertEquals("PiecePart", xml.getName());
		assertEquals("7734", getChildText(xml, "PartNumber"));
		assertEquals("Hell", getChildText(xml, "Description"));
		assertEquals(666, Double.parseDouble(getChildText(xml, "Cost")), 0.01d);
	}

	@Test
	public void simpleAssemblyXml() {
		PartExtension e = a.getExtension("XML");
		XmlAssemblyExtension xe = (XmlAssemblyExtension) e;
		XmlElement xml = xe.getXmlElement();
		assertEquals("Assembly", xml.getName());
		assertEquals("5879", getChildText(xml, "PartNumber"));
		assertEquals("MyAssembly", getChildText(xml, "Description"));
		XmlElement parts = getChild(xml, "Parts");
		XmlNodeList partList = parts.getChildNodes();
		assertEquals(0, partList.size());
	}

	@Test
	public void assemblyWithPartsXml() {
		a.add(p1);
		a.add(p2);
		PartExtension e = a.getExtension("XML");
		XmlPartExtension xe = (XmlPartExtension) e;
		XmlElement xml = xe.getXmlElement();
		assertEquals("Assembly", xml.getName());
		assertEquals("5879", getChildText(xml, "PartNumber"));
		assertEquals("MyAssembly", getChildText(xml, "Description"));

		XmlElement parts = getChild(xml, "Parts");
		XmlNodeList partList = parts.getChildNodes();
		XmlElement partElement = partList.getItem(0);
		assertEquals("PiecePart", partElement.getName());
		assertEquals("997624", getChildText(partElement, "PartNumber"));
		partElement = partList.getItem(1);

		assertEquals("PiecePart", partElement.getName());
		assertEquals("7734", getChildText(partElement, "PartNumber"));
	}

}
