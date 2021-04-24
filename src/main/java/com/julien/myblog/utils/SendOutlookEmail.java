package com.julien.myblog.utils;

/**
 * @author @julien
 * @version 1.0
 * @date 2020/9/22 13:36
 * @function
 */

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;


public class SendOutlookEmail {
    static String  USER_NAME   ="mshk@lim8639.onmicrosoft.com";
    static String  PASSWORD    = "092611@lim";

    /**
     * 发送outlook邮箱
     * @param to
     * @param text
     * @param title
     * @return
     */
    public static boolean sendSMTPMail(String to, String text, String title) {
        String host = "smtp.office365.com";
        String mailStoreType = "smtp";
        String popPort = "587";
        final Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.store.protocol", mailStoreType);
        props.put( "mail.smtp.port", popPort );
        //开启SSL
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port",popPort);
        props.put("mail.smtp.socketFactory.fallback","false");
        try {
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER_NAME, PASSWORD);//账号密码
                }
            });
            session.setDebug(false);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(session);
            // 设置发件人
            InternetAddress form = new InternetAddress(USER_NAME);
            message.setFrom(form);
            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            // 设置邮件标题
            message.setSubject(title);
            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 发送qq邮箱
     * @param EmailAdress
     * @param text
     * @param title
     * @throws MessagingException
     * @throws GeneralSecurityException
     */
    public static void PutEmail(String EmailAdress,String text,String title) throws MessagingException, GeneralSecurityException {
        //创建一个配置文件并保存
        Properties properties = new Properties();

        properties.setProperty("mail.host","smtp.qq.com");

        properties.setProperty("mail.transport.protocol","smtp");

        properties.setProperty("mail.smtp.auth","true");

        //QQ存在一个特性设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 授权码和发送对象
                return new PasswordAuthentication("863978160@qq.com","okxtjfosbhxcbega");
            }
        });
        //开启debug模式
        session.setDebug(false);

        //获取连接对象
        Transport transport = session.getTransport();

        //连接服务器
        transport.connect("smtp.qq.com","863978160@qq.com","okxtjfosbhxcbega");

        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);

        //邮件发送人
        mimeMessage.setFrom(new InternetAddress("863978160@qq.com"));

        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(EmailAdress));

        //邮件标题
        mimeMessage.setSubject(title);

        //邮件内容
        mimeMessage.setContent(text,"text/html;charset=UTF-8");

        //发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

        //关闭连接
        transport.close();
        LoggerFactory.getLogger(SendOutlookEmail.class).info("邮件发送成功");
    }
}
