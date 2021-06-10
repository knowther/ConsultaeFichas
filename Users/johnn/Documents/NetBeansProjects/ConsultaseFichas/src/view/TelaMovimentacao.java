/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.MovimentacaoConsultorioDao;
import dao.MovimentacaoDraednaDao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Movimentacaoconsultorio;
import model.Movimentacaodraedna;
import utils.Msg;
import utils.Utils;

/**
 *
 * @author johnn
 */
public class TelaMovimentacao extends javax.swing.JDialog {

    private Movimentacaoconsultorio categoria;
    private Movimentacaodraedna categoriaed;
    private List<Movimentacaoconsultorio> lista = new ArrayList<>();
    private List<Movimentacaodraedna> listaed = new ArrayList<>();

    /**
     * Creates new form TelaMovimentacao
     */
    public TelaMovimentacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaTable();
        pegardatar();
        mudarCorLinha();
        atualizaValores();
        tabela.setShowGrid(true);
        tabela.setAutoCreateRowSorter(true);
        tabela.setGridColor(Color.lightGray);
        jDateChooserInicial.getJCalendar().setPreferredSize(new Dimension(300, 200));
        jDateChooserFinal.getJCalendar().setPreferredSize(new Dimension(300, 200));
        //categoria = new Movimentacaoconsultorio();
        categoria = new Movimentacaoconsultorio();
        categoriaed = new Movimentacaodraedna();

    }

    protected void atualizaValores() {
        double despesa = 0;
        double renda = 0;
        try {
            if (jComboBoxControleCaixa.getSelectedIndex() == 0) {
                if(jCheckBox2.isSelected()){
                    lista = new MovimentacaoConsultorioDao().getListData(txtPesquisa.getText(), jDateChooserInicial.getDate(), jDateChooserFinal.getDate());
                    for (Movimentacaoconsultorio c : lista) {
                    if (c.getCategoriaIdcategoria().getTipo().equals("Pagar")) {
                        despesa += c.getValor();
                    } else {
                        renda += c.getValor();
                    }
                }
                }else{
                   lista = new MovimentacaoConsultorioDao().getList(txtPesquisa.getText());
                for (Movimentacaoconsultorio c : lista) {
                    if (c.getCategoriaIdcategoria().getTipo().equals("Pagar")) {
                        despesa += c.getValor();
                    } else {
                        renda += c.getValor();
                    }
                } 
                }
                
            } else {
                if (jCheckBox2.isSelected()) {
                    listaed = new MovimentacaoDraednaDao().getListData(txtPesquisa.getText(), jDateChooserInicial.getDate(), jDateChooserFinal.getDate());
                    for (Movimentacaodraedna c : listaed) {
                        if (c.getCategoriaIdcategoria().getTipo().equals("Pagar")) {
                            despesa += c.getValor();
                        } else {
                            renda += c.getValor();
                        }
                    }
                } else {
                    listaed = new MovimentacaoDraednaDao().getList(txtPesquisa.getText());
                    for (Movimentacaodraedna c : listaed) {
                        if (c.getCategoriaIdcategoria().getTipo().equals("Pagar")) {
                            despesa += c.getValor();
                        } else {
                            renda += c.getValor();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.ERRO(this, "Erro ao obter saldo do caixa.");
        }
        jTextFieldDespesa.setText(Utils.convertDouble(despesa));
        jTextFieldRenda.setText(Utils.convertDouble(renda));
        jTextFieldSaldo.setText(Utils.convertDouble(renda - despesa));
    }

    protected void atualizaTable() {
//        double despesa = 0;
//            double renda = 0;
        try {
            if (jComboBoxControleCaixa.getSelectedIndex() == 0) {
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                model.setNumRows(0);

                lista = new MovimentacaoConsultorioDao().getListData(txtPesquisa.getText(), jDateChooserInicial.getDate(), jDateChooserFinal.getDate());

                for (Movimentacaoconsultorio c : lista) {
//                if(c.getCategoriaIdcategoria().getTipo().equals("Pagar")){
//                    despesa += c.getValor();
//                }else{
//                    renda += c.getValor();
//                }
                    model.addRow(new Object[]{
                        c.getIdmovimentacao(), c.getCategoriaIdcategoria().getDescricao(), c.getCategoriaIdcategoria().getTipo(), c.getValor(), Utils.convertData(c.getData())
                    }
                    );

                }
            } else if (jComboBoxControleCaixa.getSelectedIndex() == 1) {
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();

                model.setNumRows(0);

                listaed = new MovimentacaoDraednaDao().getListData(txtPesquisa.getText(), jDateChooserInicial.getDate(), jDateChooserFinal.getDate());

                for (Movimentacaodraedna d : listaed) {
//                if(d.getCategoriaIdcategoria().getTipo().equals("Pagar")){
//                    despesa += d.getValor();
//                }else{
//                    renda += d.getValor();
//                }
                    model.addRow(new Object[]{
                        d.getIdmovimentacao(), d.getCategoriaIdcategoria().getDescricao(), d.getCategoriaIdcategoria().getTipo(), d.getValor(), Utils.convertData(d.getData())
                    }
                    );

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            Msg.ERRO(this, "Erro ao Atualizar a Tabela\nErro: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonInserir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jTextFieldSaldo = new javax.swing.JTextField();
        jTextFieldRenda = new javax.swing.JTextField();
        jTextFieldDespesa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserInicial = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserFinal = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBoxControleCaixa = new javax.swing.JComboBox<>();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação");
        setIconImage(null);
        setIconImages(null);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo", "Valor", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(40);
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(15);
            tabela.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/money_add.png"))); // NOI18N
        jButtonInserir.setText("Inserir Entrada de Valor");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInserir);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/money_delete.png"))); // NOI18N
        jButton1.setText("Inserir Despesa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/page_edit.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAlterar);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/door_in.png"))); // NOI18N
        jButton4.setText("Sair");
        jPanel1.add(jButton4);

        jLabel1.setText("Pesquisar:");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTextFieldSaldo.setEditable(false);
        jTextFieldSaldo.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldSaldo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextFieldSaldo.setForeground(new java.awt.Color(51, 153, 0));
        jTextFieldSaldo.setText("0,00");

        jTextFieldRenda.setEditable(false);
        jTextFieldRenda.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldRenda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextFieldRenda.setForeground(new java.awt.Color(51, 153, 0));
        jTextFieldRenda.setText("0,00");

        jTextFieldDespesa.setEditable(false);
        jTextFieldDespesa.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldDespesa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextFieldDespesa.setForeground(new java.awt.Color(255, 51, 51));
        jTextFieldDespesa.setText("0,00");

        jLabel2.setText("Despesa:");

        jLabel3.setText("Renda:");

        jLabel4.setText("Saldo:");

        jLabel5.setText("Data Inicial:");

        jLabel6.setText("Data Final:");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton2.setText("Cadastrar categoria de transação");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton5.setText("Gerar relatório de transações");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jComboBoxControleCaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caixa Consultório", "Caixa Dra. Edna" }));
        jComboBoxControleCaixa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxControleCaixaItemStateChanged(evt);
            }
        });
        jToolBar1.add(jComboBoxControleCaixa);

        jCheckBox2.setText("Filtrar valores pela data selecionada?");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldRenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(jDateChooserInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed

        TelaMovimentacaoCadastro t = new TelaMovimentacaoCadastro(this, true);
        if (jComboBoxControleCaixa.getSelectedIndex() == 0) {
            t.setCaixaconsulta(true);
        } else {
            t.setCaixaconsulta(false);
        }
        t.setInserir(true);
        System.out.println(t.isCaixaconsulta());
        //System.out.println(t.isInserir());
        t.setDespesa(false);
        t.setVisible(true);


    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        TelaMovimentacaoCadastro t = new TelaMovimentacaoCadastro(this, true);

        if (tabela.getSelectedRow() >= 0) {
            if (jComboBoxControleCaixa.getSelectedIndex() == 0) {
                t.setInserir(false);
                t.setCaixaconsulta(true);
                if (lista.get(tabela.getSelectedRow()).getCategoriaIdcategoria().getTipo().equals("Pagar")) {
                    t.preencherCampos(lista.get(tabela.getSelectedRow()));
                    t.setDespesa(true);
                    t.atualizaCombo();
                } else {
                    t.preencherCampos(lista.get(tabela.getSelectedRow()));
                    t.setDespesa(true);
                    t.atualizaCombo();
                }
            } else {
                t.setInserir(true);
                t.setCaixaconsulta(false);
                if (listaed.get(tabela.getSelectedRow()).getCategoriaIdcategoria().getTipo().equals("Pagar")) {
                    t.preencherCamposed(listaed.get(tabela.getSelectedRow()));
                    t.setDespesa(true);
                    t.atualizaCombo();
                } else {
                    t.preencherCamposed(listaed.get(tabela.getSelectedRow()));
                    t.setDespesa(false);
                    t.atualizaCombo();
                }
            }
            t.setVisible(true);
        } else {
            Msg.alert(t, "Selecione um registro.");
        }


    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        atualizaTable();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tabela.getSelectedRow() > -1) {
            if (Msg.confirmacao(this, "Deseja Realmente Excluir Este Registro?")) {
                if (jComboBoxControleCaixa.getSelectedIndex() == 0) {
                    new MovimentacaoConsultorioDao().excluir(lista.get(tabela.getSelectedRow()));

                    Msg.informacao(this, "Registro Excluído com Sucesso");
                    atualizaTable();
                } else {
                    new MovimentacaoDraednaDao().excluir(listaed.get(tabela.getSelectedRow()));

                    Msg.informacao(this, "Registro Excluído Dra edna com Sucesso");
                    atualizaTable();
                }
            }
        } else {
            Msg.alert(this, "Selecione um Registo.");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaMovimentacaoCadastro t = new TelaMovimentacaoCadastro(this, true);
        t.setInserir(false);
        t.setDespesa(true);
        if (jComboBoxControleCaixa.getSelectedIndex() == 0) {
            t.setCaixaconsulta(true);
        } else {
            t.setCaixaconsulta(false);
        }
        t.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TelaCategoria(null, true).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxControleCaixaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxControleCaixaItemStateChanged
        atualizaTable();
        atualizaValores();
        TelaMovimentacaoCadastro t = new TelaMovimentacaoCadastro(this, true);
        if (jComboBoxControleCaixa.getSelectedIndex() == 0) {
            t.setCaixaconsulta(true);
//           
        } else {
            t.setCaixaconsulta(false);
        }
    }//GEN-LAST:event_jComboBoxControleCaixaItemStateChanged

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        atualizaValores();   
        atualizaTable();// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    public void pegardatar() {
        Date date = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        date = cal.getTime();
//        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
//        date = cal.getTime();
        jDateChooserInicial.setDate(date);
//        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        date = cal.getTime();
        jDateChooserFinal.setDate(date);
        atualizaTable();
//        int cal.getActualMaximum(Calendar.);

    }

    private void mudarCorLinha() {
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
//            @Override
//            public Component getTableCellRendererComponent(Jtable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
//              super.getTableCellRendererComponent(jTable1, value, isSelected, hasFocus, row, column);
//              
//              if(jTable1)
//            })
//        });
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (table.getValueAt(row, 2).equals("Pagar")) {
                    setForeground(Color.red);
                } else {
                    setForeground(Color.BLUE);
                }
                return this;
            }
        });
    }

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
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaMovimentacao dialog = new TelaMovimentacao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBoxControleCaixa;
    private com.toedter.calendar.JDateChooser jDateChooserFinal;
    private com.toedter.calendar.JDateChooser jDateChooserInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldDespesa;
    private javax.swing.JTextField jTextFieldRenda;
    private javax.swing.JTextField jTextFieldSaldo;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
