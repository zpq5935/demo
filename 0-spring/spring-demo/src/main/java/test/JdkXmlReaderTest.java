package test;

import org.junit.Test;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Field;
import java.util.Arrays;

public class JdkXmlReaderTest {
    static Field[] nodeFields = Node.class.getDeclaredFields();

    //用Element方式
    public static void element(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            NodeList childNodes = element.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    //获取节点
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    //获取节点值
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }


    public static String getNodeTypeName(short fieldVal) {
        for (Field field : nodeFields) {
            try {
                if (field.get(Node.class).equals(fieldVal))
                    return field.getName() + ":" + fieldVal;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return "unKnow";
    }

    public static void node(NodeList list, int depth) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            char[] prefix = new char[depth];
            for (int k = 0; k < depth; k++) {
                prefix[k] = '\t';
            }
            System.out.println(Arrays.toString(prefix).substring(1, prefix.length + 1) + "depth" + depth + "->" + getNodeTypeName(node.getNodeType()) + "->" + node.toString());
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null && attributes.getLength() > 0) {
                for (int ai = 0; ai < attributes.getLength(); ai++) {
                    Node attribute = attributes.item(ai);
                    System.out.println(Arrays.toString(prefix).substring(1, prefix.length + 1) + "attribute:" + attribute.getNodeName() + "=" + attribute.getNodeValue());
                }
            }
            NodeList childNodes = node.getChildNodes();
            if (childNodes != null && childNodes.getLength() > 0)
                node(childNodes, depth + 1);
        }
    }

    public static void main(String[] args) {
        //1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("src/main/resources/applicationContextCycle.xml");
//            Document d = builder.parse("src/main/resources/demo.xml");
//            NodeList sList = d.getElementsByTagName("student");
            NodeList sList = d.getDocumentElement().getChildNodes();

//            element(documentElement);
            node(sList, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
