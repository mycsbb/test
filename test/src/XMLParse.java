import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;


public class XMLParse {
	 public static Document getXmlDocument(File file)
	 {
	  Document doc = null;
	  SAXReader reader = new SAXReader();
	  try {
	   doc = reader.read(file);
	  } catch (DocumentException e) {
	   System.out.println("文件格式错误，必须是标准XML格式！");
	   e.printStackTrace();
	  }
	  return doc;
	 }
	 
	 public static List<Element> getDestElement(Document doc,int i)
	 {
	  HashMap xmlMap = new HashMap();
	  xmlMap.put("lex","http://ns.adobe.com/lex");
	  XPath xpath=doc.createXPath("//lex:domain-context");
	  xpath.setNamespaceURIs(xmlMap);
	  return  (List<Element>)xpath.selectNodes(doc);
	 }
	 
	 
	 
}
