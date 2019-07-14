/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "alquiler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a")
    , @NamedQuery(name = "Alquiler.findByAlqId", query = "SELECT a FROM Alquiler a WHERE a.alqId = :alqId")
    , @NamedQuery(name = "Alquiler.findByAlqFechaDesde", query = "SELECT a FROM Alquiler a WHERE a.alqFechaDesde = :alqFechaDesde")
    , @NamedQuery(name = "Alquiler.findByAlqFechaHasta", query = "SELECT a FROM Alquiler a WHERE a.alqFechaHasta = :alqFechaHasta")
    , @NamedQuery(name = "Alquiler.findByAlqValor", query = "SELECT a FROM Alquiler a WHERE a.alqValor = :alqValor")
    , @NamedQuery(name = "Alquiler.findByAlqFechaEntrega", query = "SELECT a FROM Alquiler a WHERE a.alqFechaEntrega = :alqFechaEntrega")})
public class Alquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALQ_ID")
    private Integer alqId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALQ_FECHA_DESDE")
    @Temporal(TemporalType.DATE)
    private Date alqFechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALQ_FECHA_HASTA")
    @Temporal(TemporalType.DATE)
    private Date alqFechaHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALQ_VALOR")
    private BigDecimal alqValor;
    @Column(name = "ALQ_FECHA_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date alqFechaEntrega;
    @JoinColumn(name = "PEL_ID", referencedColumnName = "PEL_ID")
    @ManyToOne
    private Pelicula pelId;
    @JoinColumn(name = "SOC_ID", referencedColumnName = "SOC_ID")
    @ManyToOne
    private Socio socId;

    public Alquiler() {
    }

    public Alquiler(Integer alqId) {
        this.alqId = alqId;
    }

    public Alquiler(Integer alqId, Date alqFechaDesde, Date alqFechaHasta, BigDecimal alqValor) {
        this.alqId = alqId;
        this.alqFechaDesde = alqFechaDesde;
        this.alqFechaHasta = alqFechaHasta;
        this.alqValor = alqValor;
    }

    public Integer getAlqId() {
        return alqId;
    }

    public void setAlqId(Integer alqId) {
        this.alqId = alqId;
    }

    public Date getAlqFechaDesde() {
        return alqFechaDesde;
    }

    public void setAlqFechaDesde(Date alqFechaDesde) {
        this.alqFechaDesde = alqFechaDesde;
    }

    public Date getAlqFechaHasta() {
        return alqFechaHasta;
    }

    public void setAlqFechaHasta(Date alqFechaHasta) {
        this.alqFechaHasta = alqFechaHasta;
    }

    public BigDecimal getAlqValor() {
        return alqValor;
    }

    public void setAlqValor(BigDecimal alqValor) {
        this.alqValor = alqValor;
    }

    public Date getAlqFechaEntrega() {
        return alqFechaEntrega;
    }

    public void setAlqFechaEntrega(Date alqFechaEntrega) {
        this.alqFechaEntrega = alqFechaEntrega;
    }

    public Pelicula getPelId() {
        return pelId;
    }

    public void setPelId(Pelicula pelId) {
        this.pelId = pelId;
    }

    public Socio getSocId() {
        return socId;
    }

    public void setSocId(Socio socId) {
        this.socId = socId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alqId != null ? alqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alquiler)) {
            return false;
        }
        Alquiler other = (Alquiler) object;
        if ((this.alqId == null && other.alqId != null) || (this.alqId != null && !this.alqId.equals(other.alqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Alquiler[ alqId=" + alqId + " ]";
    }
    
}
