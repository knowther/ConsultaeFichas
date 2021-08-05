/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Pacientesconsulta;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class PacientesconsultaDao {
    private EntityManager em;
    
    
    public PacientesconsultaDao(){
        em = Singleton.getConnection();
    }
    public void inserir(Pacientesconsulta pac){
        em.getTransaction().begin();
        em.persist(pac);
        em.getTransaction().commit();
    }
    public void alterar(Pacientesconsulta pac){
        em.getTransaction().begin();
        em.merge(pac);
        em.getTransaction().commit();
    }
    public void excluir(Pacientesconsulta pac){
        em.getTransaction().begin();
        em.remove(pac);
        em.getTransaction().commit();
    }
    public List getList(String pac){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT p from Pacientesconsulta p where p.nome LIKE :likes");
       query.setParameter("likes", "%" + pac.trim() + "%");
       List<Pacientesconsulta> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
    public List getListficha(int tipoficha, String pac){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT p from Pacientesconsulta p where p.tipodefichaIdtipodeficha.idtipodeficha =:tipoficha and p.nome LIKE :likes");
       query.setParameter("tipoficha", tipoficha);
       query.setParameter("likes", "%" + pac.trim() + "%");
       List<Pacientesconsulta> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
    
}
