package com.yss.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

/**解析XML
 * @author: duhao
 * @date: 2020/6/20 15:54
 */
public class XmlTest01 {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂获取解析器
        SAXParser parser = factory.newSAXParser();
        //3.加载文档Document 注册处理器
        //4.编写处理器
        PHandler handler = new PHandler();
        //5. 解析
         //String str ="D:\develop\Java\ideaProjects\MyLearning\webservice\src\main\java\com\yss\server\p.xml";
        //FileInputStream fileInputStream = new FileInputStream(str);
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"),handler);
      //  parser.parse(fileInputStream,handler);
        //获取数据
        List<Person> persons=handler.getPersons();
        for (Person p : persons) {
            System.out.println(p.getName()+"--"+p.getAge());
        }
    }
}
//可以看下DefaultHandler 中的方法 看下DefaultHandler 的API
class PHandler extends DefaultHandler{
    private List<Person> persons;
    private  Person person;
    private String tag;//存储操作标签

   // 里面有开始解析的方法
    @Override
    public void startDocument() throws SAXException {
      //  System.out.println("解析文档开始...");
        persons=new ArrayList<Person>();
    }
   // 开始解析元素
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println(qName+"--->解析开始");
        tag=qName; //存储
        if (null!=qName){
            if (tag.equals("person")){
                person=new Person();
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents= new String(ch,start,length).trim();
        if (null!=tag) { //处理空

            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                if (contents.length() > 0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    // 结束解析元素
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
   //     System.out.println(qName+"--->解析结束");
       if (null!=qName) {
           if (qName.equals("person")) {
               persons.add(person);
           }
           tag = null;//tag 丢弃掉
       }
    }
    // 结束解析
    @Override
    public void endDocument() throws SAXException {
     //   System.out.println("解析文档结束...");
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}