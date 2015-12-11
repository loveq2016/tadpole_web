package com.cy.common.utils;


import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * xml存储类
 * Created by KAM on 2015/11/17.
 */
public class XMLStorage {
    XMLUtil xmlUtil = null;
    XMLStorage(String path){
        xmlUtil = new XMLUtil(path);
    }

    public <T> void insertRecord(T entity) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        BeanInfo bif = Introspector.getBeanInfo(entity.getClass());
        PropertyDescriptor pds[] = bif.getPropertyDescriptors();
        for(PropertyDescriptor pd:pds){
            //map.put()
            System.out.println(pd.getName());
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
