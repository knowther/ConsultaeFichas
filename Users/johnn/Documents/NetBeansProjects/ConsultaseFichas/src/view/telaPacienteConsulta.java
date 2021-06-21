/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ControleFuncionario;
import dao.PacientesconsultaDao;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.Pacientesconsulta;
import model.User;
import utils.Msg;

/**
 *
 * @author johnn
 */
public class telaPacienteConsulta extends javax.swing.JFrame {

    public int linhaSelecionada;
  //  private int parentUnicpanelvisible = 0;
    private String login;
    private String cargo;
    private int tipoficha;
    //private PacientesconsultaDao pacienteDao;
    PosicaoFormulario form = new PosicaoFormulario();
    private List<Pacientesconsulta> pacientelista = new ArrayList<>();
    private Agenda agenda;

    /**
     * Creates new form telaPacienteConsulta
     */
    public telaPacienteConsulta() {
        setIconImage(getIconImage());
        initComponents();
        jRadioButtonFichaRecente.setSelected(true);
        preencherTable();
        masterTable.setGridColor(Color.lightGray);
        masterTable.setShowGrid(true);
        setExtendedState(MAXIMIZED_BOTH);
        tipoficha = 1;
        preencherTable();
          User a = ControleFuncionario.getFuncionarioLogado();

        if (dao.ControleFuncionario.isFuncionarioLogado()) {
            setUsuario(a);
        } else {
            if (dao.ControleFuncionario.logarFuncionario("letroche", "123")) {
                a = ControleFuncionario.getFuncionarioLogado();
                setUsuario(a);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        parentPanel = new javax.swing.JPanel();
        jPanela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonCaixa = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButtonCaixa1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButtonCaixa3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButtonCaixa2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonFichaRecente = new javax.swing.JRadioButton();
        jRadioButtonFichaAntiga = new javax.swing.JRadioButton();
        jRadioButtonArquivoMorto = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Recepção");

        masterTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Data de Nascimento", "Médico Responsável"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                masterTableFocusGained(evt);
            }
        });
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(masterTable);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user_add.png"))); // NOI18N
        jButton1.setText("Adicionar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/printer.png"))); // NOI18N
        jButton2.setText("Imprimir Ficha");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel14.setText("Pesquisar:");

        jButton6.setText("Pesquisar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/clock_add.png"))); // NOI18N
        jButton7.setText("Agendar Consulta");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(60, 63, 64));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(60, 63, 64));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonCaixa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonCaixa.setForeground(new java.awt.Color(187, 187, 186));
        jButtonCaixa.setText("Caixa");
        jButtonCaixa.setFocusable(false);
        jButtonCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCaixa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaixaActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCaixa);

        jLabel24.setText("  ");
        jToolBar1.add(jLabel24);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(187, 187, 186));
        jLabel15.setText("l");
        jToolBar1.add(jLabel15);

        jLabel23.setText("  ");
        jToolBar1.add(jLabel23);

        jButtonCaixa1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonCaixa1.setForeground(new java.awt.Color(187, 187, 186));
        jButtonCaixa1.setText("Agendamento");
        jButtonCaixa1.setFocusable(false);
        jButtonCaixa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCaixa1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCaixa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaixa1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCaixa1);

        jLabel25.setText("  ");
        jToolBar1.add(jLabel25);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(187, 187, 186));
        jLabel17.setText("l");
        jToolBar1.add(jLabel17);

        jLabel26.setText("  ");
        jToolBar1.add(jLabel26);

        jButtonCaixa3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonCaixa3.setForeground(new java.awt.Color(187, 187, 186));
        jButtonCaixa3.setText("Relatórios");
        jButtonCaixa3.setFocusable(false);
        jButtonCaixa3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCaixa3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCaixa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaixa3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCaixa3);

        jLabel27.setText("  ");
        jToolBar1.add(jLabel27);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(187, 187, 186));
        jLabel22.setText("l");
        jToolBar1.add(jLabel22);

        jLabel28.setText("  ");
        jToolBar1.add(jLabel28);

        jButtonCaixa2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonCaixa2.setForeground(new java.awt.Color(187, 187, 186));
        jButtonCaixa2.setText("Configurações");
        jButtonCaixa2.setFocusable(false);
        jButtonCaixa2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCaixa2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCaixa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaixa2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCaixa2);

        jPanel4.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pranchetafinal.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, -22, -1, 200));

        buttonGroup1.add(jRadioButtonFichaRecente);
        jRadioButtonFichaRecente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButtonFichaRecente.setText("Fichas recentes");
        jRadioButtonFichaRecente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFichaRecenteActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonFichaAntiga);
        jRadioButtonFichaAntiga.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButtonFichaAntiga.setText("Fichas antigas");
        jRadioButtonFichaAntiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFichaAntigaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonArquivoMorto);
        jRadioButtonArquivoMorto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButtonArquivoMorto.setText("Arquivo morto");
        jRadioButtonArquivoMorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonArquivoMortoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jRadioButtonFichaRecente)
                .addGap(5, 5, 5)
                .addComponent(jRadioButtonFichaAntiga)
                .addGap(5, 5, 5)
                .addComponent(jRadioButtonArquivoMorto))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonFichaRecente)
                    .addComponent(jRadioButtonFichaAntiga)
                    .addComponent(jRadioButtonArquivoMorto)))
        );

        javax.swing.GroupLayout jPanelaLayout = new javax.swing.GroupLayout(jPanela);
        jPanela.setLayout(jPanelaLayout);
        jPanelaLayout.setHorizontalGroup(
            jPanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelaLayout.createSequentialGroup()
                .addGroup(jPanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanelaLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelaLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addGroup(jPanelaLayout.createSequentialGroup()
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)))
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelaLayout.setVerticalGroup(
            jPanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(2, 2, 2)
                .addGroup(jPanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(21, 21, 21)
                .addGroup(jPanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton7))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout parentPanelLayout = new javax.swing.GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        parentPanelLayout.setVerticalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(parentPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        setSize(new java.awt.Dimension(1382, 743));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setUsuario(User a) {
        if (dao.ControleFuncionario.isFuncionarioLogado()) {
            this.login = a.getUsuario();
            switch (a.getCargo()) {
                case "Admin":
                    this.cargo = "Admin";
                    
                    break;
                case "Func":
                    this.cargo = "Funcionário(a)";
                    jButtonCaixa.setEnabled(false);
                    break;
                default:
                    this.cargo = "Desconhecido";
                   
            }
        }
    }

    
    public void preencherTable(){
        DefaultTableModel model = (DefaultTableModel) masterTable.getModel();
        model.setNumRows(0);
        
        pacientelista = new PacientesconsultaDao().getListficha(tipoficha);
        for(Pacientesconsulta p : pacientelista){
            model.addRow(new Object[]{
                p.getNome(), p.getIdade(), utils.Utils.convertData(p.getDataNasc()) , p.getMedicosIdmedicos().getNome()
            });
        }
    }
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       TelaCadastroPaciente  t  = new TelaCadastroPaciente(this, true);
       t.setInserir(true);
       
       t.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        try{
            
        
        int ls = masterTable.getSelectedRow();
        linhaSelecionada = ls;
        if (evt.getClickCount() == 2) {
            TelaCadastroPaciente t = new TelaCadastroPaciente(this, true);
            t.setInserir(false);
            t.preenchercampos(pacientelista.get(ls));
            t.setVisible(true);
        }
        }catch(Exception e){
            Msg.ERRO(this, "Erro ao adquirir dados do paciente\n Erro: " + e);
        }
    }//GEN-LAST:event_masterTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   
        try{
             TelaFichaAmb tela;
        form.abrirFormulario(tela = new TelaFichaAmb(), jDesktopPane1); 
       
        

        }catch(Exception e){
            Msg.ERRO(this, "Erro ao abrir tela.\n Erro: " + e);
        
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButtonFichaRecenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFichaRecenteActionPerformed
        tipoficha = 1;
        preencherTable();
    
    }//GEN-LAST:event_jRadioButtonFichaRecenteActionPerformed

    private void jRadioButtonArquivoMortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonArquivoMortoActionPerformed
        tipoficha = 3; 
        preencherTable();
        
    }//GEN-LAST:event_jRadioButtonArquivoMortoActionPerformed

    private void jRadioButtonFichaAntigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFichaAntigaActionPerformed
        tipoficha = 2;
        preencherTable();
    }//GEN-LAST:event_jRadioButtonFichaAntigaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      
    }//GEN-LAST:event_jButton6ActionPerformed

    
    public final Image getIconImage(){
      Image ICONE = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagens/prancheta.png"));
      return ICONE;
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
               // new Agenda().setVisible(true);  
              // ModalJframe.showModalJFrame(new Agenda(),this);
              agenda = new Agenda();
              final JDialog frame = new JDialog(this, "Agenda", true);
                frame.getContentPane().add(agenda.getComponent(0));
                frame.pack();
                frame.setLocationRelativeTo(this);
                frame.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaixaActionPerformed
        new TelaMovimentacao(this, true).setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCaixaActionPerformed

    private void masterTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_masterTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_masterTableFocusGained

    private void jButtonCaixa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaixa1ActionPerformed
        new TelaAgendamento(this, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCaixa1ActionPerformed

    private void jButtonCaixa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaixa2ActionPerformed
        Msg.informacao(this, "Este menu está em construção");// TODO add your handling code here:
    }//GEN-LAST:event_jButtonCaixa2ActionPerformed

    private void jButtonCaixa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaixa3ActionPerformed
        Msg.informacao(this, "Este menu está em construção");   // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCaixa3ActionPerformed

    /**
     * @param args the command line arguments
     */
    //Calcula a Idade baseado em java.util.Date
    public static int calculaIdade(java.util.Date dataNasc) {

        Calendar dateOfBirth = new GregorianCalendar();

        dateOfBirth.setTime(dataNasc);

// Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

// Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, age);

//se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (today.before(dateOfBirth)) {

            age--;

        }

        return age;

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaPacienteConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(telaPacienteConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(telaPacienteConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(telaPacienteConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPacienteConsulta().setVisible(true);
            }
        });
    }

    private void disables() {
       
    }

    public void attentity() {
       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonCaixa;
    private javax.swing.JButton jButtonCaixa1;
    private javax.swing.JButton jButtonCaixa2;
    private javax.swing.JButton jButtonCaixa3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanela;
    private javax.swing.JRadioButton jRadioButtonArquivoMorto;
    private javax.swing.JRadioButton jRadioButtonFichaAntiga;
    private javax.swing.JRadioButton jRadioButtonFichaRecente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable masterTable;
    private javax.swing.JPanel parentPanel;
    // End of variables declaration//GEN-END:variables
}
