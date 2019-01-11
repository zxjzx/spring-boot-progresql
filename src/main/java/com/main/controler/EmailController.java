package com.main.controler;

import com.main.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    JavaMailSender jms;

    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public String sendEmail(@RequestBody Email email){

        if(StringUtils.isEmpty(email)){
            return "对象不能为空";
        }
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("445698839@qq.com");
        //接收者
        mainMessage.setTo(email.getReceiver());
        //发送的标题
        mainMessage.setSubject(email.getTitle());
        //发送的内容
        mainMessage.setText(email.getContent());
        jms.send(mainMessage);
        return "success";
    }
}
