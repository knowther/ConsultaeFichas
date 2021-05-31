/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import utils.Msg;
import utils.Singleton;

/**
 *
 * @author johnn
 */
public class Inicializar {
    
    private static Progress p;
    
    public static void main(String[] args) {
        
        try {
            
//           com.formdev.flatlaf.FlatLaf
//            com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme
            UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme");
        } catch (Exception e) {
            e.printStackTrace();
            Msg.ERRO(null, "Erro ao aplicar o tema.");
        }
        
        p = new Progress(new JFrame(), "Aguarde, Inicializando o sistema.");
        
        SwingWorker worker = new SwingWorker(){
          @Override
          protected Object doInBackground() throws Exception {
              p.gerarJanela();
              Singleton.setConnection();
              return null;
          }
          @Override
          protected void done(){
              p.fechar();
              new TelaPrincipalCaixa().setVisible(true);
          }
        };
        worker.execute();
    }
}
