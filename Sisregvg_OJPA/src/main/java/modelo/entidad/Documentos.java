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
@Table(name = "DOCUMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d")
    , @NamedQuery(name = "Documentos.findByIddoc", query = "SELECT d FROM Documentos d WHERE d.iddoc = :iddoc")
    , @NamedQuery(name = "Documentos.findByImpdoc", query = "SELECT d FROM Documentos d WHERE d.impdoc = :impdoc")
    , @NamedQuery(name = "Documentos.findByFecdoc", query = "SELECT d FROM Documentos d WHERE d.fecdoc = :fecdoc")
    , @NamedQuery(name = "Documentos.findByAsudoc", query = "SELECT d FROM Documentos d WHERE d.asudoc = :asudoc")
    , @NamedQuery(name = "Documentos.findByEstdoc", query = "SELECT d FROM Documentos d WHERE d.estdoc = :estdoc")})
public class Documentos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDOC")
    private BigDecimal iddoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IMPDOC")
    private BigDecimal impdoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECDOC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecdoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ASUDOC")
    private String asudoc;
    @Column(name = "ESTDOC")
    private Character estdoc;

    public Documentos() {
    }

    public Documentos(BigDecimal iddoc) {
        this.iddoc = iddoc;
    }

    public Documentos(BigDecimal iddoc, BigDecimal impdoc, Date fecdoc, String asudoc) {
        this.iddoc = iddoc;
        this.impdoc = impdoc;
        this.fecdoc = fecdoc;
        this.asudoc = asudoc;
    }

    public BigDecimal getIddoc() {
        return iddoc;
    }

    public void setIddoc(BigDecimal iddoc) {
        this.iddoc = iddoc;
    }

    public BigDecimal getImpdoc() {
        return impdoc;
    }

    public void setImpdoc(BigDecimal impdoc) {
        this.impdoc = impdoc;
    }

    public Date getFecdoc() {
        return fecdoc;
    }

    public void setFecdoc(Date fecdoc) {
        this.fecdoc = fecdoc;
    }

    public String getAsudoc() {
        return asudoc;
    }

    public void setAsudoc(String asudoc) {
        this.asudoc = asudoc;
    }

    public Character getEstdoc() {
        return estdoc;
    }

    public void setEstdoc(Character estdoc) {
        this.estdoc = estdoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddoc != null ? iddoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.iddoc == null && other.iddoc != null) || (this.iddoc != null && !this.iddoc.equals(other.iddoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Documentos[ iddoc=" + iddoc + " ]";
    }
    
}
