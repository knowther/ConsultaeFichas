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
import model.Pacientesconsulta;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class AgendamentoPermcathDao {
    private EntityManager em;
    
    
    public AgendamentoPermcathDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Agendamentopermcath perm){
        em.getTransaction().begin();
        em.persist(perm);
        em.getTransaction().commit();
    }
    public void alterar(Agendamentopermcath perm){
        em.getTransaction().begin();
        em.merge(perm);
        em.getTransaction().commit();
    }
    public void excluir(Agendamentopermcath perm){
        em.getTransaction().begin();
        em.remove(perm);
        em.getTransaction().commit();
    }
    public List getList(String perm){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT a from Agendamentopermcath a where a.nome LIKE :likes");
       query.setParameter("likes", "%" + perm.trim() + "%");
       List<Agendamentopermcath> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    public List getListdata(String perm, int mes, int ano){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT a from Agendamentopermcath a where month(a.dataencaminhamento) = :mes and year(a.dataencaminhamento) = :ano and a.nome LIKE :perm");
       query.setParameter("mes", mes);
       query.setParameter("ano", ano);
       query.setParameter("perm", "%" + perm.trim() + "%");
       List<Agendamentopermcath> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
     public List getListdataHosp(String hosp, int mes, int ano){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT a from Agendamentopermcath a where month(a.dataencaminhamento) = :mes and year(a.dataencaminhamento) = :ano and a.hospital LIKE :hosp");
       query.setParameter("mes", mes);
       query.setParameter("ano", ano);
       query.setParameter("hosp", "%" + hosp.trim() + "%");
       List<Agendamentopermcath> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
     
      public List getListdataNumPerm(String perm, int mes, int ano){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT a from Agendamentopermcath a where month(a.dataencaminhamento) = :mes and year(a.dataencaminhamento) = :ano and a.numperm LIKE :perm");
       query.setParameter("mes", mes);
       query.setParameter("ano", ano);
       query.setParameter("perm", "%" + perm.trim() + "%");
       List<Agendamentopermcath> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
