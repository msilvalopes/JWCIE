
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class MailSender {
    private static String SMTP = "smtp.formaturafacom.com.br";
    private static String MailFrom = "marcel@diretrix.com";
    private static String MailPass = "SenhaFormatura";
    
    public static void postMail(String mensagem_texto, String to, String subject) {
        
        Properties p = new Properties();
        p.put("mail.host",SMTP);
        Session session = Session.getInstance(p, null);
        MimeMessage msg = new MimeMessage(session);
        try {
            // "de" e "para"!!  
            msg.setFrom(new InternetAddress(MailFrom));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            msg.setSentDate(new Date());

            msg.setSubject(subject);

            msg.setText(mensagem_texto);
            Transport.send(msg);
        } catch (AddressException e) {
            // nunca deixe catches vazios!  
        } catch (MessagingException e) {
            // nunca deixe catches vazios!  
        }
    }
}
