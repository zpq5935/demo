package readXml_Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class jDomReadXml {
	/**
	 * JDOM包读取xml
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(new File("ttReadXml.xml"));
			Element rootE = document.getRootElement();
			List list = rootE.getChildren();
			for (int i = 0; i < list.size(); i++) {
				Element element2 = (Element) list.get(i);
				System.out.println(element2.getChildText("NO"));
				System.out.println(element2.getChildText("ADDR"));
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
