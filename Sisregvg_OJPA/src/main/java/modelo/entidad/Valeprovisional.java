/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhianpol
 */
@Entity
@Table(name = "VALEPROVISIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valeprovisional.findAll", query = "SELECT v FROM Valeprovisional v")
    , @NamedQuery(name = "Valeprovisional.findByIdval", query = "SELECT v FROM Valeprovisional v WHERE v.idval = :idval")
    , @NamedQuery(name = "Valeprovisional.findByImpval", query = "SELECT v FROM Valeprovisional v WHERE v.impval = :impval")
    , @NamedQuery(name = "Valeprovisional.findByFecval", query = "SELECT v FROM Valeprovisional v WHERE v.fecval = :fecval")
    , @NamedQuery(name = "Valeprovisional.findByCenval", query = "SELECT v FROM Valeprovisional v WHERE v.cenval = :cenval")
    , @NamedQuery(name = "Valeprovisional.findByProval", query = "SELECT v FROM Valeprovisional v WHERE v.proval = :proval")
    , @NamedQuery(name = "Valeprovisional.findByActval", query = "SELECT v FROM Valeprovisional v WHERE v.actval = :actval")
    , @NamedQuery(name = "Valeprovisional.findByEstval", query = "SELECT v FROM Valeprovisional v WHERE v.estval = :estval")})
public class Valeprovisional implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVAL")
    private BigDecimal idval;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IMPVAL")
    private BigDecimal impval;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECVAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecval;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CENVAL")
    private String cenval;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PROVAL")
    private String proval;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ACTVAL")
    private String actval;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTVAL")
    private Character estval;
    @JoinColumn(name = "IDPER", referencedColumnName = "IDPER")
    @ManyToOne(optional = false)
    private Personal idper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idval")
    private List<Liquidacion> liquidacionList;

    public Valeprovisional() {
    }

    public Valeprovisional(BigDecimal idval) {
        this.idval = idval;
    }

    public Valeprovisional(BigDecimal idval, BigDecimal impval, Date fecval, String cenval, String proval, String actval, Character estval) {
        this.idval = idval;
        this.impval = impval;
        this.fecval = fecval;
        this.cenval = cenval;
        this.proval = proval;
        this.actval = actval;
        this.estval = estval;
    }

    public BigDecimal getIdval() {
        return idval;
    }

    public void setIdval(BigDecimal idval) {
        this.idval = idval;
    }

    public BigDecimal getImpval() {
        return impval;
    }

    public void setImpval(BigDecimal impval) {
        this.impval = impval;
    }

    public Date getFecval() {
        return fecval;
    }

    public void setFecval(Date fecval) {
        this.fecval = fecval;
    }

    public String getCenval() {
        return cenval;
    }

    public void setCenval(String cenval) {
        this.cenval = cenval;
    }

    public String getProval() {
        return proval;
    }

    public void setProval(String proval) {
        this.proval = proval;
    }

    public String getActval() {
        return actval;
    }

    public void setActval(String actval) {
        this.actval = actval;
    }

    public Character getEstval() {
        return estval;
    }

    public void setEstval(Character estval) {
        this.estval = estval;
    }

    public Personal getIdper() {
        return idper;
    }

    public void setIdper(Personal idper) {
        this.idper = idper;
    }

    @XmlTransient
    public List<Liquidacion> getLiquidacionList() {
        return liquidacionList;
    }

    public void setLiquidacionList(List<Liquidacion> liquidacionList) {
        this.liquidacionList = liquidacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idval != null ? idval.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valeprovisional)) {
            return false;
        }
        Valeprovisional other = (Valeprovisional) object;
        if ((this.idval == null && other.idval != null) || (this.idval != null && !this.idval.equals(other.idval))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Valeprovisional[ idval=" + idval + " ]";
    }
    
}
