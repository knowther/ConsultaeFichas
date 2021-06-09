/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author johnn
 */
public class ControleConexao {
    private static EntityManagerFactory emf;
    
    //cria um EntityManager
    public static EntityManagerFactory getFabrica(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("ConsultaseFichasPU");
        }
        return emf;
    }
    
    public static EntityManager getGerente(){
        EntityManager em;
        emf = getFabrica();
        em = emf.createEntityManager();
        return em;
    }
    
   public java.sql.Connection getConnection(){
       try{
           return DriverManager.getConnection("jdbc:mysql://localhost/sulteste?zeroDateTimeBehavior=convertToNull", "root", "");
       }catch(SQLException ex){
           System.out.println("Erro ao tentar realizar a conexão com o banco de dados!");
           throw new RuntimeException(ex);
       }
   }
}
