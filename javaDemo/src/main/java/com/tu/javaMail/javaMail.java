package com.tu.javaMail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by tuyongjian on 2018/7/20.
 */
public class javaMail {

    public  static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        //创建Session
        Session session =Session.getInstance(prop);
        //开启Session 的debug 这样就可以查看程序发送email的过程
        session.setDebug(true);
        //通过session得到transport对象
        Transport ts = session.getTransport();
        //使用邮箱的用户名和密码连上邮件服务器，发送邮件时，
        // 发件人需要提交邮箱的用户名和密码给smtp服务器，
        // 用户名和密码都通过验证之后才能够正常发送邮件给收件人

        //这里的密码不能是明文，要在自己的邮箱账户里面开启允许第三方客户端去发送邮件，并且生成一个密码在这里使用
        ts.connect("smtp.qq.com","","");
        //创建邮件
        Message message = createTextMail(session);
        //发送邮件
        ts.sendMessage(message,message.getAllRecipients());
        ts.close();

    }

    /**
     * 一个包含文本的邮件发送
     * @param session
     * @return
     */
    public static MimeMessage createTextMail(Session session) throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //设置自定义发件人昵称
        String nick="";
        try {
            nick=javax.mail.internet.MimeUtility.encodeText("国泰君安");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //指明发件人
        String from = "";
        message.setFrom(new InternetAddress(nick+" <"+from+">"));

        //指明收件人
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(""));
        //邮件标题
        message.setSubject("面试通知");
        //邮件内容
        message.setContent("杨幸运你好，请于7月23号到我司进行Java高级工程师面试，谢谢","text/html;charset=UTF-8");
        return message;
    }
}
