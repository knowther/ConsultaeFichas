/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johnn
 */
@Entity
@Table(name = "pacientesconsulta")
@XmlRootElement

public class Pacientesconsulta implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpacientesConsulta")
    private Integer idpacientesConsulta;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Apelido")
    private String apelido;
    
    @Column (name = "numero")
    private String numero;
            
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "Tel")
    private String tel;
    @Column(name = "Tel2")
    private String tel2;
    @Column(name = "dataNasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    
    @Lob
    @Column(name = "historico")
    private String historico;
    
    @ManyToOne
    private Medicos medicos;
    
    @ManyToOne
    private Estado estado;
    
    @ManyToOne
    private Cidade cidade;

    public Pacientesconsulta() {
    }

    public Pacientesconsulta(Integer idpacientesConsulta) {
        this.idpacientesConsulta = idpacientesConsulta;
    }

    public Integer getIdpacientesConsulta() {
        return idpacientesConsulta;
    }

    public void setIdpacientesConsulta(Integer idpacientesConsulta) {
        Integer oldIdpacientesConsulta = this.idpacientesConsulta;
        this.idpacientesConsulta = idpacientesConsulta;
        changeSupport.firePropertyChange("idpacientesConsulta", oldIdpacientesConsulta, idpacientesConsulta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        String oldApelido = this.apelido;
        this.apelido = apelido;
        changeSupport.firePropertyChange("apelido", oldApelido, apelido);
    }
    
    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        String oldHistorico = this.historico;
        this.historico = historico;
        changeSupport.firePropertyChange("historico", oldHistorico, historico);
    }
    


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }
    
     public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }
    
    

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        Cidade oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        Estado oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        String oldTel = this.tel;
        this.tel = tel;
        changeSupport.firePropertyChange("tel", oldTel, tel);
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        String oldTel2 = this.tel2;
        this.tel2 = tel2;
        changeSupport.firePropertyChange("tel2", oldTel2, tel2);
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        Date oldDataNasc = this.dataNasc;
        this.dataNasc = dataNasc;
        changeSupport.firePropertyChange("dataNasc", oldDataNasc, dataNasc);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }
    
    public void setMedico(Medicos medicos) {
        Medicos oldMedicos = this.medicos;
        this.medicos = medicos;
        changeSupport.firePropertyChange("medicos", oldMedicos, medicos);
    }

    public Medicos getMedico() {
        return medicos;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpacientesConsulta != null ? idpacientesConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientesconsulta)) {
            return false;
        }
        Pacientesconsulta other = (Pacientesconsulta) object;
        if ((this.idpacientesConsulta == null && other.idpacientesConsulta != null) || (this.idpacientesConsulta != null && !this.idpacientesConsulta.equals(other.idpacientesConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pacientesconsulta[ idpacientesConsulta=" + idpacientesConsulta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
