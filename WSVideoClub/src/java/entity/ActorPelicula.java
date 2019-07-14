/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "actor_pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActorPelicula.findAll", query = "SELECT a FROM ActorPelicula a")
    , @NamedQuery(name = "ActorPelicula.findByAplId", query = "SELECT a FROM ActorPelicula a WHERE a.aplId = :aplId")
    , @NamedQuery(name = "ActorPelicula.findByAplPapel", query = "SELECT a FROM ActorPelicula a WHERE a.aplPapel = :aplPapel")})
public class ActorPelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "APL_ID")
    private Integer aplId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "APL_PAPEL")
    private String aplPapel;
    @JoinColumn(name = "ACT_ID", referencedColumnName = "ACT_ID")
    @ManyToOne
    private Actor actId;
    @JoinColumn(name = "PEL_ID", referencedColumnName = "PEL_ID")
    @ManyToOne
    private Pelicula pelId;

    public ActorPelicula() {
    }

    public ActorPelicula(Integer aplId) {
        this.aplId = aplId;
    }

    public ActorPelicula(Integer aplId, String aplPapel) {
        this.aplId = aplId;
        this.aplPapel = aplPapel;
    }

    public Integer getAplId() {
        return aplId;
    }

    public void setAplId(Integer aplId) {
        this.aplId = aplId;
    }

    public String getAplPapel() {
        return aplPapel;
    }

    public void setAplPapel(String aplPapel) {
        this.aplPapel = aplPapel;
    }

    public Actor getActId() {
        return actId;
    }

    public void setActId(Actor actId) {
        this.actId = actId;
    }

    public Pelicula getPelId() {
        return pelId;
    }

    public void setPelId(Pelicula pelId) {
        this.pelId = pelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aplId != null ? aplId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActorPelicula)) {
            return false;
        }
        ActorPelicula other = (ActorPelicula) object;
        if ((this.aplId == null && other.aplId != null) || (this.aplId != null && !this.aplId.equals(other.aplId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActorPelicula[ aplId=" + aplId + " ]";
    }
    
}
