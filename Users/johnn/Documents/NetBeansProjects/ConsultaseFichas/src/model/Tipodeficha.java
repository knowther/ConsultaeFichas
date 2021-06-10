/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johnn
 */
@Entity
@Table(name = "tipodeficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeficha.findAll", query = "SELECT t FROM Tipodeficha t")
    , @NamedQuery(name = "Tipodeficha.findByIdtipodeficha", query = "SELECT t FROM Tipodeficha t WHERE t.idtipodeficha = :idtipodeficha")
    , @NamedQuery(name = "Tipodeficha.findByTipodaficha", query = "SELECT t FROM Tipodeficha t WHERE t.tipodaficha = :tipodaficha")})
public class Tipodeficha implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipodeficha")
    private Integer idtipodeficha;
    @Column(name = "tipodaficha")
    private String tipodaficha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodefichaIdtipodeficha", fetch = FetchType.EAGER)
    private List<Pacientesconsulta> pacientesconsultaList;

    public Tipodeficha() {
    }

    public Tipodeficha(Integer idtipodeficha) {
        this.idtipodeficha = idtipodeficha;
    }

    public Integer getIdtipodeficha() {
        return idtipodeficha;
    }

    public void setIdtipodeficha(Integer idtipodeficha) {
        Integer oldIdtipodeficha = this.idtipodeficha;
        this.idtipodeficha = idtipodeficha;
        changeSupport.firePropertyChange("idtipodeficha", oldIdtipodeficha, idtipodeficha);
    }

    public String getTipodaficha() {
        return tipodaficha;
    }

    public void setTipodaficha(String tipodaficha) {
        String oldTipodaficha = this.tipodaficha;
        this.tipodaficha = tipodaficha;
        changeSupport.firePropertyChange("tipodaficha", oldTipodaficha, tipodaficha);
    }

    @XmlTransient
    public List<Pacientesconsulta> getPacientesconsultaList() {
        return pacientesconsultaList;
    }

    public void setPacientesconsultaList(List<Pacientesconsulta> pacientesconsultaList) {
        this.pacientesconsultaList = pacientesconsultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipodeficha != null ? idtipodeficha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeficha)) {
            return false;
        }
        Tipodeficha other = (Tipodeficha) object;
        if ((this.idtipodeficha == null && other.idtipodeficha != null) || (this.idtipodeficha != null && !this.idtipodeficha.equals(other.idtipodeficha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipodaficha;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
