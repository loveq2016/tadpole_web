package com.cy.modules.sys.listener;

import com.cy.common.util.SessionContext;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * session监听类
 * Created by kam on 2015/10/18.
 */
public class SessionListener implements HttpSessionListener {
    public static SessionContext sessionContext = SessionContext.getInstance();

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sessionContext.AddSession(httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionContext.DelSession(httpSessionEvent.getSession());
    }
}