package com.yss.server.servlet;

import com.yss.server.basic.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 解析XML
 *
 * @author: duhao
 * @date: 2020/6/20 15:54
 */
public class XmlTest02 {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂获取解析器
        SAXParser parser = factory.newSAXParser();
        //3.加载文档Document 注册处理器
        //4.编写处理器
        WebHandler handler = new WebHandler();
        //5. 解析
        //String str ="D:\develop\Java\ideaProjects\MyLearning\webservice\src\main\java\com\yss\server\p.xml";
        //FileInputStream fileInputStream = new FileInputStream(str);
        parser.parse(Thread.currentThread()
                     .getContextClassLoader()
                     .getResourceAsStream("web.xml"), handler);
        //  parser.parse(fileInputStream,handler);
        //获取数据
        WebContext webContext = new WebContext(handler.getEntitys(), handler.getMappings());

    }
}

//可以看下DefaultHandler 中的方法 看下DefaultHandler 的API
class WebHandler extends DefaultHandler {
    private List<Entity> entitys;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String tag;//存储操作标签
    private boolean isMapping = false;

    // 里面有开始解析的方法
    @Override
    public void startDocument() throws SAXException {
        //  System.out.println("解析文档开始...");
        entitys = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    // 开始解析元素
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println(qName+"--->解析开始");
        tag = qName; //存储
        if (null != qName) {
            if (tag.equals("servlet")) {
                entity = new Entity();
                isMapping = false;
            } else if (tag.equals("servlet-mapping")) {
                mapping = new Mapping();
                isMapping = true;
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (null != tag) { //处理空

            if (isMapping) {//操作servlet-mapping
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(contents);

                }
            } else {// 操作 servlet
                if (tag.equals("servlet-name")) {
                    entity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                        entity.setClz(contents);

                }
            }

        }
    }

    // 结束解析元素
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //     System.out.println(qName+"--->解析结束");
        if (null != qName) {
            if (qName.equals("servlet")) {
               entitys.add(entity);
            }else if (qName.equals("servlet-mapping")){
                mappings.add(mapping);
            }
            tag = null;//tag 丢弃掉
        }
    }

    // 结束解析
    @Override
    public void endDocument() throws SAXException {
        //   System.out.println("解析文档结束...");
    }

    public List<Entity> getEntitys() {
        return entitys;
    }


    public List<Mapping> getMappings() {
        return mappings;
    }
}