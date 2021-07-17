package controlador;

import dao.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Personal;
import servicios.Reporte;
//import servicios.Reporte;

//Notación CDI
@Named(value = "personaC")
//@Dependent
@SessionScoped
public class PersonaC implements Serializable {

    private Personal per;
    private PersonaImpl dao;
    private List<Personal> listadoPer;

    public PersonaC() {
        per = new Personal();
        dao = new PersonaImpl();
    }

//    public void registrar() throws Exception {
//        try {
//            dao.registrar(per);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con Exito"));
//            limpiar();
//            listar();
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Error al Registrar"));
//            System.out.println("Error en registrarC " + per.getNombre());
//        }
//    }
    public void registrar() throws Exception {
        try {
            dao.registrar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con ÉXITO"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Falta Completar Datos"));
            System.out.println("Error en RegistrarC " + e.getMessage());

        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

//       public void eliminarEstado(Personal clie) throws Exception{
//        try {            
//            dao.EliminarEstado(clie);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
//            limpiar();
//            listar();
//        } catch (Exception e) {
//            System.out.println("Error en eliminarEstadoC " + e.getMessage());
//        }
//    }
//    
//    public void restaurarEstado(Personal clie) throws Exception{
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
        per = new Personal();
    }

    public void listar() {
        try {
            listadoPer = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
    
    public void reportePersona() throws Exception {
        Reporte report = new Reporte();
        try {
            Map<String, Object> parameters = new HashMap();
            report.exportarPDFGlobal(parameters, "ListadoPersonal.jasper", "ListadoPersonal.pdf");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "PDF GENERADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL GENERAR PDF", null));
            System.out.println("Error en PersonaC/reportePersona : " + e.getMessage());
        }
    }

    
    
//metodos generados

    public Personal getPer() {
        return per;
    }

    public void setPer(Personal per) {
        this.per = per;
    }

    public PersonaImpl getDao() {
        return dao;
    }

    public void setDao(PersonaImpl dao) {
        this.dao = dao;
    }

    public List<Personal> getListadoPer() {
        return listadoPer;
    }

    public void setListadoPer(List<Personal> listadoPer) {
        this.listadoPer = listadoPer;
    }
    
    
}