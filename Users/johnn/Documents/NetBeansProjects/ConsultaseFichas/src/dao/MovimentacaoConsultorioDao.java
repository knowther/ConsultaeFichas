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
import model.Movimentacaoconsultorio;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class MovimentacaoConsultorioDao {
    private EntityManager em;
    
    
    public MovimentacaoConsultorioDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Movimentacaoconsultorio mov){
        em.getTransaction().begin();
        em.persist(mov);
        em.getTransaction().commit();
    }
    public void alterar(Movimentacaoconsultorio mov){
        em.getTransaction().begin();
        em.merge(mov);
        em.getTransaction().commit();
    }
    public void excluir(Movimentacaoconsultorio mov){
        em.getTransaction().begin();
        em.remove(mov);
        em.getTransaction().commit();
    }
    public List getList(String mov){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT m from Movimentacao m where m.obs LIKE :likes ");
       query.setParameter("likes", "%" + mov.trim() + "%");
       List<Movimentacaoconsultorio> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
     public List getListData(String mov, Date data01, Date data02){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT m from Movimentacaoconsultorio m where m.data BETWEEN :data01 and :data02 order by m.data ");
       query.setParameter("data01", data01);
       query.setParameter("data02", data02);
       List<Movimentacaoconsultorio> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
