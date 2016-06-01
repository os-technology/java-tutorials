/**
 * 
 */
package cn.aposoft.design.patterns.demos.martin.agile.extensionObject;

/**
 * 
 * @author LiuJian
 *
 */
public class XmlText extends XmlElement {
	private String text;

	public XmlText(String text) {
		super("");
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return this.text;
	}
}
