/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johnn
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdcategoria", query = "SELECT c FROM Categoria c WHERE c.idcategoria = :idcategoria")
    , @NamedQuery(name = "Categoria.findByDescricao", query = "SELECT c FROM Categoria c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Categoria.findByTipo", query = "SELECT c FROM Categoria c WHERE c.tipo = :tipo")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoria")
    private Integer idcategoria;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(orphanRemoval = true, mappedBy = "categoriaIdcategoria", fetch = FetchType.EAGER)
    private List<Movimentacaodraedna> movimentacaodraednaList;
    @OneToMany(orphanRemoval = true, mappedBy = "categoriaIdcategoria", fetch = FetchType.EAGER)
    private List<Movimentacaoconsultorio> movimentacaoconsultorioList;

    public Categoria() {
    }

    public Categoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Movimentacaodraedna> getMovimentacaodraednaList() {
        return movimentacaodraednaList;
    }

    public void setMovimentacaodraednaList(List<Movimentacaodraedna> movimentacaodraednaList) {
        this.movimentacaodraednaList = movimentacaodraednaList;
    }

    @XmlTransient
    public List<Movimentacaoconsultorio> getMovimentacaoconsultorioList() {
        return movimentacaoconsultorioList;
    }

    public void setMovimentacaoconsultorioList(List<Movimentacaoconsultorio> movimentacaoconsultorioList) {
        this.movimentacaoconsultorioList = movimentacaoconsultorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoria != null ? idcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcategoria == null && other.idcategoria != null) || (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categoria[ idcategoria=" + idcategoria + " ]";
    }
    
}
