/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhianpol
 */
@Entity
@Table(name = "PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByIdper", query = "SELECT p FROM Personal p WHERE p.idper = :idper")
    , @NamedQuery(name = "Personal.findByNomper", query = "SELECT p FROM Personal p WHERE p.nomper = :nomper")
    , @NamedQuery(name = "Personal.findByApeper", query = "SELECT p FROM Personal p WHERE p.apeper = :apeper")
    , @NamedQuery(name = "Personal.findByDniper", query = "SELECT p FROM Personal p WHERE p.dniper = :dniper")
    , @NamedQuery(name = "Personal.findByCelper", query = "SELECT p FROM Personal p WHERE p.celper = :celper")
    , @NamedQuery(name = "Personal.findByEmaper", query = "SELECT p FROM Personal p WHERE p.emaper = :emaper")
    , @NamedQuery(name = "Personal.findByDomper", query = "SELECT p FROM Personal p WHERE p.domper = :domper")
    , @NamedQuery(name = "Personal.findBySexper", query = "SELECT p FROM Personal p WHERE p.sexper = :sexper")
    , @NamedQuery(name = "Personal.findByCarper", query = "SELECT p FROM Personal p WHERE p.carper = :carper")
    , @NamedQuery(name = "Personal.findByEstper", query = "SELECT p FROM Personal p WHERE p.estper = :estper")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPER")
    private BigDecimal idper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMPER")
    private String nomper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APEPER")
    private String apeper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNIPER")
    private String dniper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CELPER")
    private String celper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAPER")
    private String emaper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "DOMPER")
    private String domper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXPER")
    private Character sexper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CARPER")
    private String carper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTPER")
    private Character estper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idper")
    private List<Valeprovisional> valeprovisionalList;

    public Personal() {
    }

    public Personal(BigDecimal idper) {
        this.idper = idper;
    }

    public Personal(BigDecimal idper, String nomper, String apeper, String dniper, String celper, String emaper, String domper, Character sexper, String carper, Character estper) {
        this.idper = idper;
        this.nomper = nomper;
        this.apeper = apeper;
        this.dniper = dniper;
        this.celper = celper;
        this.emaper = emaper;
        this.domper = domper;
        this.sexper = sexper;
        this.carper = carper;
        this.estper = estper;
    }

    public BigDecimal getIdper() {
        return idper;
    }

    public void setIdper(BigDecimal idper) {
        this.idper = idper;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getApeper() {
        return apeper;
    }

    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    public String getDniper() {
        return dniper;
    }

    public void setDniper(String dniper) {
        this.dniper = dniper;
    }

    public String getCelper() {
        return celper;
    }

    public void setCelper(String celper) {
        this.celper = celper;
    }

    public String getEmaper() {
        return emaper;
    }

    public void setEmaper(String emaper) {
        this.emaper = emaper;
    }

    public String getDomper() {
        return domper;
    }

    public void setDomper(String domper) {
        this.domper = domper;
    }

    public Character getSexper() {
        return sexper;
    }

    public void setSexper(Character sexper) {
        this.sexper = sexper;
    }

    public String getCarper() {
        return carper;
    }

    public void setCarper(String carper) {
        this.carper = carper;
    }

    public Character getEstper() {
        return estper;
    }

    public void setEstper(Character estper) {
        this.estper = estper;
    }

    @XmlTransient
    public List<Valeprovisional> getValeprovisionalList() {
        return valeprovisionalList;
    }

    public void setValeprovisionalList(List<Valeprovisional> valeprovisionalList) {
        this.valeprovisionalList = valeprovisionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idper != null ? idper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idper == null && other.idper != null) || (this.idper != null && !this.idper.equals(other.idper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Personal[ idper=" + idper + " ]";
    }
    
}
