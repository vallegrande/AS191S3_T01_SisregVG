package servicios;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import modelo.Personal;

public class EmailSS {

    public static void enviarContraseña(Personal per) {  
//        Usuario  que emite o envia el correo al receptor
        String remitente = "pepito.grillo@gmail.com";
//        Contraseña de el usuario emisor
        String clave = "pepitoGrillo@@@";
//        Destinatario que va variar según ingreso de Email en la vista
        String destinatario = per.getEmail();
//        Mensaje del correo del emisor
        String asunto = "Envio de la contraseña";
//        Envio del cuerpo del mensaje
        String cuerpo = " Tu contraseña de ingreso a la tabla usuario es 13579";
        
//        Configuración para enviar el correo
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try { 
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            BodyPart texto = new MimeBodyPart();
            texto.setText(cuerpo);
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            message.setContent(multiParte);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            ex.printStackTrace();
            System.out.println("Error verifica: " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Personal per = new Personal();
            per.setEmail("jhianpol.ramos@vallegrande.edu.pe");
            EmailSS.enviarContraseña(per);
            System.out.println("CORREO ENVIADO");
            JOptionPane.showMessageDialog(null, "CORREO ENVIADO", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            System.out.println("Error en mandarCorreo/mail " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "NO SE ENVIO EL CORREO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
