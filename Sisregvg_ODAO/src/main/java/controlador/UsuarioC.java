package controlador;

import dao.UsuarioImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.Usuario;

@Data
@Named(value = "usuarioC")
@SessionScoped
public class UsuarioC implements Serializable {

    Usuario usuario;
    UsuarioImpl dao;
    private int captcha = 0;
    private int intentos = 0;
    private boolean bloquear;
//    String USUUSU;
//    String PWDUSU;

    public UsuarioC() {
        usuario = new Usuario();
        dao = new UsuarioImpl();
    }

    public void login() throws Exception {
        try {
            dao.login(usuario);
        } catch (Exception e) {
            System.out.println("Error en login_C " + e.getMessage());
        }
    }

    public void loginNivel() throws Exception {
        try {
            dao.loginNivel(usuario);
        } catch (Exception e) {
            System.out.println("Error en loginNivel_C" + e.getMessage());
        }
    }

//   public void acceso() throws Exception {
//        try {
//            this.login();
//            if (dao.logueo == false) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Usuario o contraseña incorrecto"));
//            } else {
//                this.loginNivel();
//                if (dao.nivel == 1) {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡BIENVENIDO!", "Ingreso Exitoso"));
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Sigregvg_ODAO/faces/vistas/Personal.xhtml");
//                }
//                if (dao.nivel == 2) {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡BIENVENIDO!", "Ingreso Exitoso"));
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Sisregvg_ODAO/faces/vistas/Personal.xhtml");
//                } else {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Usuario o contraseña incorrecto"));
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error en Acceso_C " + e.getMessage());
//        }
//    }
    public void acceso() throws Exception {
        try {
            this.login();
            if (dao.logueo == false) {
                intentos++;
                if (intentos == 1) {
                    setIntentos(1);
                    setCaptcha(0);
                    System.out.println("intentos igual " + intentos);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "1 INTENTO FALLIDO", "Usuario/Contraseña incorrectas"));
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "LE QUEDAN 2 INTENTOS", ""));
                }
                if (intentos == 2) {
                    setIntentos(2);
                    setCaptcha(1);
//                    bloquear = true;
                    System.out.println("intentos igual " + intentos);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "2 INTENTO FALLIDO", "Usuario/Contraseña incorrectas"));
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "LE QUEDA 1 INTENTO", ""));
                }
                if (intentos == 3) {
                    System.out.println("intentos igual " + intentos);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "3 INTENTO FALLIDO", "Usuario/Contraseña incorrectas"));
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "BLOQUEO DE SEGURIDAD", ""));
                    setIntentos(3);
//                    bloquear = true;
                    if (bloquear) {
                        delayTiempo();
                    }
                    if (intentos == 3) {
                        setIntentos(0);
                        setCaptcha(0);
                        bloquear = true;
                    }
                }
            } else {
                this.loginNivel();
                if (dao.nivel == 1) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡BIENVENIDO!", "Ingreso Exitoso"));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Sisregvg_ODAO/faces/vistas/Personal.xhtml");
                }
                if (dao.nivel == 2) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡BIENVENIDO!", "Ingreso Exitoso"));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Sisregvg_ODAO/faces/vistas/Personal.xhtml");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en Acceso_C " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    private static void delayTiempo() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Error en delaySegundo_C " + e.getMessage());
            e.printStackTrace();
        }
    }

}
