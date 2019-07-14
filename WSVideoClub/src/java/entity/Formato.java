/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author alexa
 */
@Entity
@Table(name = "formato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formato.findAll", query = "SELECT f FROM Formato f")
    , @NamedQuery(name = "Formato.findByForId", query = "SELECT f FROM Formato f WHERE f.forId = :forId")
    , @NamedQuery(name = "Formato.findByForNombre", query = "SELECT f FROM Formato f WHERE f.forNombre = :forNombre")})
public class Formato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOR_ID")
    private Integer forId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FOR_NOMBRE")
    private String forNombre;
    @OneToMany(mappedBy = "forId")
    private Collection<Pelicula> peliculaCollection;

    public Formato() {
    }

    public Formato(Integer forId) {
        this.forId = forId;
    }

    public Formato(Integer forId, String forNombre) {
        this.forId = forId;
        this.forNombre = forNombre;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
    }

    public String getForNombre() {
        return forNombre;
    }

    public void setForNombre(String forNombre) {
        this.forNombre = forNombre;
    }

    @XmlTransient
    public Collection<Pelicula> getPeliculaCollection() {
        return peliculaCollection;
    }

    public void setPeliculaCollection(Collection<Pelicula> peliculaCollection) {
        this.peliculaCollection = peliculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forId != null ? forId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formato)) {
            return false;
        }
        Formato other = (Formato) object;
        if ((this.forId == null && other.forId != null) || (this.forId != null && !this.forId.equals(other.forId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Formato[ forId=" + forId + " ]";
    }
    
}
