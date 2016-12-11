package projeto.interfaces.telasPrincipais;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import projeto.classes.*;
import projeto.interfaces.miniInterfaces.Mensagem;

public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/projeto/interfaces/imagens/icones/icone_iVagasNet.png");
            setIconImage(icon);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 0);
        }
        mensagem();
    }

    public void mensagem() {
        Mensagem msg = new Mensagem();
        jDesktopPane1.add(msg);
        msg.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jbCadastrarCandidato = new javax.swing.JButton();
        jbCadastrarEmpresa = new javax.swing.JButton();
        jbEmpregos = new javax.swing.JButton();
        jbConfiguracoes = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iVagasNet");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktopPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jDesktopPane1.setEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/Menu Principal.gif"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbCadastrarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_candidato.png"))); // NOI18N
        jbCadastrarCandidato.setToolTipText("Cadastrar Candidato");
        jbCadastrarCandidato.setBorder(null);
        jbCadastrarCandidato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCadastrarCandidato.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_candidato.png"))); // NOI18N
        jbCadastrarCandidato.setRequestFocusEnabled(false);
        jbCadastrarCandidato.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_candidato.png"))); // NOI18N
        jbCadastrarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarCandidatoActionPerformed(evt);
            }
        });

        jbCadastrarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_empresa.png"))); // NOI18N
        jbCadastrarEmpresa.setToolTipText("Cadastrar empresa no sistema");
        jbCadastrarEmpresa.setBorder(null);
        jbCadastrarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCadastrarEmpresa.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_empresa.png"))); // NOI18N
        jbCadastrarEmpresa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_empresa.png"))); // NOI18N
        jbCadastrarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarEmpresaActionPerformed(evt);
            }
        });

        jbEmpregos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_preencher_vagas.png"))); // NOI18N
        jbEmpregos.setToolTipText("Preencher vagas para estágio");
        jbEmpregos.setBorder(null);
        jbEmpregos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEmpregos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_preencher_vagas.png"))); // NOI18N
        jbEmpregos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_preencher_vagas.png"))); // NOI18N
        jbEmpregos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmpregosActionPerformed(evt);
            }
        });

        jbConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_configuracoes.png"))); // NOI18N
        jbConfiguracoes.setToolTipText("Abrir janela de configurações");
        jbConfiguracoes.setBorder(null);
        jbConfiguracoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbConfiguracoes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_configuracoes.png"))); // NOI18N
        jbConfiguracoes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_configuracoes.png"))); // NOI18N
        jbConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfiguracoesActionPerformed(evt);
            }
        });

        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_sair.png"))); // NOI18N
        jbSair.setToolTipText("Fechar aplicativo");
        jbSair.setBorder(null);
        jbSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_sair.png"))); // NOI18N
        jbSair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_sair.png"))); // NOI18N
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCadastrarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCadastrarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEmpregos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );

        jDesktopPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrarCandidato, jbCadastrarEmpresa, jbConfiguracoes, jbEmpregos, jbSair});

        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEmpregos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadastrarCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCadastrarEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jDesktopPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbCadastrarCandidato, jbCadastrarEmpresa, jbConfiguracoes, jbEmpregos, jbSair});

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbCadastrarCandidato, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbCadastrarEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbEmpregos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbConfiguracoes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbSair, javax.swing.JLayeredPane.DEFAULT_LAYER);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja encerrar o aplicativo?", "Sair do Aplicativo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == 0) {
            System.exit(0);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jbCadastrarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarCandidatoActionPerformed
        try {
            CadastroCandidato cas = new CadastroCandidato();
            jDesktopPane1.add(cas);
            cas.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCadastrarCandidatoActionPerformed

    private void jbCadastrarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarEmpresaActionPerformed
        try {
            CadastroEmpresa cas = new CadastroEmpresa();
            jDesktopPane1.add(cas);
            cas.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCadastrarEmpresaActionPerformed

    private void jbEmpregosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmpregosActionPerformed
        try {
            ContratacaoDoEstagiario con = new ContratacaoDoEstagiario();
            jDesktopPane1.add(con);
            con.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEmpregosActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja encerrar o aplicativo?", "Sair do Aplicativo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == 0) {
            System.exit(0);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfiguracoesActionPerformed
        Configuracoes con = new Configuracoes();
        jDesktopPane1.add(con);
        con.setVisible(true);
    }//GEN-LAST:event_jbConfiguracoesActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaInicial().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JButton jbCadastrarCandidato;
    private javax.swing.JButton jbCadastrarEmpresa;
    private javax.swing.JButton jbConfiguracoes;
    private javax.swing.JButton jbEmpregos;
    private javax.swing.JButton jbSair;
    // End of variables declaration//GEN-END:variables
}
