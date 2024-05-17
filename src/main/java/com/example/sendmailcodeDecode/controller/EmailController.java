package com.example.sendmailcodeDecode.controller;

import com.example.sendmailcodeDecode.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping("sendEmail")
    public String sendEmail(){
        sendEmailService.sendEmail("levanovroman2016@yandex.ru", "Test Body", "Test Subject");
        return "Sent Successfully";
    }
}
