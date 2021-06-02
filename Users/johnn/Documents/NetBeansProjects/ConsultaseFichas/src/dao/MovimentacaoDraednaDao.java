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
import model.Movimentacaodraedna;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class MovimentacaoDraednaDao {
    private EntityManager em;
    
    
    public MovimentacaoDraednaDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Movimentacaodraedna mov){
        em.getTransaction().begin();
        em.persist(mov);
        em.getTransaction().commit();
    }
    public void alterar(Movimentacaodraedna mov){
        em.getTransaction().begin();
        em.merge(mov);
        em.getTransaction().commit();
    }
    public void excluir(Movimentacaodraedna mov){
        em.getTransaction().begin();
        em.remove(mov);
        em.getTransaction().commit();
    }
    public List getList(String mov){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT m from Movimentacaodraedna m where m.obs LIKE :likes ");
       query.setParameter("likes", "%" + mov.trim() + "%");
       List<Movimentacaodraedna> listaed = query.getResultList();
       em.getTransaction().commit();
       return listaed;
     
    }
    
     public List getListData(String mov, Date data01, Date data02){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT m from Movimentacaodraedna m where m.data BETWEEN :data01 and :data02 order by m.data ");
       query.setParameter("data01", data01);
       query.setParameter("data02", data02);
       List<Movimentacaodraedna> listaed = query.getResultList();
       em.getTransaction().commit();
       return listaed;
     
    }
    
}