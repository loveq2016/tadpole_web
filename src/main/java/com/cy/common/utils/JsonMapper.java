package com.cy.common.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * json字符串映射类
 * Created by KAM on 2015/12/11.
 */
public class JsonMapper {

    static private Class listClass = ArrayList.class;
    static private Class mapClass = HashMap.class;

    /**
     * 返回json格式字符串
     *
     * @param response
     * @param obj
     */
    public static void renderJsonStr(HttpServletResponse response, Object obj) {
        String JsonStr = null;
        response.setCharacterEncoding("utf-8");
        if (listClass.isInstance(obj) || mapClass.isInstance(obj)) {
            JsonStr = JSONArray.toJSON(obj).toString();
        } else if (mapClass.isInstance(obj)) {
            JsonStr = JSONObject.toJSON(obj).toString();
        }
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.print(JsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    /**
     * 返回字符串
     *
     * @param response
     * @param obj
     */
    public static void renderStr(HttpServletResponse response, Object obj) {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.print(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }


}
