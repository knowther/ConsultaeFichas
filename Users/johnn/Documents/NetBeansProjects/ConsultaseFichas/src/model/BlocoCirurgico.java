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
@Table(name = "bloco_cirurgico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlocoCirurgico.findAll", query = "SELECT b FROM BlocoCirurgico b")
    , @NamedQuery(name = "BlocoCirurgico.findByIdblocoCirurgico", query = "SELECT b FROM BlocoCirurgico b WHERE b.idblocoCirurgico = :idblocoCirurgico")
    , @NamedQuery(name = "BlocoCirurgico.findByNomeBlococirurgico", query = "SELECT b FROM BlocoCirurgico b WHERE b.nomeBlococirurgico = :nomeBlococirurgico")})
public class BlocoCirurgico implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blocoCirurgicoId", fetch = FetchType.EAGER)
    private List<Implantecateter> implantecateterList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbloco_cirurgico")
    private Integer idblocoCirurgico;
    @Column(name = "nome_blococirurgico")
    private String nomeBlococirurgico;

    public BlocoCirurgico() {
    }

    public BlocoCirurgico(Integer idblocoCirurgico) {
        this.idblocoCirurgico = idblocoCirurgico;
    }

    public Integer getIdblocoCirurgico() {
        return idblocoCirurgico;
    }

    public void setIdblocoCirurgico(Integer idblocoCirurgico) {
        this.idblocoCirurgico = idblocoCirurgico;
    }

    public String getNomeBlococirurgico() {
        return nomeBlococirurgico;
    }

    public void setNomeBlococirurgico(String nomeBlococirurgico) {
        this.nomeBlococirurgico = nomeBlococirurgico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idblocoCirurgico != null ? idblocoCirurgico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlocoCirurgico)) {
            return false;
        }
        BlocoCirurgico other = (BlocoCirurgico) object;
        if ((this.idblocoCirurgico == null && other.idblocoCirurgico != null) || (this.idblocoCirurgico != null && !this.idblocoCirurgico.equals(other.idblocoCirurgico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BlocoCirurgico[ idblocoCirurgico=" + idblocoCirurgico + " ]";
    }

    @XmlTransient
    public List<Implantecateter> getImplantecateterList() {
        return implantecateterList;
    }

    public void setImplantecateterList(List<Implantecateter> implantecateterList) {
        this.implantecateterList = implantecateterList;
    }
    
}
