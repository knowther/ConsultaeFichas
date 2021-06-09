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
@Table(name = "agendamentopermcath")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamentopermcath.findAll", query = "SELECT a FROM Agendamentopermcath a")
    , @NamedQuery(name = "Agendamentopermcath.findByIdagendamentopermcath", query = "SELECT a FROM Agendamentopermcath a WHERE a.idagendamentopermcath = :idagendamentopermcath")
    , @NamedQuery(name = "Agendamentopermcath.findByNome", query = "SELECT a FROM Agendamentopermcath a WHERE a.nome = :nome")
    , @NamedQuery(name = "Agendamentopermcath.findByHospital", query = "SELECT a FROM Agendamentopermcath a WHERE a.hospital = :hospital")
    , @NamedQuery(name = "Agendamentopermcath.findByDataencaminhamento", query = "SELECT a FROM Agendamentopermcath a WHERE a.dataencaminhamento = :dataencaminhamento")})
public class Agendamentopermcath implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagendamentopermcath")
    private Integer idagendamentopermcath;
    @Column(name = "nome")
    private String nome;
    @Column(name = "hospital")
    private String hospital;
    @Column(name = "dataencaminhamento")
    @Temporal(TemporalType.DATE)
    private Date dataencaminhamento;

    public Agendamentopermcath() {
    }

    public Agendamentopermcath(Integer idagendamentopermcath) {
        this.idagendamentopermcath = idagendamentopermcath;
    }

    public Integer getIdagendamentopermcath() {
        return idagendamentopermcath;
    }

    public void setIdagendamentopermcath(Integer idagendamentopermcath) {
        this.idagendamentopermcath = idagendamentopermcath;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getDataencaminhamento() {
        return dataencaminhamento;
    }

    public void setDataencaminhamento(Date dataencaminhamento) {
        this.dataencaminhamento = dataencaminhamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idagendamentopermcath != null ? idagendamentopermcath.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamentopermcath)) {
            return false;
        }
        Agendamentopermcath other = (Agendamentopermcath) object;
        if ((this.idagendamentopermcath == null && other.idagendamentopermcath != null) || (this.idagendamentopermcath != null && !this.idagendamentopermcath.equals(other.idagendamentopermcath))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Agendamentopermcath[ idagendamentopermcath=" + idagendamentopermcath + " ]";
    }
    
}
