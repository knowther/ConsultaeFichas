/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johnn
 */
@Entity
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")
    , @NamedQuery(name = "Consulta.findByIdconsulta", query = "SELECT c FROM Consulta c WHERE c.idconsulta = :idconsulta")
    , @NamedQuery(name = "Consulta.findByDatasconsulta", query = "SELECT c FROM Consulta c WHERE c.datasconsulta = :datasconsulta")
    , @NamedQuery(name = "Consulta.findByHora", query = "SELECT c FROM Consulta c WHERE c.hora = :hora")
    , @NamedQuery(name = "Consulta.findByNome", query = "SELECT c FROM Consulta c WHERE c.nome = :nome")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsulta")
    private Integer idconsulta;
    @Column(name = "datasconsulta")
    @Temporal(TemporalType.DATE)
    private Date datasconsulta;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "medicos_idmedicos", referencedColumnName = "idmedicos")
    @ManyToOne
    private Medicos medicosIdmedicos;

    public Consulta() {
    }

    public Consulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Date getDatasconsulta() {
        return datasconsulta;
    }

    public void setDatasconsulta(Date datasconsulta) {
        this.datasconsulta = datasconsulta;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medicos getMedicosIdmedicos() {
        return medicosIdmedicos;
    }

    public void setMedicosIdmedicos(Medicos medicosIdmedicos) {
        this.medicosIdmedicos = medicosIdmedicos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsulta != null ? idconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idconsulta == null && other.idconsulta != null) || (this.idconsulta != null && !this.idconsulta.equals(other.idconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consulta[ idconsulta=" + idconsulta + " ]";
    }
    
}
