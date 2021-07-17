package controlador;

import dao.ValeProvisionalImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.ValeProvisional;
import servicios.Reporte;

//Notación CDI
@Named(value = "ValeProvisionalC")
//@Dependent
@SessionScoped
public class ValeProvisionalC implements Serializable {

    private ValeProvisional provisional;
    private ValeProvisionalImpl dao;
    private List<ValeProvisional> listadoValeProvisional;

    public ValeProvisionalC() {
        provisional = new ValeProvisional();
        dao = new ValeProvisionalImpl();
    }

    public void registrar() throws Exception {
        try {
//            provisional.setNomper(dao.obtenerNomper(provisional.getNomper()));
            dao.registrar(provisional);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con Exito"));
            limpiar();
            listar();
        } catch (Exception e) {
           System.out.println("Error en RegistrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(provisional);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(provisional);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }
    

       public void DeleteEstado() throws Exception{
        try {            
            dao.DeleteEstado(provisional);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarEstadoC " + e.getMessage());
        }
    }
//    
//    public void restaurarEstado(PersonaM clie) throws Exception{
//        try {            
//            dao.RestaurarEstado(clie);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Restaurado con Exito"));
//            limpiar();
//            listar();
//        } catch (Exception e) {
//            System.out.println("Error en restaurarEstadoC " + e.getMessage());
//        }
//    }
    
    public void limpiar() {
        provisional = new ValeProvisional();
    }

    public void listar () {
        try {
            listadoValeProvisional = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
    
    
        public void reporteValeProvisional() throws Exception {
        Reporte report = new Reporte();
        try {
            Map<String, Object> parameters = new HashMap();
            report.exportarPDFGlobal(parameters, "ListadoValeProvisional.jasper", "ListadoValeProvisional(15-07-2021.pdf");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "PDF GENERADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL GENERAR PDF", null));
            System.out.println("Error en ValeProvisionalC/reporteValeProvisional : " + e.getMessage());
        }
    }

    
    
//metodos generados

    public ValeProvisional getProvisional() {
        return provisional;
    }

    public void setProvisional(ValeProvisional provisional) {
        this.provisional = provisional;
    }

    public ValeProvisionalImpl getDao() {
        return dao;
    }

    public void setDao(ValeProvisionalImpl dao) {
        this.dao = dao;
    }

    public List<ValeProvisional> getListadoValeProvisional() {
        return listadoValeProvisional;
    }

    public void setListadoValeProvisional(List<ValeProvisional> listadoValeProvisional) {
        this.listadoValeProvisional = listadoValeProvisional;
    }




}