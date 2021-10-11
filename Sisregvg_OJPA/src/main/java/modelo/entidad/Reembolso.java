/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhianpol
 */
@Entity
@Table(name = "REEMBOLSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reembolso.findAll", query = "SELECT r FROM Reembolso r")
    , @NamedQuery(name = "Reembolso.findByIdree", query = "SELECT r FROM Reembolso r WHERE r.idree = :idree")
    , @NamedQuery(name = "Reembolso.findByMotree", query = "SELECT r FROM Reembolso r WHERE r.motree = :motree")
    , @NamedQuery(name = "Reembolso.findByFecree", query = "SELECT r FROM Reembolso r WHERE r.fecree = :fecree")
    , @NamedQuery(name = "Reembolso.findByAreree", query = "SELECT r FROM Reembolso r WHERE r.areree = :areree")
    , @NamedQuery(name = "Reembolso.findByCenree", query = "SELECT r FROM Reembolso r WHERE r.cenree = :cenree")
    , @NamedQuery(name = "Reembolso.findByDesree", query = "SELECT r FROM Reembolso r WHERE r.desree = :desree")
    , @NamedQuery(name = "Reembolso.findByForree", query = "SELECT r FROM Reembolso r WHERE r.forree = :forree")
    , @NamedQuery(name = "Reembolso.findByPagree", query = "SELECT r FROM Reembolso r WHERE r.pagree = :pagree")
    , @NamedQuery(name = "Reembolso.findByNahree", query = "SELECT r FROM Reembolso r WHERE r.nahree = :nahree")
    , @NamedQuery(name = "Reembolso.findByNcuree", query = "SELECT r FROM Reembolso r WHERE r.ncuree = :ncuree")
    , @NamedQuery(name = "Reembolso.findBySalree", query = "SELECT r FROM Reembolso r WHERE r.salree = :salree")
    , @NamedQuery(name = "Reembolso.findByEstree", query = "SELECT r FROM Reembolso r WHERE r.estree = :estree")})
public class Reembolso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREE")
    private BigDecimal idree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "MOTREE")
    private String motree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECREE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "AREREE")
    private String areree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CENREE")
    private String cenree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESREE")
    private String desree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FORREE")
    private String forree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PAGREE")
    private String pagree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NAHREE")
    private String nahree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NCUREE")
    private String ncuree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALREE")
    private BigDecimal salree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTREE")
    private Character estree;
    @JoinColumn(name = "IDLIQ", referencedColumnName = "IDLIQ")
    @ManyToOne(optional = false)
    private Liquidacion idliq;

    public Reembolso() {
    }

    public Reembolso(BigDecimal idree) {
        this.idree = idree;
    }

    public Reembolso(BigDecimal idree, String motree, Date fecree, String areree, String cenree, String desree, String forree, String pagree, String nahree, String ncuree, BigDecimal salree, Character estree) {
        this.idree = idree;
        this.motree = motree;
        this.fecree = fecree;
        this.areree = areree;
        this.cenree = cenree;
        this.desree = desree;
        this.forree = forree;
        this.pagree = pagree;
        this.nahree = nahree;
        this.ncuree = ncuree;
        this.salree = salree;
        this.estree = estree;
    }

    public BigDecimal getIdree() {
        return idree;
    }

    public void setIdree(BigDecimal idree) {
        this.idree = idree;
    }

    public String getMotree() {
        return motree;
    }

    public void setMotree(String motree) {
        this.motree = motree;
    }

    public Date getFecree() {
        return fecree;
    }

    public void setFecree(Date fecree) {
        this.fecree = fecree;
    }

    public String getAreree() {
        return areree;
    }

    public void setAreree(String areree) {
        this.areree = areree;
    }

    public String getCenree() {
        return cenree;
    }

    public void setCenree(String cenree) {
        this.cenree = cenree;
    }

    public String getDesree() {
        return desree;
    }

    public void setDesree(String desree) {
        this.desree = desree;
    }

    public String getForree() {
        return forree;
    }

    public void setForree(String forree) {
        this.forree = forree;
    }

    public String getPagree() {
        return pagree;
    }

    public void setPagree(String pagree) {
        this.pagree = pagree;
    }

    public String getNahree() {
        return nahree;
    }

    public void setNahree(String nahree) {
        this.nahree = nahree;
    }

    public String getNcuree() {
        return ncuree;
    }

    public void setNcuree(String ncuree) {
        this.ncuree = ncuree;
    }

    public BigDecimal getSalree() {
        return salree;
    }

    public void setSalree(BigDecimal salree) {
        this.salree = salree;
    }

    public Character getEstree() {
        return estree;
    }

    public void setEstree(Character estree) {
        this.estree = estree;
    }

    public Liquidacion getIdliq() {
        return idliq;
    }

    public void setIdliq(Liquidacion idliq) {
        this.idliq = idliq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idree != null ? idree.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reembolso)) {
            return false;
        }
        Reembolso other = (Reembolso) object;
        if ((this.idree == null && other.idree != null) || (this.idree != null && !this.idree.equals(other.idree))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Reembolso[ idree=" + idree + " ]";
    }
    
}
