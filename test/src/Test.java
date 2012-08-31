import java.io.File;
import java.util.List;

import org.dom4j.Element;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //System.out.println(ClipUtil.getSysClipboardText());
		 List<Element> list = XMLParse.getDestElement(XMLParse.getXmlDocument(new File(
				"C:\\Users\\shuchen\\Desktop\\XML Template\\de-de.lex")), 1);
		 Element element = list.get(0);
		 List<Element> elts = element.elements("element");
		 if(elts == null) System.out.println("null");
		 else System.out.println(elts.size());
			for(int k = 0; k < elts.size(); k++) {
				Element e1 = elts.get(k);
				if(e1.attributeValue("is-core").equals("true")) {
					Element variant = e1.element("variant");
					Element le = variant.element("le");
					System.out.println("internal ID attr1:" + le.attributeValue("internal-id"));
					//internalID = le.attributeValue("internal-id");
					
					le.setAttributeValue("internal-id", "1");
					System.out.println("internal ID attr2:" + le.attributeValue("internal-id"));
					break;
				}
				
			}
		String priority = element.attributeValue("priority");
		System.out.println(priority);
	}

}
