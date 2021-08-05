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
import model.BlocoCirurgico;
import model.Regulacao;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class BlococirurgicoDao {
    private EntityManager em;
    
    
    public BlococirurgicoDao(){
        em = Singleton.getConnection();
    }
    public void inserir(BlocoCirurgico bloc){
        em.getTransaction().begin();
        em.persist(bloc);
        em.getTransaction().commit();
    }
    public void alterar(BlocoCirurgico bloc){
        em.getTransaction().begin();
        em.merge(bloc);
        em.getTransaction().commit();
    }
    public void excluir(BlocoCirurgico bloc){
        em.getTransaction().begin();
        em.remove(bloc);
        em.getTransaction().commit();
    }
   
    
    public List getList(){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT b from BlocoCirurgico b");
       List<BlocoCirurgico> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
