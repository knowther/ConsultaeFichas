/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CategoriaDao;
import dao.MovimentacaoConsultorioDao;
import dao.MovimentacaoDraednaDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Categoria;
import model.Movimentacaoconsultorio;
import model.Movimentacaodraedna;
import utils.Msg;

/**
 *
 * @author johnn
 */
public class TelaMovimentacaoCadastro extends javax.swing.JDialog {

    private boolean inserir;
    public static boolean caixaconsulta;
    private boolean despesa;
    private Movimentacaoconsultorio movimentacaoconsultorio;
    private Movimentacaodraedna movimentacaodraedna;
    private TelaMovimentacao pai;
    private List<Categoria> listaCategoria = new ArrayList<>();

    /**
     * Creates new form TelaMovimentacaoCadastro
     */
    public TelaMovimentacaoCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //movimentacaoconsultorio = new Movimentacaoconsultorio();
        //movimentacaodraedna = new Movimentacaodraedna();

        //atualizaCombo();
    }

    public TelaMovimentacaoCadastro(TelaMovimentacao parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaCombo();
        pai = parent;
        movimentacaoconsultorio = new Movimentacaoconsultorio();
        movimentacaodraedna = new Movimentacaodraedna();
    }

    public void atualizaCombo() {
        try {
            jComboBoxCategoria.removeAllItems();
            jComboBoxCategoria.addItem("<Selecione>");
            if (isDespesa()) {
                listaCategoria = new CategoriaDao().getListFilter("Pagar");

            } else {
                listaCategoria = new CategoriaDao().getListFilter("Receber");

            }

            for (Categoria c : listaCategoria) {
                jComboBoxCategoria.addItem(c.getDescricao());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.ERRO(pai, "Erro ao Atualizar Dados de Categoria");
        }
    }

    protected void preencherCampos(Movimentacaoconsultorio mov) {
        movimentacaoconsultorio = mov;
        jDateChooser1.setDate(movimentacaoconsultorio.getData());
        jTextFieldObs.setText(movimentacaoconsultorio.getObs());
        jFormattedTextFieldValor.setText(movimentacaoconsultorio.getValor() + "");
        jComboBoxCategoria.setSelectedItem(movimentacaoconsultorio.getCategoriaIdcategoria().getDescricao());
        //jComboBoxCategoria.setSelectedIndex(1);
    }

    protected void preencherCamposed(Movimentacaodraedna mov) {
        movimentacaodraedna = mov;
        jDateChooser1.setDate(movimentacaodraedna.getData());
        jTextFieldObs.setText(movimentacaodraedna.getObs());
        jFormattedTextFieldValor.setText(movimentacaodraedna.getValor() + "");
        jComboBoxCategoria.setSelectedItem(movimentacaodraedna.getCategoriaIdcategoria().getDescricao());
        //jComboBoxCategoria.setSelectedIndex(1);
    }

    public Movimentacaoconsultorio getMovimentacao() {
        movimentacaoconsultorio.setData(jDateChooser1.getDate());
        movimentacaoconsultorio.setDataCadastro(new Date());
        movimentacaoconsultorio.setCategoriaIdcategoria(listaCategoria.get(jComboBoxCategoria.getSelectedIndex() - 1));
        movimentacaoconsultorio.setObs(jTextFieldObs.getText());
        if(jComboBoxCategoria.getSelectedIndex() == 1){
        movimentacaoconsultorio.setValor(Double.parseDouble(jFormattedTextFieldValor.getText().replace(",", ".")));}else{
        movimentacaoconsultorio.setValor(Double.parseDouble(jFormattedTextFieldValor.getText().replace(",", "."))* -1);
        }

        return movimentacaoconsultorio;
    }

    public Movimentacaodraedna getMovimentacaoedna() {
        movimentacaodraedna.setData(jDateChooser1.getDate());
        movimentacaodraedna.setDataCadastro(new Date());
        movimentacaodraedna.setCategoriaIdcategoria(listaCategoria.get(jComboBoxCategoria.getSelectedIndex() - 1));
        movimentacaodraedna.setObs(jTextFieldObs.getText());
        movimentacaodraedna.setValor(Double.parseDouble(jFormattedTextFieldValor.getText().replace(",", ".")));

        return movimentacaodraedna;
    }

    private boolean verificaCampos() {
        boolean verificar = false;
        String msg = "Campos obrigatórios! \n";
        if (jTextFieldObs.getText().trim().equals("") || jTextFieldObs.getText().isEmpty() || jDateChooser1.getDate() == null) {
            verificar = true;
            msg += "Descrição ou data";
        }
        if (verificar) {
            Msg.ERRO(this, msg);
        }

        return verificar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldObs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Categoria de Transação");

        jLabel1.setText("Descrição:");

        jLabel2.setText("Categoria:");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagar", "Receber" }));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jLabel3.setText("Valor:");

        jFormattedTextFieldValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldValor.setText("0,00");
        jFormattedTextFieldValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldValorFocusGained(evt);
            }
        });

        jLabel4.setText("Data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldObs)
                                .addComponent(jComboBoxCategoria, 0, 288, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!verificaCampos()) {
            if (isCaixaconsulta()) {
                if (isInserir()) {

                    new MovimentacaoConsultorioDao().inserir(getMovimentacao());
                   // new MovimentacaoConsultorioDao().alterar(getMovimentacao());
                    Msg.informacao(this, "Registro Salvo com Sucesso!");
                    this.pai.atualizaTable();
                    this.pai.atualizaValores();
                    this.dispose();
                    
                } else {
                    new MovimentacaoConsultorioDao().alterar(getMovimentacao());
                    Msg.informacao(this, "Registro Alterado com Sucesso!");
                    this.pai.atualizaTable();
                    this.pai.atualizaValores();
                    this.dispose();
                    

                }
            } else {
                if (isInserir()) {
                    new MovimentacaoDraednaDao().inserir(getMovimentacaoedna());
                    Msg.informacao(this, "Registro Alterado com Sucesso!");
                    this.dispose();
                    this.pai.atualizaTable();
                    this.pai.atualizaValores();
                } else {
                    new MovimentacaoDraednaDao().alterar(getMovimentacaoedna());
                    Msg.informacao(this, "Registro Alterado com Sucesso!");
                    this.dispose();
                    this.pai.atualizaTable();
                    this.pai.atualizaValores();
                }

            }
            
        }else{
            Msg.ERRO(pai, "Está faltando campos.");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextFieldValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorFocusGained
        jFormattedTextFieldValor.selectAll();
    }//GEN-LAST:event_jFormattedTextFieldValorFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaMovimentacaoCadastro dialog = new TelaMovimentacaoCadastro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFormattedTextField jFormattedTextFieldValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldObs;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the inserir
     */
    public boolean isInserir() {
        return inserir;
    }

    /**
     * @param inserir the inserir to set
     */
    public void setInserir(boolean inserir) {
        this.inserir = inserir;
    }

    /**
     * @return the despesa
     */
    public boolean isDespesa() {
        return despesa;
    }

    /**
     * @param despesa the despesa to set
     */
    public void setDespesa(boolean despesa) {

        this.despesa = despesa;
        atualizaCombo();
    }

    /**
     * @return the caixaconsulta
     */
    public boolean isCaixaconsulta() {
        return caixaconsulta;
    }

    /**
     * @param caixaconsulta the caixaconsulta to set
     */
    public void setCaixaconsulta(boolean caixaconsulta) {
        this.caixaconsulta = caixaconsulta;
    }

}
