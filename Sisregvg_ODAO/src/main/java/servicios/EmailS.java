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

public class EmailS {

    public static void enviarContraseña(Personal per) {  
        //        Usuario  que emite o envia el correo al receptor
        String remitente = "jhianpol.ramos@gmail.com";
        //        Contraseña de el usuario emisor
        String clave = "Ramos2021...";
        //        Destinatario que va variar según ingreso de Email en la vista
        String destinatario = per.getEmail();
        //        Mensaje del correo del emisor
        String asunto = "BIENVINIEDO A SISREGVG, ENVIO DE CONTRASEÑA";
//        String contraseña = "ValleGrande2021";
        //        Envio del cuerpo del mensaje
//        String cuerpo = "Hola monitor su contraseña de ingreso a la plataforma SISREGVG es @Personal2021@";
        
            String cuerpo = "BUEN DÍA "+per.getNombre()+" "+ per.getApellido()+"\n"+
                "\n Su usuario es: "+per.getDni()+"\n y su contraseña es: " +per.getPwdper()+
                "\n Se agradece por usar la plataforma SISREGVG";
        
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
            String url = "D:\\ADOBE ILUSTRATOR\\logotipo.png";
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
            per.setNombre("jhianpol");
            per.setApellido("Ramos Gil");
            per.setDni("74140394");
            EmailS.enviarContraseña(per);
            System.out.println("CORREO ENVIADO");
            JOptionPane.showMessageDialog(null, "CORREO ENVIADO", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            System.out.println("Error en mandarCorreo/mail " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "NO SE ENVIO EL CORREO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}