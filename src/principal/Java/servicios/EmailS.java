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
        String clave = 
        //        Destinatario que va variar según ingreso de Email en la vista
        String destinatario = 


    
    
    
  
  
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
