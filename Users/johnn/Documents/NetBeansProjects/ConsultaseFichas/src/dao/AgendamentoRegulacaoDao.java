/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Agendamentopermcath;
import model.Regulacao;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class AgendamentoRegulacaoDao {
    private EntityManager em;
    
    
    public AgendamentoRegulacaoDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Regulacao reg){
        em.getTransaction().begin();
        em.persist(reg);
        em.getTransaction().commit();
    }
    public void alterar(Regulacao reg){
        em.getTransaction().begin();
        em.merge(reg);
        em.getTransaction().commit();
    }
    public void excluir(Regulacao reg){
        em.getTransaction().begin();
        em.remove(reg);
        em.getTransaction().commit();
    }
    public List getList(String reg){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT r from Regulacao r where r.nome LIKE :likes");
       query.setParameter("likes", "%" + reg.trim() + "%");
       List<Agendamentopermcath> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    public List getListdata(String nome, int mes, int year){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT r from Regulacao r where month(r.dataencaminhamento) =:mes and year(r.dataencaminhamento) =:ano and r.nome LIKE :nome");
       query.setParameter("mes", mes);
       query.setParameter("ano", year);
       query.setParameter("nome", "%" + nome.trim() + "%");
       List<Regulacao> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    public List getListHosp(String hosp, int mes, int year){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT r from Regulacao r where month(r.dataencaminhamento) =:mes and year(r.dataencaminhamento) =:ano and r.hospital LIKE :hosp");
       query.setParameter("mes", mes);
       query.setParameter("ano", year);
       query.setParameter("hosp", "%" + hosp.trim() + "%");
       List<Regulacao> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
