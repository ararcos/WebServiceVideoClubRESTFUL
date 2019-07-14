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
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s")
    , @NamedQuery(name = "Socio.findBySocId", query = "SELECT s FROM Socio s WHERE s.socId = :socId")
    , @NamedQuery(name = "Socio.findBySocCedula", query = "SELECT s FROM Socio s WHERE s.socCedula = :socCedula")
    , @NamedQuery(name = "Socio.findBySocNombre", query = "SELECT s FROM Socio s WHERE s.socNombre = :socNombre")
    , @NamedQuery(name = "Socio.findBySocDireccion", query = "SELECT s FROM Socio s WHERE s.socDireccion = :socDireccion")
    , @NamedQuery(name = "Socio.findBySocTelefono", query = "SELECT s FROM Socio s WHERE s.socTelefono = :socTelefono")
    , @NamedQuery(name = "Socio.findBySocCorreo", query = "SELECT s FROM Socio s WHERE s.socCorreo = :socCorreo")})
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SOC_ID")
    private Integer socId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SOC_CEDULA")
    private String socCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "SOC_NOMBRE")
    private String socNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "SOC_DIRECCION")
    private String socDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SOC_TELEFONO")
    private String socTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "SOC_CORREO")
    private String socCorreo;
    @OneToMany(mappedBy = "socId")
    private Collection<Alquiler> alquilerCollection;

    public Socio() {
    }

    public Socio(Integer socId) {
        this.socId = socId;
    }

    public Socio(Integer socId, String socCedula, String socNombre, String socDireccion, String socTelefono, String socCorreo) {
        this.socId = socId;
        this.socCedula = socCedula;
        this.socNombre = socNombre;
        this.socDireccion = socDireccion;
        this.socTelefono = socTelefono;
        this.socCorreo = socCorreo;
    }

    public Integer getSocId() {
        return socId;
    }

    public void setSocId(Integer socId) {
        this.socId = socId;
    }

    public String getSocCedula() {
        return socCedula;
    }

    public void setSocCedula(String socCedula) {
        this.socCedula = socCedula;
    }

    public String getSocNombre() {
        return socNombre;
    }

    public void setSocNombre(String socNombre) {
        this.socNombre = socNombre;
    }

    public String getSocDireccion() {
        return socDireccion;
    }

    public void setSocDireccion(String socDireccion) {
        this.socDireccion = socDireccion;
    }

    public String getSocTelefono() {
        return socTelefono;
    }

    public void setSocTelefono(String socTelefono) {
        this.socTelefono = socTelefono;
    }

    public String getSocCorreo() {
        return socCorreo;
    }

    public void setSocCorreo(String socCorreo) {
        this.socCorreo = socCorreo;
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
        hash += (socId != null ? socId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.socId == null && other.socId != null) || (this.socId != null && !this.socId.equals(other.socId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Socio[ socId=" + socId + " ]";
    }
    
}
