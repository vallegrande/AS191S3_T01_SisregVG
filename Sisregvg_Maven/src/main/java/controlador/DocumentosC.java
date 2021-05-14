package controlador;

import dao.DocumentosD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.DocumentosM;

//Notación CDI
@Named(value = "DocumentosC")
//@Dependent
@SessionScoped
public class DocumentosC implements Serializable {

    private DocumentosM documento;
    private DocumentosD dao;
    private List<DocumentosM> listadoDocumentos;

    public DocumentosC() {
        documento = new DocumentosM();
        dao = new DocumentosD();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(documento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con Exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + documento.getImporte());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(documento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(DocumentosM documento) throws Exception {
        try {
            dao.eliminar(documento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
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
        documento = new DocumentosM();
    }

    public void listar() {
        try {
            listadoDocumentos = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
//metodos generados

    public DocumentosM getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentosM documento) {
        this.documento = documento;
    }

    public DocumentosD getDao() {
        return dao;
    }

    public void setDao(DocumentosD dao) {
        this.dao = dao;
    }

    public List<DocumentosM> getListadoDocumentos() {
        return listadoDocumentos;
    }

    public void setListadoDocumentos(List<DocumentosM> listadoDocumentos) {
        this.listadoDocumentos = listadoDocumentos;
    }


}