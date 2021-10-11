/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhianpol
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusu", query = "SELECT u FROM Usuario u WHERE u.idusu = :idusu")
    , @NamedQuery(name = "Usuario.findByUsuusu", query = "SELECT u FROM Usuario u WHERE u.usuusu = :usuusu")
    , @NamedQuery(name = "Usuario.findByPwdusu", query = "SELECT u FROM Usuario u WHERE u.pwdusu = :pwdusu")
    , @NamedQuery(name = "Usuario.findByLevusu", query = "SELECT u FROM Usuario u WHERE u.levusu = :levusu")
    , @NamedQuery(name = "Usuario.findByEstusu", query = "SELECT u FROM Usuario u WHERE u.estusu = :estusu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSU")
    private BigDecimal idusu;
    @Size(max = 8)
    @Column(name = "USUUSU")
    private String usuusu;
    @Size(max = 15)
    @Column(name = "PWDUSU")
    private String pwdusu;
    @Column(name = "LEVUSU")
    private BigInteger levusu;
    @Column(name = "ESTUSU")
    private Character estusu;

    public Usuario() {
    }

    public Usuario(BigDecimal idusu) {
        this.idusu = idusu;
    }

    public BigDecimal getIdusu() {
        return idusu;
    }

    public void setIdusu(BigDecimal idusu) {
        this.idusu = idusu;
    }

    public String getUsuusu() {
        return usuusu;
    }

    public void setUsuusu(String usuusu) {
        this.usuusu = usuusu;
    }

    public String getPwdusu() {
        return pwdusu;
    }

    public void setPwdusu(String pwdusu) {
        this.pwdusu = pwdusu;
    }

    public BigInteger getLevusu() {
        return levusu;
    }

    public void setLevusu(BigInteger levusu) {
        this.levusu = levusu;
    }

    public Character getEstusu() {
        return estusu;
    }

    public void setEstusu(Character estusu) {
        this.estusu = estusu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusu != null ? idusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusu == null && other.idusu != null) || (this.idusu != null && !this.idusu.equals(other.idusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Usuario[ idusu=" + idusu + " ]";
    }
    
}
