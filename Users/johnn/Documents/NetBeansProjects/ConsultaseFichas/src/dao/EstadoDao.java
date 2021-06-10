/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Estado;
import model.Cidade;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class EstadoDao {
    
    
    private EntityManager em;
    
    
    public EstadoDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Estado est){
        em.getTransaction().begin();
        em.persist(est);
        em.getTransaction().commit();
    }
    public void alterar(Estado est){
        em.getTransaction().begin();
        em.merge(est);
        em.getTransaction().commit();
    }
    public void excluir(Estado est){
        em.getTransaction().begin();
        em.remove(est);
        em.getTransaction().commit();
    }
    public List getList(String est){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT e from Estado e where e.nome LIKE :likes ");
       query.setParameter("likes", "%" + est.trim() + "%");
       List<Estado> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    public List getListFilter(Estado e){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT c from Cidade c where c.estadoIdestado =:e order by nome");
       query.setParameter("e", e);
       List<Cidade> listacity = query.getResultList();
       em.getTransaction().commit();
       return listacity;
    }
    
}
