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
import javax.persistence.FetchType;
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
@Table(name = "movimentacaodraedna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacaodraedna.findAll", query = "SELECT m FROM Movimentacaodraedna m")
    , @NamedQuery(name = "Movimentacaodraedna.findByIdmovimentacao", query = "SELECT m FROM Movimentacaodraedna m WHERE m.idmovimentacao = :idmovimentacao")
    , @NamedQuery(name = "Movimentacaodraedna.findByValor", query = "SELECT m FROM Movimentacaodraedna m WHERE m.valor = :valor")
    , @NamedQuery(name = "Movimentacaodraedna.findByData", query = "SELECT m FROM Movimentacaodraedna m WHERE m.data = :data")
    , @NamedQuery(name = "Movimentacaodraedna.findByObs", query = "SELECT m FROM Movimentacaodraedna m WHERE m.obs = :obs")
    , @NamedQuery(name = "Movimentacaodraedna.findByDataCadastro", query = "SELECT m FROM Movimentacaodraedna m WHERE m.dataCadastro = :dataCadastro")})
public class Movimentacaodraedna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimentacao")
    private Integer idmovimentacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "obs")
    private String obs;
    @Column(name = "dataCadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @JoinColumn(name = "categoria_idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categoria categoriaIdcategoria;

    public Movimentacaodraedna() {
    }

    public Movimentacaodraedna(Integer idmovimentacao) {
        this.idmovimentacao = idmovimentacao;
    }

  

    public Integer getIdmovimentacao() {
        return idmovimentacao;
    }

    public void setIdmovimentacao(Integer idmovimentacao) {
        this.idmovimentacao = idmovimentacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoriaIdcategoria() {
        return categoriaIdcategoria;
    }

    public void setCategoriaIdcategoria(Categoria categoriaIdcategoria) {
        this.categoriaIdcategoria = categoriaIdcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimentacao != null ? idmovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacaodraedna)) {
            return false;
        }
        Movimentacaodraedna other = (Movimentacaodraedna) object;
        if ((this.idmovimentacao == null && other.idmovimentacao != null) || (this.idmovimentacao != null && !this.idmovimentacao.equals(other.idmovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Movimentacaodraedna[ idmovimentacao=" + idmovimentacao + " ]";
    }
    
}
