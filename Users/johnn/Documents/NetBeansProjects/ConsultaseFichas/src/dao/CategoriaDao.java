/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Categoria;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class CategoriaDao {
    private EntityManager em;
    
    
    public CategoriaDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Categoria cat){
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }
    public void alterar(Categoria cat){
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }
    public void excluir(Categoria cat){
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }
    public List getList(String cat){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT c from Categoria c where c.descricao LIKE :likes ");
       query.setParameter("likes", "%" + cat.trim() + "%");
       List<Categoria> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    public List getListFilter(String cat){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT c from Categoria c where c.tipo =:likes ");
       query.setParameter("likes", cat);
       List<Categoria> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
