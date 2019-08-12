package utils;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendMail {
    public static void sendMail(String recepient, String username_recepient, String password_recepient) throws Exception{
        System.out.println("Email đang được gửi!");
        
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        
        String myAccountEmail = "giabao66778899@gmail.com";
        String password = "nguyenphuong";
        
        Session s = Session.getInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message m = prepareMessage(s,myAccountEmail,recepient,username_recepient,password_recepient);
        
        Transport.send(m);
        
        System.out.println("Gửi Email thành công!");
    }

    private static Message prepareMessage(Session s, String myAccountEmail, String recepient, String username_recepient, String password_recepient) {
        try {
            Message m = new MimeMessage(s);
            m.setFrom(new InternetAddress(myAccountEmail));
            m.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            m.setSubject("[PTIT] THÔNG TIN TÀI KHOẢN CỦA BẠN!");
            m.setText("Your Account: "+"\n"+"Username: "+username_recepient+"\n"+"Password: "+password_recepient);
//            String html = "<h4>Your Account: </h4> <br/> <h5>Username: </h5> <br/> <h5>Password: </h5>";
//            m.setContent(html, "text/html");
            return m;
        } catch (Exception ex) {
        	Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
