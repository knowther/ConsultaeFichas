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
    
    public List getListdata(String perm, Date data01, Date data02){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT a from Agendamentopermcath a where a.dataencaminhamento BEETWEN :data01 and :data02");
       query.setParameter("data01", data01);
       query.setParameter("data02", data02);
       List<Agendamentopermcath> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
