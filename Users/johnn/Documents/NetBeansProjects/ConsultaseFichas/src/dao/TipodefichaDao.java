/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Tipodeficha;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class TipodefichaDao {
    
    
    private EntityManager em;
    
    
    public TipodefichaDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Tipodeficha tipo){
        em.getTransaction().begin();
        em.persist(tipo);
        em.getTransaction().commit();
    }
    public void alterar(Tipodeficha tipo){
        em.getTransaction().begin();
        em.merge(tipo);
        em.getTransaction().commit();
    }
    public void excluir(Tipodeficha tipo){
        em.getTransaction().begin();
        em.remove(tipo);
        em.getTransaction().commit();
    }
    public List getList(String tipo){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT t from Tipodeficha t where t.tipodaficha LIKE :likes ");
       query.setParameter("likes", "%" + tipo.trim() + "%");
       List<Tipodeficha> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    
}
