package modelo;

import java.util.Date;
import java.util.GregorianCalendar;

public class ValeProvisional {
    
    private int idval;
    private String impval;
    private Date fecval = GregorianCalendar.getInstance().getTime();
    private String cenval;
    private String proval;
    private String actval;
    private String idper;
    private String  estval;

private Personal personal = new Personal();

    public int getIdval() {
        return idval;
    }

    public void setIdval(int idval) {
        this.idval = idval;
    }

    public String getImpval() {
        return impval;
    }

    public void setImpval(String impval) {
        this.impval = impval;
    }

    public Date getFecval() {
        return fecval;
    }

    public void setFecval(Date fecval) {
        this.fecval = fecval;
    }

    public String getCenval() {
        return cenval;
    }

    public void setCenval(String cenval) {
        this.cenval = cenval;
    }

    public String getProval() {
        return proval;
    }

    public void setProval(String proval) {
        this.proval = proval;
    }

    public String getActval() {
        return actval;
    }

    public void setActval(String actval) {
        this.actval = actval;
    }

    public String getIdper() {
        return idper;
    }

    public void setIdper(String idper) {
        this.idper = idper;
    }

    public String getEstval() {
        return estval;
    }

    public void setEstval(String estval) {
        this.estval = estval;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    
 
}