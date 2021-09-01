package modelo;

import java.util.Date;
import java.util.GregorianCalendar;
import lombok.Data;

@Data

public class Liquidacion {

    private Integer IDLIQ;
    private Integer IDPER;
    private String nomper;
    private String dniper;
    private Integer IDVAL;
    private Date FECVAL;
    private Double impval;
    private String MOTLIQ;
    private Date FECLIQ = GregorianCalendar.getInstance().getTime();
    private String ARELIQ;
    private String CENLIQ;
    private String DESLIQ;
    private String FORLIQ;
    private Double GASLIQ;
    private Double SALLIQ ;
    private String ESTLIQ;
    

    private Personal personal = new Personal();
    private ValeProvisional provisional = new ValeProvisional();


    public Liquidacion(Integer IDLIQ, Integer IDPER, String nomper, String dniper, Integer IDVAL, Date FECVAL, Double impval, String MOTLIQ, String ARELIQ, String CENLIQ, String DESLIQ, String FORLIQ, Double GASLIQ, Double SALLIQ, String ESTLIQ, ValeProvisional provisional) {
        this.IDLIQ = IDLIQ;
        this.IDPER = IDPER;
        this.nomper = nomper;
        this.dniper = dniper;
        this.IDVAL = IDVAL;
        this.FECVAL = FECVAL;
        this.impval = impval;
        this.MOTLIQ = MOTLIQ;
        this.ARELIQ = ARELIQ;
        this.CENLIQ = CENLIQ;
        this.DESLIQ = DESLIQ;
        this.FORLIQ = FORLIQ;
        this.GASLIQ = GASLIQ;
        this.SALLIQ = SALLIQ;
        this.ESTLIQ = ESTLIQ;
        this.provisional=provisional;
    }



    public Liquidacion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}      

