package modelo;

import java.sql.Date;

public class DeJurada {

    private int id;
    private String importe;
    private String proyecto;
    private String centrodecosto;
    private String domicilio;
    private String gastado;
    private String motivo;
    private Date fecha;
    private String idper;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getCentrodecosto() {
        return centrodecosto;
    }

    public void setCentrodecosto(String centrodecosto) {
        this.centrodecosto = centrodecosto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getGastado() {
        return gastado;
    }

    public void setGastado(String gastado) {
        this.gastado = gastado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdper() {
        return idper;
    }

    public void setIdper(String idper) {
        this.idper = idper;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
