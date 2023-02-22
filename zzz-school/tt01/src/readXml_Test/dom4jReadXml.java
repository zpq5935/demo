package readXml_Test;

import java.io.File;
import java.util.Iterator;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class dom4jReadXml {
	/**
	 * 通过dom4j包读取xml文件
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File("ttReadXml.xml");
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(file);
			Element root =  document.getRootElement();
			for(Iterator<Element> it=root.elementIterator();it.hasNext();){
				Element element= it.next();
				System.out.println(element.elementText("NO"));
				System.out.println(element.elementText("ADDR"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
