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
    public List getListaCon(Date datacon, Date horacon, Date horacon1){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT c from Consulta c where c.datasconsulta = :datacon and c.hora BETWEEN :horacon and :horacon1");
       query.setParameter("datacon", datacon);
       query.setParameter("horacon", horacon);
       query.setParameter("horacon1", horacon1);
       List<Consulta> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
     public List getListaDay(Date datacon){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT c from Consulta c where c.datasconsulta = :datacon");
       query.setParameter("datacon", datacon);
       List<Consulta> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
}
