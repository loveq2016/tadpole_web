package com.cy.modules.sys.web;

import com.cy.modules.sys.entity.User;
import com.cy.modules.sys.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 登录控制器
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    @Resource
    private UserService userService;
    private Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 显示登陆界面
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session, ModelAndView model) throws Exception {
        System.out.println("ok");
     /*   User user = userService.getEntityById("1");
        BeanInfo bif = Introspector.getBeanInfo(User.class);
        PropertyDescriptor pds[] = bif.getPropertyDescriptors();
        for(PropertyDescriptor pd:pds){
            String name = pd.getName();
            Method method = pd.getReadMethod();
            Object value = method.invoke(user);
            System.out.println(name + ":" + value.toString());
        }
        model.setViewName("signin");
        return model;*/
        return null;
    }

}
