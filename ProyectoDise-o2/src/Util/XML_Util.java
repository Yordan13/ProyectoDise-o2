package Util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XML_Util {

    public static ArrayList<String> getTextValuesByTagName(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            list.add(getTextValue(nodeList.item(i)));
        }
        return list;
    }

    private static String getTextValue(Node node) {
        StringBuilder textValue = new StringBuilder();
        int length = node.getChildNodes().getLength();
        for (int i = 0; i < length; i++) {
            Node c = node.getChildNodes().item(i);
            if (c.getNodeType() == Node.TEXT_NODE) {
                textValue.append(c.getNodeValue());
            }
        }
        return textValue.toString().trim();
    }
    
    public static ArrayList<String> parsearXML(String pTagName, String pXml) throws ParserConfigurationException, SAXException, IOException {
        
        String tagName = pTagName;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(pXml)));
        Element rootElement = document.getDocumentElement();
        ArrayList<String> result = getTextValuesByTagName(rootElement, tagName);
        
        return result;
        
    }
}
