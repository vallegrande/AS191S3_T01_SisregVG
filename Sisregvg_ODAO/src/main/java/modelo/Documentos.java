package modelo;
import lombok.Data;


import java.util.Date;
import java.util.GregorianCalendar;
@Data
public class Documentos {
    
    private int id;
    private String importe;
    private Date fecha = GregorianCalendar.getInstance().getTime();
    private String asunto;
    private String estado;

 
}