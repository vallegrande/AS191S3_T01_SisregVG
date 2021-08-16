package modelo;

import java.util.Date;
import lombok.Data;
import java.util.GregorianCalendar;

@Data

public class ValeProvisional {

    private int idval;
    private Double impval;
    private Date fecval = GregorianCalendar.getInstance().getTime();
    private String cenval;
    private String proval;
    private String actval;
    private Integer idper;
    private String nomper;
    private String estval;
    private Personal personal = new Personal();


}
