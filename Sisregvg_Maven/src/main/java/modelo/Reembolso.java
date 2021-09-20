package modelo;

import java.util.Date;
import lombok.Data;
import java.util.GregorianCalendar;

@Data

public class Reembolso {

    private Integer IDREE;
    private Integer IDPER;
    private String NOMPER;
    private String DNIPER;
    private String MOTREE;
    private Date FECREE = GregorianCalendar.getInstance().getTime();
    private String  ARERRE;
    private String CENREE;
    private String DESREE;
    private Integer IDLIQ;
    private String FORREE;
    private String PAGREE;
    private String NAHREE;
    private String NCUREE;
    private Double SALREE;
    private String ESTREE;
    
      private Personal personal = new Personal();
    private Liquidacion liq = new Liquidacion();

    public Reembolso(Integer IDREE, Integer IDPER, String NOMPER, String DNIPER, String MOTREE, String ARERRE, String CENREE,String DESREE, Integer IDLIQ, String FORREE, String PAGREE, String NAHREE, String NCUREE, Double SALREE, String ESTREE, Liquidacion liq) {
        this.IDREE = IDREE;
        this.IDPER = IDPER;
        this.NOMPER = NOMPER;
        this.DNIPER = DNIPER;
        this.MOTREE = MOTREE;
        this.ARERRE = ARERRE;
        this.CENREE = CENREE;
        this.DESREE = DESREE;
        this.IDLIQ = IDLIQ;
        this.FORREE = FORREE;
        this.PAGREE = PAGREE;
        this.NAHREE = NAHREE;
        this.NCUREE = NCUREE;
        this.SALREE = SALREE;
        this.ESTREE = ESTREE;
        this.liq=liq;
    }

    public Reembolso() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }





}