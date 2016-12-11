package projeto.interfaces.Configuracoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import projeto.classes.*;

public class tabelaDepartamento extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public tabelaDepartamento() throws ClassNotFoundException {
        initComponents();
        this.setLocation(30,40);
        conexao = ConexaoBD.conectadbd();
        listar();
        buscarTF.requestFocus();
    }

    public void cadastrar() {

        try {
            String sql = "Insert into departamento (nome)  values (?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, buscarTF.getText());
            
            if (!buscarTF.getText().equals("")) {
                pst.execute();
                JOptionPane.showMessageDialog(this, "Adicionado!", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampo();
                listar();
                
            } else {
                JOptionPane.showMessageDialog(this, "O campo é obrigátorio", "ERRO!", JOptionPane.ERROR_MESSAGE);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(tabelaDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparCampo() {
        codigoTF.setText("");
        buscarTF.setText("");
    }
    
public void deletar() {

        String sql = "Delete from departamento where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigoTF.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(this, "Excluido!");
            listar();
            limparCampo();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar cadastro.\nTente novamente.", "ERRO!!", JOptionPane.ERROR_MESSAGE);
        }
    }
  public void pesquisar() {

        String sql = "Select *from departamento where nome like ? order by codigo Asc";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, buscarTF.getText() + "%");
            rs = pst.executeQuery();
            TabelaDepartamento.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void mostraInformacoes() {

        int seleciona = TabelaDepartamento.getSelectedRow();

        codigoTF.setText(TabelaDepartamento.getModel().getValueAt(seleciona, 0).toString());
        buscarTF.setText(TabelaDepartamento.getModel().getValueAt(seleciona, 1).toString());
    }
    
     public void listar() {

        String sql = "Select *from departamento order by codigo Asc";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            TabelaDepartamento.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaDepartamento = new javax.swing.JTable();
        jlLogo = new javax.swing.JLabel();
        buscarTF = new javax.swing.JTextField();
        jbAdicionar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        codigoTF = new javax.swing.JTextField();
        jlCodigo = new javax.swing.JLabel();

        setTitle("Tabela Departamento");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/table_edit.png"))); // NOI18N

        TabelaDepartamento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TabelaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ));
        TabelaDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaDepartamento);

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/departamento.png"))); // NOI18N

        buscarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        buscarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        buscarTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTFKeyReleased(evt);
            }
        });

        jbAdicionar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/accept.png"))); // NOI18N
        jbAdicionar.setText("ADICIONAR");
        jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/delete.png"))); // NOI18N
        jbExcluir.setText("EXCLUIR");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbFechar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cancel.png"))); // NOI18N
        jbFechar.setText("FECHAR");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        codigoTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        codigoTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        codigoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codigoTF.setEnabled(false);

        jlCodigo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlCodigo.setText("Código:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlLogo)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jlCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbAdicionar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbFechar))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAdicionar, jbFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlLogo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jbAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbFechar)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbAdicionar, jbExcluir, jbFechar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed
        cadastrar();
    }//GEN-LAST:event_jbAdicionarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover o item?", "Remover item", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == 0) {
            deletar();
        } 
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void buscarTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTFKeyReleased
       pesquisar();
    }//GEN-LAST:event_buscarTFKeyReleased

    private void TabelaDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaDepartamentoMouseClicked
       mostraInformacoes();
    }//GEN-LAST:event_TabelaDepartamentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaDepartamento;
    private javax.swing.JTextField buscarTF;
    private javax.swing.JTextField codigoTF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdicionar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlLogo;
    // End of variables declaration//GEN-END:variables
}
