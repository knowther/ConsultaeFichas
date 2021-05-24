/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johnn
 */
@Entity
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m")
    , @NamedQuery(name = "Medicos.findByIdmedicos", query = "SELECT m FROM Medicos m WHERE m.idmedicos = :idmedicos")
    , @NamedQuery(name = "Medicos.findByNome", query = "SELECT m FROM Medicos m WHERE m.nome = :nome")
    , @NamedQuery(name = "Medicos.findByCrm", query = "SELECT m FROM Medicos m WHERE m.crm = :crm")})
public class Medicos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedicos")
    private Integer idmedicos;
    @Column(name = "nome")
    private String nome;
    @Column(name = "crm")
    private String crm;
    
    @OneToMany(mappedBy = "medicos")
    private List<Pacientesconsulta> pacienteConsulta = new ArrayList<Pacientesconsulta>();

    public Medicos() {
    }

    public Medicos(Integer idmedicos) {
        this.idmedicos = idmedicos;
    }

    public Integer getIdmedicos() {
        return idmedicos;
    }

    public void setIdmedicos(Integer idmedicos) {
        Integer oldIdmedicos = this.idmedicos;
        this.idmedicos = idmedicos;
        changeSupport.firePropertyChange("idmedicos", oldIdmedicos, idmedicos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        String oldCrm = this.crm;
        this.crm = crm;
        changeSupport.firePropertyChange("crm", oldCrm, crm);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicos != null ? idmedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.idmedicos == null && other.idmedicos != null) || (this.idmedicos != null && !this.idmedicos.equals(other.idmedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
