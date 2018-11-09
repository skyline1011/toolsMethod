package com.lsrobot.utils;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * DOM4j XML 工具类
 */
public class XmlUtil {
    /**
     * 通过文件的路径获取xml的document对象
     * @param filePath：文件的路径
     * @return：返回文档对象
     */
    public static Document getXMLByFilePath(String filePath){
        String xmlName = "src/main/resources/" + filePath + ".xml";
        if(filePath=="" || null==filePath){
            return null;
        }
        // 创建SAXReader的对象reader
        SAXReader sax = new SAXReader();
        // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
        Document read = null;
        try {
            read = sax.read(xmlName);
            return read;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param doc：文档对象
     * @param testCase：测试方法名称，约定：在测试类中测试方法名称与xml文件中定义的名称一致
     * @param xpath：节点名称
     * @return：string类型，对应节点名称的值
     */
    public static String getData(Document doc,String testCase,String xpath) {
        if (null != doc) {
            // 通过document对象获取根节点bookstore
            Element element = doc.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = element.elementIterator();
            // 遍历迭代器，获取根节点中的信息
            while (it.hasNext()) {
                System.out.println("=====开始获取testCase中的属性=====");
                Element caseName = (Element) it.next();
                // 获取caseName的属性名以及 属性值
                List<Attribute> cases = caseName.attributes();
                for(Attribute attr : cases){
                    System.out.println("属性名：" + attr.getName() + "--属性值：" + attr.getValue());
                }
                Iterator itt = caseName.elementIterator();
                while (itt.hasNext()) {
                    Element caseChild = (Element) itt.next();
                    if(xpath.equals(caseChild.getName())){
                        return caseChild.getStringValue().trim();
                    }
                }
            }
        }
        return "";
    }

    @Test
    public void input(){
        Method[] methods = XmlUtil.class.getMethods();
        for(Method m : methods){
            System.out.println(m.toString());
        }
        System.out.println("----------------------------------------");
        String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();//input
        System.out.println("class name: " + clazz + " Method Name： " + method);
    }

    public static void main(String[] args) {
        String name = "input";
        Document doc = getXMLByFilePath(name);
        System.out.println(doc.getName());
        String author = getData(doc,"addNewId","workUnit");
        System.out.println("+++++++++++++"+author);
    }
}
