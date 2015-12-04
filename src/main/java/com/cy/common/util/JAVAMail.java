package com.cy.common.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 发送邮件
 * Created by kam on 2015/10/26.
 */
public class JAVAMail {
    public static void send(String targetAddress, String title, String content) throws MessagingException {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.163.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 设置环境信息
        Session session = Session.getInstance(props);

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        msg.setSubject(title);
        // 设置邮件内容
        msg.setContent(content, "text/html;charset=utf-8");
//        msg.setText(content);
        // 设置发件人
        msg.setFrom(new InternetAddress("13710414456@163.com"));
        Transport transport = session.getTransport();
        // 连接邮件服务器
        transport.connect("13710414456", "xudan930318.");
        // 发送邮件
        transport.sendMessage(msg, new Address[]{new InternetAddress(targetAddress)});
        // 关闭连接
        transport.close();
    }
}
