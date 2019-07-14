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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a")
    , @NamedQuery(name = "Actor.findByActId", query = "SELECT a FROM Actor a WHERE a.actId = :actId")
    , @NamedQuery(name = "Actor.findByActNombre", query = "SELECT a FROM Actor a WHERE a.actNombre = :actNombre")})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ACT_ID")
    private Integer actId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ACT_NOMBRE")
    private String actNombre;
    @JoinColumn(name = "SEX_ID", referencedColumnName = "SEX_ID")
    @ManyToOne
    private Sexo sexId;
    @OneToMany(mappedBy = "actId")
    private Collection<ActorPelicula> actorPeliculaCollection;

    public Actor() {
    }

    public Actor(Integer actId) {
        this.actId = actId;
    }

    public Actor(Integer actId, String actNombre) {
        this.actId = actId;
        this.actNombre = actNombre;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getActNombre() {
        return actNombre;
    }

    public void setActNombre(String actNombre) {
        this.actNombre = actNombre;
    }

    public Sexo getSexId() {
        return sexId;
    }

    public void setSexId(Sexo sexId) {
        this.sexId = sexId;
    }

    @XmlTransient
    public Collection<ActorPelicula> getActorPeliculaCollection() {
        return actorPeliculaCollection;
    }

    public void setActorPeliculaCollection(Collection<ActorPelicula> actorPeliculaCollection) {
        this.actorPeliculaCollection = actorPeliculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Actor[ actId=" + actId + " ]";
    }
    
}
