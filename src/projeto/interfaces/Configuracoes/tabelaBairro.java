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

public class tabelaBairro extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public tabelaBairro() throws ClassNotFoundException {
        initComponents();
        this.setLocation(30, 40);
        conexao = ConexaoBD.conectadbd();
        listar();
        buscarTF.requestFocus();
    }

    public void cadastrar() {

        try {
            String sql = "Insert into bairro (nome)  values (?)";
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

        String sql = "Delete from bairro where codigo = ?";

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
            TabelaBairro.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void mostraInformacoes() {

        int seleciona = TabelaBairro.getSelectedRow();

        codigoTF.setText(TabelaBairro.getModel().getValueAt(seleciona, 0).toString());
        buscarTF.setText(TabelaBairro.getModel().getValueAt(seleciona, 1).toString());
    }

    public void listar() {

        String sql = "Select *from bairro order by codigo Asc";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            TabelaBairro.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlLogo = new javax.swing.JLabel();
        codigoTF = new javax.swing.JTextField();
        buscarTF = new javax.swing.JTextField();
        jlCodigo = new javax.swing.JLabel();
        jbAdicionar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaBairro = new javax.swing.JTable();

        setTitle("Tabela Bairro");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/building_edit.png"))); // NOI18N

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/bairro.png"))); // NOI18N
        jlLogo.setToolTipText("");

        codigoTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        codigoTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        codigoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codigoTF.setEnabled(false);

        buscarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        buscarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        buscarTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTFKeyReleased(evt);
            }
        });

        jlCodigo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlCodigo.setText("Código:");

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

        TabelaBairro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TabelaBairro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ));
        TabelaBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaBairroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaBairro);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTFKeyReleased
        pesquisar();
    }//GEN-LAST:event_buscarTFKeyReleased

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed
        cadastrar();
    }//GEN-LAST:event_jbAdicionarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover o item?", "Remover item", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == 0) {
            deletar();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void TabelaBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaBairroMouseClicked
        mostraInformacoes();
    }//GEN-LAST:event_TabelaBairroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaBairro;
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
