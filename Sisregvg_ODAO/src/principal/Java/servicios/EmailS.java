package servicios;

import static dao.Conexion.conectar;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import modelo.Usuario;

public class EmailS {

    public static void enviarContraseña(Personal per) {
        //        Usuario  que emite o envia el correo al receptor
        String remitente 
        //        Contraseña de el usuario emisor
        String clave = Ra
        //        Destinatario que va variar según ingreso de Email en la vista
        String destinatario = per.getEmail();
        //        Mensaje del correo del emisor
        String asunto = "BIENVINIEDO A SISREGVG, ENVIO DE CONTRASEÑA";
//        String contraseña = "ValleGrande2021";
        //        Envio del cuerpo del mensaje
//        String cuerpo = "Hola monitor su contraseña de ingreso a la plataforma SISREGVG es @Personal2021@";

        String cuerpo = "BUEN DÍA " + per.getNombre() + " " + per.getApellido() +

        //        Configuración para enviar el correo
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.clave", clave);
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            BodyPart texto = new MimeBodyPart();
            texto.setText(cuerpo);

            //PARA ENVIAR ARCHIVOS ADJUNTOS EN EL CORREO
//            String url = "D:\\ADOBE ILUSTRATOR\\logotipo.png";
//            BodyPart adjunto = new MimeBodyPart();
//            adjunto.setDataHandler(new DataHandler(new FileDataSource(url)));
//            adjunto.setFileName("Archivo.jpg");
            MimeMultipart multiParte = new MimeMultipart();
//            multiParte.addBodyPart(adjunto);
            multiParte.addBodyPart(texto);
            message.setContent(multiParte);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            ex.printStackTrace();
            System.out.println("Error en EmailS: " + ex.getMessage());
        }
    }
    
//(String usu
    public static void sendNotification(String usu) throws UnknownHostException, Exception {
        Usuario usuario = null;
        String sql = "SELECT\n"
                + "U.USUUSU AS USUUSU,\n"
        

        
        Statement st = conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setUSUUSU(rs.getString("USUUSU"))
        }
        rs.close();
        st.close();

        // El correo gmail de envio
        String remitente = "jhianpol.ramos@gmail.com";
        String clave = "Ramos2021...";

        //Destinatario segun el usuario en el login
        String destinatario = usuario.getEmail();



        // La configuracion para enviar correo
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
            System.out.println("Error en enviarNotificacion_S " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    
    
    
  
  
    public static void main(String[] args) throws Exception {
        try {
            Personal per = new Personal();
            per.setEmail("jose.rivera@vallegrande.edu.pe");
            per.setNombre("Jhianpol Maximiliano");
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
