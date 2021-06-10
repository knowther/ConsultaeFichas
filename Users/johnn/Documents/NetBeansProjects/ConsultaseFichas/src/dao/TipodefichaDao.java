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
import model.Tipodeficha;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class TipodefichaDao {
    private EntityManager em;
public void TipodefichaDao(){
    em = Singleton.getConnection();
}
    public List getList(){
       em.getTransaction().begin();
       Query query = em.createQuery("SELECT t FROM Tipodeficha t");
     //  query.setParameter("likes", "%" + pac.trim() + "%");
       List<Tipodeficha> lista = query.getResultList();
       em.getTransaction().commit();
       return lista;
     
    }
}
