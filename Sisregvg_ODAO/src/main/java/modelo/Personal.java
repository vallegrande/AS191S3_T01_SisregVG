package modelo;

import java.util.UUID;
import lombok.Data;

@Data

public class Personal {


    String pwd1 = UUID.randomUUID().toString().toUpperCase().substring(2, 6);
    String pwd2 = UUID.randomUUID().toString().toLowerCase().substring(2, 6);
    String pwd3 = "/-";
    String password = pwd1 + pwd2 + pwd3;
    
    
    
    private Integer idper;
    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String email;
    private String domper;
    private String sexo;
    private String cargo;
    private String estper;
    private String pwdper = password;
    
    public Personal (){
        
    }
    public Personal(Integer idper, String nombre, String apellido, String dni, String celular, String email, String domper, String sexo, String cargo, String estper, String pwdper) {
        this.idper = idper;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.email = email;
        this.domper = domper;
        this.sexo = sexo;
        this.cargo = cargo;
        this.estper = estper;
        this.pwdper = pwdper;
    }
  
}
