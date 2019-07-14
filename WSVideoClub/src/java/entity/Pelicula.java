/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
 * @author alexa
 */
@Entity
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findByPelId", query = "SELECT p FROM Pelicula p WHERE p.pelId = :pelId")
    , @NamedQuery(name = "Pelicula.findByPelNombre", query = "SELECT p FROM Pelicula p WHERE p.pelNombre = :pelNombre")
    , @NamedQuery(name = "Pelicula.findByPelCosto", query = "SELECT p FROM Pelicula p WHERE p.pelCosto = :pelCosto")
    , @NamedQuery(name = "Pelicula.findByPelFechaEstreno", query = "SELECT p FROM Pelicula p WHERE p.pelFechaEstreno = :pelFechaEstreno")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEL_ID")
    private Integer pelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PEL_NOMBRE")
    private String pelNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEL_COSTO")
    private BigDecimal pelCosto;
    @Column(name = "PEL_FECHA_ESTRENO")
    @Temporal(TemporalType.DATE)
    private Date pelFechaEstreno;
    @OneToMany(mappedBy = "pelId")
    private Collection<ActorPelicula> actorPeliculaCollection;
    @JoinColumn(name = "DIR_ID", referencedColumnName = "DIR_ID")
    @ManyToOne
    private Director dirId;
    @JoinColumn(name = "FOR_ID", referencedColumnName = "FOR_ID")
    @ManyToOne
    private Formato forId;
    @JoinColumn(name = "GEN_ID", referencedColumnName = "GEN_ID")
    @ManyToOne
    private Genero genId;
    @OneToMany(mappedBy = "pelId")
    private Collection<Alquiler> alquilerCollection;

    public Pelicula() {
    }

    public Pelicula(Integer pelId) {
        this.pelId = pelId;
    }

    public Pelicula(Integer pelId, String pelNombre, BigDecimal pelCosto) {
        this.pelId = pelId;
        this.pelNombre = pelNombre;
        this.pelCosto = pelCosto;
    }

    public Integer getPelId() {
        return pelId;
    }

    public void setPelId(Integer pelId) {
        this.pelId = pelId;
    }

    public String getPelNombre() {
        return pelNombre;
    }

    public void setPelNombre(String pelNombre) {
        this.pelNombre = pelNombre;
    }

    public BigDecimal getPelCosto() {
        return pelCosto;
    }

    public void setPelCosto(BigDecimal pelCosto) {
        this.pelCosto = pelCosto;
    }

    public Date getPelFechaEstreno() {
        return pelFechaEstreno;
    }

    public void setPelFechaEstreno(Date pelFechaEstreno) {
        this.pelFechaEstreno = pelFechaEstreno;
    }

    @XmlTransient
    public Collection<ActorPelicula> getActorPeliculaCollection() {
        return actorPeliculaCollection;
    }

    public void setActorPeliculaCollection(Collection<ActorPelicula> actorPeliculaCollection) {
        this.actorPeliculaCollection = actorPeliculaCollection;
    }

    public Director getDirId() {
        return dirId;
    }

    public void setDirId(Director dirId) {
        this.dirId = dirId;
    }

    public Formato getForId() {
        return forId;
    }

    public void setForId(Formato forId) {
        this.forId = forId;
    }

    public Genero getGenId() {
        return genId;
    }

    public void setGenId(Genero genId) {
        this.genId = genId;
    }

    @XmlTransient
    public Collection<Alquiler> getAlquilerCollection() {
        return alquilerCollection;
    }

    public void setAlquilerCollection(Collection<Alquiler> alquilerCollection) {
        this.alquilerCollection = alquilerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pelId != null ? pelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.pelId == null && other.pelId != null) || (this.pelId != null && !this.pelId.equals(other.pelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pelicula[ pelId=" + pelId + " ]";
    }
    
}
