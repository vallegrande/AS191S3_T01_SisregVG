package controlador;

import dao.DeJuradaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.DeJurada;

//Notación CDI
@Named(value = "DeJuradaC")
//@Dependent
@SessionScoped
public class DeJuradaC implements Serializable {

    private DeJurada declaracion;
    private DeJuradaImpl dao;
    private List<DeJurada> listadoDec;

    public DeJuradaC() {
        declaracion = new DeJurada();
        dao = new DeJuradaImpl();
    }

    public void registrar() throws Exception {
        try {
            declaracion.setIdper(dao.obtenerIdper(declaracion.getIdper()));
            dao.registrar(declaracion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con Exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + declaracion.getId());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(declaracion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(DeJurada declaracion) throws Exception {
        try {
            dao.eliminar(declaracion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

     public List<String> completeTextPersonal(String query) throws SQLException, Exception {
        DeJuradaImpl daoPersonal = new DeJuradaImpl();
        return daoPersonal.autocompleteIdper(query);
    }    

    
    
    
    
    
//       public void eliminarEstado(PersonaM clie) throws Exception{
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
        declaracion = new DeJurada();
    }

    public void listar() {
        try {
            listadoDec = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
//metodos generados

    public DeJurada getDeclaracion() {
        return declaracion;
    }

    public void setDeclaracion(DeJurada declaracion) {
        this.declaracion = declaracion;
    }

    public DeJuradaImpl getDao() {
        return dao;
    }

    public void setDao(DeJuradaImpl dao) {
        this.dao = dao;
    }

    public List<DeJurada> getListadoDec() {
        return listadoDec;
    }

    public void setListadoPer(List<DeJurada> listadoDeC) {
        this.listadoDec = listadoDec;
    }

    
    
    
    

}
