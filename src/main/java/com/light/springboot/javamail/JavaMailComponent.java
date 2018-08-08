package com.light.springboot.javamail;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by send email的类。
 * on 2018/8/8.
 */
@Component
@EnableConfigurationProperties(MailProperties.class)
public class JavaMailComponent {
    private final static Logger logger = LoggerFactory
            .getLogger(JavaMailComponent.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;

    public void sendMail(String email) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        try {
            // 获取内容
            String text = "meiizde";
            // 发送
            this.send(email, text);
            logger.info("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("邮件发送失败");
        }
    }


    private String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        InternetAddress from = new InternetAddress();
        from.setAddress(this.mailProperties.getUsername());
        from.setPersonal("苏的发送内容", "UTF-8");
        helper.setFrom(from);
        helper.setTo(email);
        helper.setSubject("这是我的标题，这是后台的测试内容");
        helper.setText(text, true);
        this.javaMailSender.send(message);
        return text;
    }
}
