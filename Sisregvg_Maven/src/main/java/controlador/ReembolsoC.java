package controlador;

import dao.ReembolsoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Reembolso;

//Notación CDI
@Named(value = "ReembolsoC")
//@Dependent
@SessionScoped
public class ReembolsoC implements Serializable {

    private Reembolso reembolso;
    private ReembolsoImpl dao;
    private List<Reembolso> listadoReembolso;

    public ReembolsoC() {
        reembolso = new Reembolso();
        dao = new ReembolsoImpl();
    }

    public void registrar() throws Exception {
        try {
            reembolso.setNomper(dao.obtenerNomper(reembolso.getNomper()));
            dao.registrar(reembolso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con Exito"));
            limpiar();
            listar();
        } catch (Exception e) {
           System.out.println("Error en RegistrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(reembolso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(reembolso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }
    
         public List<String> completeTextReembolso(String query) throws SQLException, Exception {
        ReembolsoImpl daoPersonal = new ReembolsoImpl();
        return daoPersonal.autocompletePersonal(query);
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
        reembolso = new Reembolso();
    }

    public void listar() {
        try {
            listadoReembolso = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
//metodos generados

    public Reembolso getReembolso() {
        return reembolso;
    }

    public void setReembolso(Reembolso reembolso) {
        this.reembolso = reembolso;
    }

    public ReembolsoImpl getDao() {
        return dao;
    }

    public void setDao(ReembolsoImpl dao) {
        this.dao = dao;
    }

    public List<Reembolso> getListadoReembolso() {
        return listadoReembolso;
    }

    public void setListadoReembolso(List<Reembolso> listadoReembolso) {
        this.listadoReembolso = listadoReembolso;
    }



}