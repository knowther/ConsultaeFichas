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
@Table(name = "horariosdisponiveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horariosdisponiveis.findAll", query = "SELECT h FROM Horariosdisponiveis h")
    , @NamedQuery(name = "Horariosdisponiveis.findByIdHorariosDisponiveis", query = "SELECT h FROM Horariosdisponiveis h WHERE h.idHorariosDisponiveis = :idHorariosDisponiveis")
    , @NamedQuery(name = "Horariosdisponiveis.findByDateDisp", query = "SELECT h FROM Horariosdisponiveis h WHERE h.dateDisp = :dateDisp")
    , @NamedQuery(name = "Horariosdisponiveis.findByHorario", query = "SELECT h FROM Horariosdisponiveis h WHERE h.horario = :horario")})
public class Horariosdisponiveis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHorariosDisponiveis")
    private Integer idHorariosDisponiveis;
    @Column(name = "dateDisp")
    @Temporal(TemporalType.DATE)
    private Date dateDisp;
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;

    public Horariosdisponiveis() {
    }

    public Horariosdisponiveis(Integer idHorariosDisponiveis) {
        this.idHorariosDisponiveis = idHorariosDisponiveis;
    }

    public Integer getIdHorariosDisponiveis() {
        return idHorariosDisponiveis;
    }

    public void setIdHorariosDisponiveis(Integer idHorariosDisponiveis) {
        this.idHorariosDisponiveis = idHorariosDisponiveis;
    }

    public Date getDateDisp() {
        return dateDisp;
    }

    public void setDateDisp(Date dateDisp) {
        this.dateDisp = dateDisp;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorariosDisponiveis != null ? idHorariosDisponiveis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horariosdisponiveis)) {
            return false;
        }
        Horariosdisponiveis other = (Horariosdisponiveis) object;
        if ((this.idHorariosDisponiveis == null && other.idHorariosDisponiveis != null) || (this.idHorariosDisponiveis != null && !this.idHorariosDisponiveis.equals(other.idHorariosDisponiveis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Horariosdisponiveis[ idHorariosDisponiveis=" + idHorariosDisponiveis + " ]";
    }
    
}
