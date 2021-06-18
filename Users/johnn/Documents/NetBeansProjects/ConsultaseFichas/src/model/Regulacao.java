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
@Table(name = "regulacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regulacao.findAll", query = "SELECT r FROM Regulacao r")
    , @NamedQuery(name = "Regulacao.findByIdagendamentoregulacao", query = "SELECT r FROM Regulacao r WHERE r.idagendamentoregulacao = :idagendamentoregulacao")
    , @NamedQuery(name = "Regulacao.findByNome", query = "SELECT r FROM Regulacao r WHERE r.nome = :nome")
    , @NamedQuery(name = "Regulacao.findByHospital", query = "SELECT r FROM Regulacao r WHERE r.hospital = :hospital")
    , @NamedQuery(name = "Regulacao.findByDataencaminhamento", query = "SELECT r FROM Regulacao r WHERE r.dataencaminhamento = :dataencaminhamento")})
public class Regulacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagendamentoregulacao")
    private Integer idagendamentoregulacao;
    @Column(name = "nome")
    private String nome;
    @Column(name = "hospital")
    private String hospital;
    @Column(name = "dataencaminhamento")
    @Temporal(TemporalType.DATE)
    private Date dataencaminhamento;

    public Regulacao() {
    }

    public Regulacao(Integer idagendamentoregulacao) {
        this.idagendamentoregulacao = idagendamentoregulacao;
    }

    public Integer getIdagendamentoregulacao() {
        return idagendamentoregulacao;
    }

    public void setIdagendamentoregulacao(Integer idagendamentoregulacao) {
        this.idagendamentoregulacao = idagendamentoregulacao;
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
        hash += (idagendamentoregulacao != null ? idagendamentoregulacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regulacao)) {
            return false;
        }
        Regulacao other = (Regulacao) object;
        if ((this.idagendamentoregulacao == null && other.idagendamentoregulacao != null) || (this.idagendamentoregulacao != null && !this.idagendamentoregulacao.equals(other.idagendamentoregulacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Regulacao[ idagendamentoregulacao=" + idagendamentoregulacao + " ]";
    }
    
}
