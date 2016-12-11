package projeto.interfaces.telasPrincipais;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projeto.interfaces.Configuracoes.Sobre;
import projeto.interfaces.Configuracoes.tabelaBairro;
import projeto.interfaces.Configuracoes.tabelaCidade;
import projeto.interfaces.Configuracoes.tabelaDepartamento;

public class Configuracoes extends javax.swing.JInternalFrame {

    public Configuracoes() {
        initComponents();
        this.setLocation(100,50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jbSobre = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbTabelaDepartamento = new javax.swing.JButton();
        jbTabelaBairro = new javax.swing.JButton();
        jbTabelaCidades = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Configurações");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cog.png"))); // NOI18N

        jDesktopPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jDesktopPane1.setEnabled(false);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jbSobre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/icone_iVagasNet.png"))); // NOI18N
        jbSobre.setText("SOBRE");
        jbSobre.setToolTipText("Sobre o iVagasNet");
        jbSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSobre.setDisabledIcon(null);
        jbSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSobreActionPerformed(evt);
            }
        });

        jbFechar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cancel.png"))); // NOI18N
        jbFechar.setText("FECHAR");
        jbFechar.setToolTipText("Fechar janela");
        jbFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbFechar.setDisabledIcon(null);
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TABELAS", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jbTabelaDepartamento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbTabelaDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/table.png"))); // NOI18N
        jbTabelaDepartamento.setText("DEPARTAMENTOS");
        jbTabelaDepartamento.setToolTipText("Visualizar a tabela \"Departamento\"");
        jbTabelaDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbTabelaDepartamento.setDisabledIcon(null);
        jbTabelaDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTabelaDepartamentoActionPerformed(evt);
            }
        });

        jbTabelaBairro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbTabelaBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/table.png"))); // NOI18N
        jbTabelaBairro.setText("BAIRROS");
        jbTabelaBairro.setToolTipText("Visualizar a tabela \"Bairro\"");
        jbTabelaBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbTabelaBairro.setDisabledIcon(null);
        jbTabelaBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTabelaBairroActionPerformed(evt);
            }
        });

        jbTabelaCidades.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbTabelaCidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/table.png"))); // NOI18N
        jbTabelaCidades.setText("CIDADES");
        jbTabelaCidades.setToolTipText("Visualizar a tabela \"Cidades\"");
        jbTabelaCidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbTabelaCidades.setDisabledIcon(null);
        jbTabelaCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTabelaCidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbTabelaDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTabelaBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTabelaCidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jbTabelaDepartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbTabelaBairro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbTabelaCidades))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSobre, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jbSobre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFechar)
                .addGap(140, 140, 140))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbTabelaBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTabelaBairroActionPerformed
        try {
            tabelaBairro tabelabairro = new tabelaBairro();
            jDesktopPane1.add(tabelabairro);
            tabelabairro.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbTabelaBairroActionPerformed

    private void jbSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSobreActionPerformed
        Sobre sobre = new Sobre();
        jDesktopPane1.add(sobre);
        sobre.setVisible(true);
    }//GEN-LAST:event_jbSobreActionPerformed

    private void jbTabelaCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTabelaCidadesActionPerformed
        try {
            tabelaCidade tabelacidade = new tabelaCidade();
            jDesktopPane1.add(tabelacidade);
            tabelacidade.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbTabelaCidadesActionPerformed

    private void jbTabelaDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTabelaDepartamentoActionPerformed
        try {
            tabelaDepartamento tabeladepartamento = new tabelaDepartamento();
            jDesktopPane1.add(tabeladepartamento);
            tabeladepartamento.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbTabelaDepartamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbSobre;
    private javax.swing.JButton jbTabelaBairro;
    private javax.swing.JButton jbTabelaCidades;
    private javax.swing.JButton jbTabelaDepartamento;
    // End of variables declaration//GEN-END:variables
}
