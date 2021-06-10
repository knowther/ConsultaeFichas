/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Consulta;
import model.Pacientesconsulta;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class ConsultaDao {
    private EntityManager em;
    
    
    public ConsultaDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Consulta con){
        em.getTransaction().begin();
        em.persist(con);
        em.getTransaction().commit();
    }
    public void alterar(Consulta con){
        em.getTransaction().begin();
        em.merge(con);
        em.getTransaction().commit();
    }
    public void excluir(Consulta con){
        em.getTransaction().begin();
        em.remove(con);
        em.getTransaction().commit();
    }
    public List getList(String con){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT c from Consulta c where c.nome LIKE :likes");
       query.setParameter("likes", "%" + con.trim() + "%");
       List<Consulta> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
}
