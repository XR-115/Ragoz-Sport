package com.sena.ragozsport.model.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired JavaMailSender mailSender;

    public void sendSimpleEmailForgotPassword(String correo){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("jsreyes463@misena.edu.com");
        message.setTo(correo);
        message.setText("Solicitaste el cambio de contraseña de click en el siguiente enlace http://localhost:8080/ragoz/restablecerClave/"+correo);
        message.setSubject("Cambio de clave Envioz");
        System.out.println("asdddadssssssssssss"+message);
        mailSender.send(message);
    }
}
