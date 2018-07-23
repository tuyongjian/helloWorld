package com.tu.javaMail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

/**
 * Created by tuyongjian on 2018/7/20.
 */
public class javaMail {

    public static void main(String[] args) throws Exception {
        Session session = javaMailUtil.createSession();
        //通过session得到transport对象
        Transport ts = session.getTransport();
        //使用邮箱的用户名和密码连上邮件服务器，发送邮件时，
        // 发件人需要提交邮箱的用户名和密码给smtp服务器，
        // 用户名和密码都通过验证之后才能够正常发送邮件给收件人
        //这里的密码不能是明文，要在自己的邮箱账户里面开启允许第三方客户端去发送邮件，并且生成一个密码在这里使用
        ts.connect("smtp.qq.com","","");
        //创建邮件
        // Message message = javaMailUtil.createTextMail(session,"tutu","","");
        //Message message = javaMailUtil.createImageMail(session,"tutu","","");
       // Message message = javaMailUtil.createAttachMail(session,"tutu","","");
        Message message = javaMailUtil.createMixMail(session,"tutu","","");
        //发送邮件
        ts.sendMessage(message,message.getAllRecipients());
        ts.close();

    }


}
