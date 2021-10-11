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
@Table(name = "LIQUIDACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liquidacion.findAll", query = "SELECT l FROM Liquidacion l")
    , @NamedQuery(name = "Liquidacion.findByIdliq", query = "SELECT l FROM Liquidacion l WHERE l.idliq = :idliq")
    , @NamedQuery(name = "Liquidacion.findByMotliq", query = "SELECT l FROM Liquidacion l WHERE l.motliq = :motliq")
    , @NamedQuery(name = "Liquidacion.findByFecliq", query = "SELECT l FROM Liquidacion l WHERE l.fecliq = :fecliq")
    , @NamedQuery(name = "Liquidacion.findByAreliq", query = "SELECT l FROM Liquidacion l WHERE l.areliq = :areliq")
    , @NamedQuery(name = "Liquidacion.findByCenliq", query = "SELECT l FROM Liquidacion l WHERE l.cenliq = :cenliq")
    , @NamedQuery(name = "Liquidacion.findByDesliq", query = "SELECT l FROM Liquidacion l WHERE l.desliq = :desliq")
    , @NamedQuery(name = "Liquidacion.findByForliq", query = "SELECT l FROM Liquidacion l WHERE l.forliq = :forliq")
    , @NamedQuery(name = "Liquidacion.findByGasliq", query = "SELECT l FROM Liquidacion l WHERE l.gasliq = :gasliq")
    , @NamedQuery(name = "Liquidacion.findBySalliq", query = "SELECT l FROM Liquidacion l WHERE l.salliq = :salliq")
    , @NamedQuery(name = "Liquidacion.findByEstliq", query = "SELECT l FROM Liquidacion l WHERE l.estliq = :estliq")})
public class Liquidacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLIQ")
    private BigDecimal idliq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MOTLIQ")
    private String motliq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECLIQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecliq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ARELIQ")
    private String areliq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CENLIQ")
    private String cenliq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESLIQ")
    private String desliq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FORLIQ")
    private String forliq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GASLIQ")
    private BigDecimal gasliq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALLIQ")
    private BigDecimal salliq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTLIQ")
    private Character estliq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idliq")
    private List<Reembolso> reembolsoList;
    @JoinColumn(name = "IDVAL", referencedColumnName = "IDVAL")
    @ManyToOne(optional = false)
    private Valeprovisional idval;

    public Liquidacion() {
    }

    public Liquidacion(BigDecimal idliq) {
        this.idliq = idliq;
    }

    public Liquidacion(BigDecimal idliq, String motliq, Date fecliq, String areliq, String cenliq, String desliq, String forliq, BigDecimal gasliq, BigDecimal salliq, Character estliq) {
        this.idliq = idliq;
        this.motliq = motliq;
        this.fecliq = fecliq;
        this.areliq = areliq;
        this.cenliq = cenliq;
        this.desliq = desliq;
        this.forliq = forliq;
        this.gasliq = gasliq;
        this.salliq = salliq;
        this.estliq = estliq;
    }

    public BigDecimal getIdliq() {
        return idliq;
    }

    public void setIdliq(BigDecimal idliq) {
        this.idliq = idliq;
    }

    public String getMotliq() {
        return motliq;
    }

    public void setMotliq(String motliq) {
        this.motliq = motliq;
    }

    public Date getFecliq() {
        return fecliq;
    }

    public void setFecliq(Date fecliq) {
        this.fecliq = fecliq;
    }

    public String getAreliq() {
        return areliq;
    }

    public void setAreliq(String areliq) {
        this.areliq = areliq;
    }

    public String getCenliq() {
        return cenliq;
    }

    public void setCenliq(String cenliq) {
        this.cenliq = cenliq;
    }

    public String getDesliq() {
        return desliq;
    }

    public void setDesliq(String desliq) {
        this.desliq = desliq;
    }

    public String getForliq() {
        return forliq;
    }

    public void setForliq(String forliq) {
        this.forliq = forliq;
    }

    public BigDecimal getGasliq() {
        return gasliq;
    }

    public void setGasliq(BigDecimal gasliq) {
        this.gasliq = gasliq;
    }

    public BigDecimal getSalliq() {
        return salliq;
    }

    public void setSalliq(BigDecimal salliq) {
        this.salliq = salliq;
    }

    public Character getEstliq() {
        return estliq;
    }

    public void setEstliq(Character estliq) {
        this.estliq = estliq;
    }

    @XmlTransient
    public List<Reembolso> getReembolsoList() {
        return reembolsoList;
    }

    public void setReembolsoList(List<Reembolso> reembolsoList) {
        this.reembolsoList = reembolsoList;
    }

    public Valeprovisional getIdval() {
        return idval;
    }

    public void setIdval(Valeprovisional idval) {
        this.idval = idval;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idliq != null ? idliq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liquidacion)) {
            return false;
        }
        Liquidacion other = (Liquidacion) object;
        if ((this.idliq == null && other.idliq != null) || (this.idliq != null && !this.idliq.equals(other.idliq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Liquidacion[ idliq=" + idliq + " ]";
    }
    
}
