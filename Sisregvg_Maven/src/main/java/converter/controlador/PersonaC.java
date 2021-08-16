package controlador;

import dao.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Personal;
import org.primefaces.PrimeFaces;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;
import servicios.Reporte;
import lombok.Data;

@Data
//import servicios.Reporte;

//Notación CDI
@Named(value = "personaC")
//@Dependent
@SessionScoped
public class PersonaC implements Serializable {

    private Personal per;
    private PersonaImpl dao;
    private List<Personal> listadoPer;
    private int tipo = 1;
    private ExcelOptions excelOpt;
    private PDFOptions pdfOpt;

    public PersonaC() {
        per = new Personal();
        dao = new PersonaImpl();
        listadoPer = new ArrayList<>();

    }

    public void registrar() throws Exception {
        try {
            if (!dao.existe(per, listadoPer)) {
                dao.registrar(per);
                PrimeFaces.current().ajax().update("form");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con ÉXITO"));
                limpiar();
                listar();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, " ERROR", "El DNI ya existe"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Falta Completar Datos"));
            System.out.println("Error en RegistrarC " + e.getMessage());

        }

        per = new Personal();
        listar();
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

    public void DeleteEstado() throws Exception {
        try {
            dao.DeleteEstado(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarEstadoC " + e.getMessage());
        }
    }

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
            listadoPer = dao.listarTodos(tipo);
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }

    public void reportePersona() throws Exception {
        Reporte report = new Reporte();
        try {
            Map<String, Object> parameters = new HashMap();
            report.exportarPDFGlobal(parameters, "Personal.jasper", "Personal.pdf");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "PDF GENERADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL GENERAR PDF", null));
            System.out.println("Error en PersonaC/reportePersona : " + e.getMessage());
        }
    }

    public void customizationOptions() {
        excelOpt = new ExcelOptions();
        excelOpt.setFacetBgColor("#19C7FF");
        excelOpt.setFacetFontSize("10");
        excelOpt.setFacetFontColor("#FFFFFF");
        excelOpt.setFacetFontStyle("BOLD");
        excelOpt.setCellFontColor("#000000");
        excelOpt.setCellFontSize("8");
        excelOpt.setFontName("Verdana");

        pdfOpt = new PDFOptions();
        pdfOpt.setFacetBgColor("#19C7FF");
        pdfOpt.setFacetFontColor("#000000");
        pdfOpt.setFacetFontStyle("BOLD");
        pdfOpt.setCellFontSize("12");
        pdfOpt.setFontName("Courier");
        pdfOpt.setOrientation(PDFOrientationType.LANDSCAPE);
    }

    @PostConstruct
    public void construir() {
        listar();
    }

}
