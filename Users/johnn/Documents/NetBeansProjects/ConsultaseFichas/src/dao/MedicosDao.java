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
import model.Medicos;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class MedicosDao {
    private EntityManager em;
    
    
    public MedicosDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Medicos med){
        em.getTransaction().begin();
        em.persist(med);
        em.getTransaction().commit();
    }
    public void alterar(Medicos med){
        em.getTransaction().begin();
        em.merge(med);
        em.getTransaction().commit();
    }
    public void excluir(Medicos med){
        em.getTransaction().begin();
        em.remove(med);
        em.getTransaction().commit();
    }
    public List getList(String med){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT m from Medicos m where m.nome LIKE :likes ");
       query.setParameter("likes", "%" + med.trim() + "%");
       List<Medicos> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
//    public List getListFilter(String cat){
//       em.getTransaction().begin();
//       Query query = em.createQuery("SELECT c from Categoria c where c.tipo =:likes ");
//       query.setParameter("likes", cat);
//       List<Categoria> lista = query.getResultList();
//       em.getTransaction().commit();
//       return lista;
//     
//    }
    
}
