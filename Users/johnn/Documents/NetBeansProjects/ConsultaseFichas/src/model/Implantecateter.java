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
@Table(name = "implantecateter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Implantecateter.findAll", query = "SELECT i FROM Implantecateter i")
    , @NamedQuery(name = "Implantecateter.findByIdimplantecateter", query = "SELECT i FROM Implantecateter i WHERE i.idimplantecateter = :idimplantecateter")
    , @NamedQuery(name = "Implantecateter.findByNomepaciente", query = "SELECT i FROM Implantecateter i WHERE i.nomepaciente = :nomepaciente")
    , @NamedQuery(name = "Implantecateter.findByDataDoImplante", query = "SELECT i FROM Implantecateter i WHERE i.dataDoImplante = :dataDoImplante")})
public class Implantecateter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idimplantecateter")
    private Integer idimplantecateter;
    @Column(name = "nomepaciente")
    private String nomepaciente;
    @Column(name = "data_do_implante")
    @Temporal(TemporalType.DATE)
    private Date dataDoImplante;
    @JoinColumn(name = "bloco_cirurgico_id", referencedColumnName = "idbloco_cirurgico")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BlocoCirurgico blocoCirurgicoId;
    @JoinColumn(name = "medicos_idmedicos", referencedColumnName = "idmedicos")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicos medicosIdmedicos;

    public Implantecateter() {
    }

    public Implantecateter(Integer idimplantecateter) {
        this.idimplantecateter = idimplantecateter;
    }

    public Integer getIdimplantecateter() {
        return idimplantecateter;
    }

    public void setIdimplantecateter(Integer idimplantecateter) {
        this.idimplantecateter = idimplantecateter;
    }

    public String getNomepaciente() {
        return nomepaciente;
    }

    public void setNomepaciente(String nomepaciente) {
        this.nomepaciente = nomepaciente;
    }

    public Date getDataDoImplante() {
        return dataDoImplante;
    }

    public void setDataDoImplante(Date dataDoImplante) {
        this.dataDoImplante = dataDoImplante;
    }

    public BlocoCirurgico getBlocoCirurgicoId() {
        return blocoCirurgicoId;
    }

    public void setBlocoCirurgicoId(BlocoCirurgico blocoCirurgicoId) {
        this.blocoCirurgicoId = blocoCirurgicoId;
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
        hash += (idimplantecateter != null ? idimplantecateter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Implantecateter)) {
            return false;
        }
        Implantecateter other = (Implantecateter) object;
        if ((this.idimplantecateter == null && other.idimplantecateter != null) || (this.idimplantecateter != null && !this.idimplantecateter.equals(other.idimplantecateter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Implantecateter[ idimplantecateter=" + idimplantecateter + " ]";
    }
    
}
