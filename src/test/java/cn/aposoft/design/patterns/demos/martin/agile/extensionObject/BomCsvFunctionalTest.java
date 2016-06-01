/**
 * 
 */
package cn.aposoft.design.patterns.demos.martin.agile.extensionObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * 
 * @author LiuJian
 */
public class BomCsvFunctionalTest extends BomXmlTest {

	@Test
	public void piecePart1toCsv() {
		PartExtension e = p1.getExtension("CSV");
		CsvPartExtension ce = (CsvPartExtension) e;
		String csv = ce.getCsvText();
		assertEquals("PiecePart,997624,MyPart,3.2", csv);
	}

	@Test
	public void piecePart2toCsv() {
		PartExtension e = p2.getExtension("CSV");
		CsvPartExtension ce = (CsvPartExtension) e;
		String csv = ce.getCsvText();
		assertEquals("PiecePart,7734,Hell,666.0", csv);
	}

	@Test
	public void simpleAssemblyCsv() {
		PartExtension e = p2.getExtension("CSV");
		CsvPartExtension ce = (CsvPartExtension) e;
		String csv = ce.getCsvText();
		assertEquals("PiecePart,7734,Hell,666.0", csv);
	}

	@Test
	public void assemblyWithPartsCsv() {
		a.add(p1);
		a.add(p2);
		PartExtension e = a.getExtension("CSV");
		CsvAssemblyExtension ce = (CsvAssemblyExtension) e;
		String csv = ce.getCsvText();
		String expect = "Assembly,5879,MyAssembly,{PiecePart,997624,MyPart,3.2},{PiecePart,7734,Hell,666.0}";
		assertEquals(expect, csv);
	}

	@Test
	public void badExtension() {
		PartExtension pe = p1.getExtension("ThisStringDoesn'tMatchAnyException");
		assertTrue(pe instanceof BadPartExtension);
	}
}
