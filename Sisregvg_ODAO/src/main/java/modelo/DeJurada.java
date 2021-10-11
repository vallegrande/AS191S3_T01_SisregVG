package modelo;

import java.util.Date;
import lombok.Data;

@Data
public class DeJurada {

    private int id;
    private String importe;
    private String proyecto;
    private String centrodecosto;
    private String nomper;
    private String dni;
    private String domicilio;
    private String gastado;
    private String motivo;
    private Date fecha;
    private String estado;

   
}
