package com.swiggy.app.Email;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {
    @Autowired
    EmailSenderService emailSenderService;
    
    @PostMapping("/email")
    public  String myEmail(@RequestBody EmailRequest emailRequest){
        emailSenderService.sendSimpleEmail(emailRequest.getTo(),
        		emailRequest.getBody(),emailRequest.getSub());
        return "email sent succesfully"+emailRequest.getTo();

    }
    
    @PostMapping("/mail")
    public void mailWithAttachment(@RequestBody EmailRequest emailRequest) throws MessagingException {
    	emailSenderService.sendMailWithAttachment(emailRequest.getTo(), 
    			emailRequest.getBody(), emailRequest.getSub(),emailRequest.getAttachment());
    }

}
