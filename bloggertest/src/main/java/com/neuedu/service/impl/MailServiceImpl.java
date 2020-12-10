package com.neuedu.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.neuedu.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	 //private final Logger logger = LoggerFactory.getLogger(this.getClass());
	    @Autowired
	    private JavaMailSender mailSender;
	    /**
	     * 配置文件中我的qq邮箱
	     */
	    @Value("${spring.mail.from}")
	    private String from;
	    /**
	     * 发送HTML邮件
	     * @param to 收件者  邮箱
	     * @param subject 邮件主题  邮箱验证
	     * @param content 文本内容  内容+链接
	     */
		@Override
		public int sendHtmlMail(String to, String subject, String content) {
			// TODO Auto-generated method stub
			MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = null;
	        try {
	            helper = new MimeMessageHelper(message, true);
	            helper.setFrom(from);
	            helper.setSubject(subject);
	            helper.setTo(to);
	            helper.setText(content, true);
	            mailSender.send(message);
	            //日志信息
	            //logger.info("邮件已经发送。");
	            System.out.println("发送邮件成功");
	            return 1;
	        } catch (MessagingException e) {
	           // logger.error("发送邮件时发生异常！", e);
	        	 System.out.println("发送邮件异常");
	        	 return 0;
	        }
		}

}
