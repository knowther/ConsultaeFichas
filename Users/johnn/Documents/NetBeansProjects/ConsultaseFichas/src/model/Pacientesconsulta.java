/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johnn
 */
@Entity
@Table(name = "pacientesconsulta")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Pacientesconsulta.findAll", query = "SELECT p FROM Pacientesconsulta p")
//    , @NamedQuery(name = "Pacientesconsulta.findByIdpacientesConsulta", query = "SELECT p FROM Pacientesconsulta p WHERE p.idpacientesConsulta = :idpacientesConsulta")
//    , @NamedQuery(name = "Pacientesconsulta.findByNome", query = "SELECT p FROM Pacientesconsulta p WHERE p.nome = :nome")
//    , @NamedQuery(name = "Pacientesconsulta.findByApelido", query = "SELECT p FROM Pacientesconsulta p WHERE p.apelido = :apelido")
//    , @NamedQuery(name = "Pacientesconsulta.findByIdade", query = "SELECT p FROM Pacientesconsulta p WHERE p.idade = :idade")
//    , @NamedQuery(name = "Pacientesconsulta.findByEndereco", query = "SELECT p FROM Pacientesconsulta p WHERE p.endereco = :endereco")
//    , @NamedQuery(name = "Pacientesconsulta.findByBairro", query = "SELECT p FROM Pacientesconsulta p WHERE p.bairro = :bairro")
//    , @NamedQuery(name = "Pacientesconsulta.findByCidade", query = "SELECT p FROM Pacientesconsulta p WHERE p.cidade = :cidade")
//    , @NamedQuery(name = "Pacientesconsulta.findByNumero", query = "SELECT p FROM Pacientesconsulta p WHERE p.numero = :numero")
//    , @NamedQuery(name = "Pacientesconsulta.findByTel", query = "SELECT p FROM Pacientesconsulta p WHERE p.tel = :tel")
//    , @NamedQuery(name = "Pacientesconsulta.findByTel2", query = "SELECT p FROM Pacientesconsulta p WHERE p.tel2 = :tel2")
//    , @NamedQuery(name = "Pacientesconsulta.findByDataNasc", query = "SELECT p FROM Pacientesconsulta p WHERE p.dataNasc = :dataNasc")
//    , @NamedQuery(name = "Pacientesconsulta.findByCpf", query = "SELECT p FROM Pacientesconsulta p WHERE p.cpf = :cpf")
//    , @NamedQuery(name = "Pacientesconsulta.findByRg", query = "SELECT p FROM Pacientesconsulta p WHERE p.rg = :rg")})
public class Pacientesconsulta implements Serializable {

//    @OneToMany(mappedBy = "pacientesConsultaidpacientesConsulta")
//    private Collection<Consulta> consultaCollection;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpacientesConsulta")
    private Integer idpacientesConsulta;
    @Column(name = "nome")
    private String nome;
    @Column(name = "apelido")
    private String apelido;
    @Column(name = "idade")
    private String idade;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "peso")
    private Float peso;
    @Column(name = "temperatura")
    private Float temperatura;
    @Column(name = "altura")
    private Float altura;
    @Column(name = "pa")
    private String pa;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "tel")
    private String tel;
    @Column(name = "tel2")
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
    @JoinColumn(name = "cidade_idcidade", referencedColumnName = "idcidade")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Cidade cidadeIdcidade;
    @JoinColumn(name = "estado_idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Estado estadoIdestado;
    @JoinColumn(name = "medicos_idmedicos", referencedColumnName = "idmedicos")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Medicos medicosIdmedicos;
    
    @JoinColumn(name = "tipodeficha_idtipodeficha", referencedColumnName = "idtipodeficha")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Tipodeficha tipodefichaIdtipodeficha;

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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        String oldIdade = this.idade;
        this.idade = idade;
        changeSupport.firePropertyChange("idade", oldIdade, idade);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

   

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }
    
    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        Float oldTemperatura = this.temperatura;
        this.temperatura = temperatura;
        changeSupport.firePropertyChange("temperatura", oldTemperatura, temperatura);
    }
    
    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        Float oldPeso = this.peso;
        this.peso = peso;
        changeSupport.firePropertyChange("peso", oldPeso, peso);
    }
    
    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        Float oldAltura = this.altura;
        this.altura = altura;
        changeSupport.firePropertyChange("altura", oldAltura, altura);
    }
    
    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        String oldPa = this.pa;
        this.pa = pa;
        changeSupport.firePropertyChange("pa", oldPa, pa);
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

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        String oldHistorico = this.historico;
        this.historico = historico;
        changeSupport.firePropertyChange("historico", oldHistorico, historico);
    }

    public Cidade getCidadeIdcidade() {
        return cidadeIdcidade;
    }

    public void setCidadeIdcidade(Cidade cidadeIdcidade) {
        Cidade oldCidadeidcidade = this.cidadeIdcidade;
        this.cidadeIdcidade = cidadeIdcidade;
        changeSupport.firePropertyChange("cidadeIdcidade", oldCidadeidcidade, cidadeIdcidade);
    }

    public Estado getEstadoIdestado() {
        return estadoIdestado;
    }

    public void setEstadoIdestado(Estado estadoIdestado) {
        Estado oldEstadoidestado = this.estadoIdestado;
        this.estadoIdestado = estadoIdestado;
        changeSupport.firePropertyChange("estadoIdestado", oldEstadoidestado, estadoIdestado);
    }

    public Medicos getMedicosIdmedicos() {
        return medicosIdmedicos;
    }

    public void setMedicosIdmedicos(Medicos medicosIdmedicos) {
        Medicos oldMedicosidmedicos = this.medicosIdmedicos;
        this.medicosIdmedicos = medicosIdmedicos;
        changeSupport.firePropertyChange("medicosIdmedicos", oldMedicosidmedicos, medicosIdmedicos);
    }

    public Tipodeficha getTipodefichaIdtipodeficha() {
        return tipodefichaIdtipodeficha;
    }

    public void setTipodefichaIdtipodeficha(Tipodeficha tipodefichaIdtipodeficha) {
        Tipodeficha oldTipodefichaIdtipodeficha = this.tipodefichaIdtipodeficha;
        this.tipodefichaIdtipodeficha = tipodefichaIdtipodeficha;
        changeSupport.firePropertyChange("tipodefichaIdtipodeficha", oldTipodefichaIdtipodeficha, tipodefichaIdtipodeficha);
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
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

//    @XmlTransient
//    public Collection<Consulta> getConsultaCollection() {
//        return consultaCollection;
//    }
//
//    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
//        this.consultaCollection = consultaCollection;
//    }
    
}
