package com.tu.javaMail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by tuyongjian on 2018/7/23.
 */
public class javaMailUtil {


    /**
     * 得到Session
     * @return
     * @throws Exception
     */
    public static Session createSession() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        //创建Session
        Session session =Session.getInstance(prop);
        //开启Session 的debug 这样就可以查看程序发送email的过程
        session.setDebug(true);
        return session;

    }


    /**
     * 一个包含文本的邮件发送
     * @param session
     * @return
     */
    public static MimeMessage createTextMail(Session session,String nickName,String  from,String to) throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //设置自定义发件人昵称
        String nick="";
        try {
            nick=javax.mail.internet.MimeUtility.encodeText(nickName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //指明发件人
        message.setFrom(new InternetAddress(nick+" <"+from+">"));

        //指明收件人
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
        //邮件标题
        message.setSubject("面试通知");
        //邮件内容
        message.setContent("杨幸运你好，请于7月23号到我司进行Java高级工程师面试，谢谢","text/html;charset=UTF-8");
        return message;
    }


    /**
     * 发送带图片的邮件
     * @param session
     * @param nickName
     * @param from
     * @param to
     * @return
     * @throws Exception
     */
    public static MimeMessage createImageMail(Session session,String nickName,String from,String to) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //设置自定义发件人昵称
        String nick="";
        try {
            nick=javax.mail.internet.MimeUtility.encodeText(nickName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //指明发件人
        message.setFrom(new InternetAddress(nick+" <"+from+">"));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //邮件标题
        message.setSubject("带图片的邮件");

        // 准备邮件数据
        // 准备邮件正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:test.jpg'>的邮件", "text/html;charset=UTF-8");
        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("G:\\working\\HelloWorld\\javaDemo\\src\\main\\test.jpg"));
        image.setDataHandler(dh);
        image.setContentID("test.jpg");
        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        message.setContent(mm);
        message.saveChanges();
        //将创建好的邮件写入到E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
        //返回创建好的邮件
        return message;
    }


    /**
     * 发送带附件的邮件
     * @param session
     * @param nickName
     * @param from
     * @param to
     * @return
     * @throws Exception
     */
    public static MimeMessage createAttachMail(Session session,String nickName,String from,String to) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //设置自定义发件人昵称
        String nick="";
        try {
            nick=javax.mail.internet.MimeUtility.encodeText(nickName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //指明发件人
        message.setFrom(new InternetAddress(nick+" <"+from+">"));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //邮件标题
        message.setSubject("带附件的邮件");

        // 准备邮件数据
        // 准备邮件正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("使用JavaMail创建的带附件的邮件", "text/html;charset=UTF-8");
        // 准备图片数据
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("G:\\working\\HelloWorld\\javaDemo\\src\\main\\test.jpg"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());
        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(attach);
        mm.setSubType("mixed");

        message.setContent(mm);
        message.saveChanges();
        //将创建好的邮件写入到E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
        //返回创建好的邮件
        return message;
    }



    /**
     * 发送图片和附件的混合的邮件
     * @param session
     * @param nickName
     * @param from
     * @param to
     * @return
     * @throws Exception
     */
    public static MimeMessage createMixMail(Session session,String nickName,String from,String to) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //设置自定义发件人昵称
        String nick="";
        try {
            nick=javax.mail.internet.MimeUtility.encodeText(nickName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //指明发件人
        message.setFrom(new InternetAddress(nick+" <"+from+">"));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //邮件标题
        message.setSubject("附件和图片混合邮件");

        // 准备邮件数据
        //正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("测试<br/><img src='cid:test.jpg'>","text/html;charset=UTF-8");
        // 准备图片数据
        //图片
        MimeBodyPart image = new MimeBodyPart();
        image.setDataHandler(new DataHandler(new FileDataSource("G:\\working\\HelloWorld\\javaDemo\\src\\main\\test.jpg")));
        image.setContentID("test.jpg");

        //附件1
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("G:\\working\\HelloWorld\\javaDemo\\src\\main\\4.rar"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());

        //描述关系:正文和图片
        MimeMultipart mp1 = new MimeMultipart();
        mp1.addBodyPart(text);
        mp1.addBodyPart(image);
        mp1.setSubType("related");

        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(attach);

        //代表正文的bodypart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mp1);
        mm.addBodyPart(content);
        mm.setSubType("mixed");

        message.setContent(mm);
        message.saveChanges();

        //将创建好的邮件写入到E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
        //返回创建好的邮件
        return message;
    }
}
