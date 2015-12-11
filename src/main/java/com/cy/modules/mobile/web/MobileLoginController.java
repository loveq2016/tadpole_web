package com.cy.modules.mobile.web;

import com.cy.common.utils.JsonMapper;
import com.cy.common.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * 移动端控制器
 * Created by KAM on 2015/12/11.
 */
@RequestMapping("/mobile")
@Controller
public class MobileLoginController {

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " : " + password);
        JsonMapper.renderStr(response, "successfullly!");
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public void sign(HttpServletRequest request, HttpServletResponse response) {
        String jsonStr = request.getParameter("jsonStr");
        Map map = JsonUtil.toMap(jsonStr);
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        JsonMapper.renderStr(response, "successfullly!");
    }
}
