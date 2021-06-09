/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author johnn
 */
public class ControleFuncionario {
    
    private static User usuarioLogado = null;


    public static User getFuncionarioLogado(){
    return usuarioLogado;
}
    public static boolean isAdmin(){
        boolean cargo;
        switch (usuarioLogado.getCargo()){
            case "Adm":
            cargo = true; 
            break;
            default:
            cargo = false;
        }
        return cargo;
    }
    public static boolean isFuncionarioLogado(){
        if(usuarioLogado == null){
            return false;
        }else{
            return true;
        }
    }
    public static void deslogarFuncionario(){
        ControleFuncionario.usuarioLogado = null;
    }
    
    public static boolean logarFuncionario(String usuario, String senha){
        boolean logou = false;
        EntityManager gerente = ControleConexao.getGerente();
        List<User> listaFuncionarios; 
        TypedQuery<User> consultaFuncionario = gerente.createNamedQuery("user.Acessar", User.class);
        
        consultaFuncionario.setParameter("usuario", usuario);
        consultaFuncionario.setParameter("senha", senha);
        
        listaFuncionarios = consultaFuncionario.getResultList();
        
        if (listaFuncionarios.isEmpty()){
            ControleFuncionario.usuarioLogado = null;
        }else{
            ControleFuncionario.usuarioLogado = listaFuncionarios.get(0);
            logou = true;
        }
        return logou;
    }
    
}
