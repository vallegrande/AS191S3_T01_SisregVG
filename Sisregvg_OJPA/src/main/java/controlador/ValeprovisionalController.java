package controlador;

import modelo.entidad.Valeprovisional;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import modelo.dao.ValeprovisionalFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("valeprovisionalController")
@SessionScoped
public class ValeprovisionalController implements Serializable {

    @EJB
    private modelo.dao.ValeprovisionalFacade ejbFacade;
    private List<Valeprovisional> items = null;
    private Valeprovisional selected;

    public ValeprovisionalController() {
    }

    public Valeprovisional getSelected() {
        return selected;
    }

    public void setSelected(Valeprovisional selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ValeprovisionalFacade getFacade() {
        return ejbFacade;
    }

    public Valeprovisional prepareCreate() {
        selected = new Valeprovisional();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/vistas").getString("ValeprovisionalCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/vistas").getString("ValeprovisionalUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/vistas").getString("ValeprovisionalDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Valeprovisional> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/vistas").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/vistas").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Valeprovisional getValeprovisional(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<Valeprovisional> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Valeprovisional> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Valeprovisional.class)
    public static class ValeprovisionalControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ValeprovisionalController controller = (ValeprovisionalController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "valeprovisionalController");
            return controller.getValeprovisional(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Valeprovisional) {
                Valeprovisional o = (Valeprovisional) object;
                return getStringKey(o.getIdval());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Valeprovisional.class.getName()});
                return null;
            }
        }

    }

}
