/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Implantecateter;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class AgendamentoCateterDao {
    private EntityManager em;
    
    
    public AgendamentoCateterDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Implantecateter cat){
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }
    public void alterar(Implantecateter cat){
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }
    public void excluir(Implantecateter cat){
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }
    public List getList(String perm){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT i from Implantecateter i where a.nome LIKE :likes");
       query.setParameter("likes", "%" + perm.trim() + "%");
       List<Implantecateter> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    public List getListdata(String cat, int mes, int ano){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT i from Implantecateter i where month(i.dataDoImplante) = :mes and year(i.dataDoImplante) = :ano and i.nomepaciente LIKE :cat");
       query.setParameter("mes", mes);
       query.setParameter("ano", ano);
       query.setParameter("cat", "%" + cat.trim() + "%");
       List<Implantecateter> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
     public List getListdataHosp(String hosp, int mes, int ano){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT i from Implantecateter i where month(i.dataDoImplante) = :mes and year(i.dataDoImplante) = :ano and i.blocoCirurgicoId.nomeBlococirurgico LIKE :hosp");
       query.setParameter("mes", mes);
       query.setParameter("ano", ano);
       query.setParameter("hosp", "%" + hosp.trim() + "%");
       List<Implantecateter> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
     
      public List getListdataMed(String Med, int mes, int ano){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT i from Implantecateter i where month(i.dataDoImplante) = :mes and year(i.dataDoImplante) = :ano and i.medicosIdmedicos.nome LIKE :Med");
       query.setParameter("mes", mes);
       query.setParameter("ano", ano);
       query.setParameter("Med", "%" + Med.trim() + "%");
       List<Implantecateter> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
