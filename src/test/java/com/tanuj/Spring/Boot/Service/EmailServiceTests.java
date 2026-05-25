package com.tanuj.Spring.Boot.Service;

import com.tanuj.Spring.Boot.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendMail(){
        emailService.sendEmail("tanujpratapsing08@gmail.com","Hiring Email","Hello Radha Chauhan You hire an Bank PO of SBI branch Ganga nagar");
    }
}
