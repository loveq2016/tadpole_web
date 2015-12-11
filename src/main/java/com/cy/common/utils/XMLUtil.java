package com.cy.common.utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Date;

/**
 * xml文档操作类
 * Created by KAM on 2015/11/16.
 */
public class XMLUtil {
    String path; // 文档路径
    char formatFlag = 1; // 文档输出格式类型 0 : 优美型; 1 : 紧凑型;
    Document doc = null;
    XMLUtil(String path, char formatFlag) {
        this.path = path;
        this.formatFlag = formatFlag;
    }

    XMLUtil(String path) {
        this.path = path;
    }

    /**
     * 加载文档
     *
     * @return
     */
    public Document load() {
        try {
            SAXReader saxReader = new SAXReader();
            doc = saxReader.read(new File(path)); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return doc;
    }

    /**
     * 创建文档
     *
     * @param rootName
     * @param comment
     * @throws Exception
     */
    public Element createDoc(String rootName, String comment) throws Exception {
        doc = DocumentHelper.createDocument();
        Element root = doc.addElement(rootName);
        root.addComment(comment);
        return root;
    }

    /**
     * 保存文档
     *
     * @throws Exception
     */
    public void saveDoc() throws Exception {
        // 输出格式
        OutputFormat format = (formatFlag == 0) ? OutputFormat.createPrettyPrint() : OutputFormat.createCompactFormat();
        //OutputFormat format = (formatFlag == 0) ?   new OutputFormat("    ", true) : OutputFormat.createCompactFormat();
        format.setEncoding("utf-8");

        // 输出文件，记得要调用flush()方法,否则输出的文件中显示空白
        XMLWriter xmlWriter = new XMLWriter(new FileWriter(path), format);
        xmlWriter.write(doc);
        xmlWriter.flush(); // close()方法也可以
    }

    public static void main(String[] args) throws Exception {
        XMLUtil xu = new XMLUtil("F:\\enterprise_gbk\\src\\main\\resources\\test02.xml", '0');
        Element root = xu.createDoc("root", "createBy kam ; createDate "+new Date() );
        Element record = root.addElement("table").addElement("record");
        xu.saveDoc();
    }
}
