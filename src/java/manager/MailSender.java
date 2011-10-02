package manager;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class MailSender {
    private static String SMTP = "smtp.domain.com";
    private static String MailFrom = "user@domain.com";
    private static String MailUser = "user@domain.com";
    private static String MailPass = "password";
    
    public void postMail(String mensagem_texto, String to, String subject) throws Exception{
        
        Properties p = new Properties();
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.smtp.host",SMTP);
        p.put("mail.smtp.auth", "true");
        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getInstance(p, auth);
        // uncomment for debugging infos to stdout
        // mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setContent(mensagem_texto, "text/plain");
        message.setSubject(subject);
        message.setFrom(new InternetAddress(MailFrom));
        message.addRecipient(Message.RecipientType.TO,
             new InternetAddress(to));

        transport.connect();
        transport.sendMessage(message,
            message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
           String username = MailUser;
           String password = MailPass;
              return new PasswordAuthentication(username, password);
        }
    
    }
}
