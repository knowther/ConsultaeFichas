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
import model.Movimentacaodraedna;
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
    public void inserir(Movimentacaoconsultorio movcon){
        em.getTransaction().begin();
        em.persist(movcon);
        em.getTransaction().commit();
    }
    public void alterar(Movimentacaoconsultorio movcon){
        em.getTransaction().begin();
        em.merge(movcon);
        em.getTransaction().commit();
    }
    public void excluir(Movimentacaoconsultorio movcon){
        em.getTransaction().begin();
        em.remove(movcon);
        em.getTransaction().commit();
    }
    public List getList(String mov){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT m from Movimentacaoconsultorio m where m.obs LIKE :likes ");
       query.setParameter("likes", "%" + mov.trim() + "%");
       List<Movimentacaoconsultorio> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
     public List getListData(String mov, int mes, int ano){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT m from Movimentacaoconsultorio m where month(m.data) = :mes and year(m.data) =:ano order by m.data");
       query.setParameter("mes", mes);
       query.setParameter("ano", ano);
       List<Movimentacaoconsultorio> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
