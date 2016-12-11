
package projeto.interfaces.internas;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import projeto.classes.ConexaoBD;
import projeto.interfaces.miniInterfaces.AdicionarBairro;
import projeto.interfaces.miniInterfaces.AdicionarCidade;

public class editarEmpresa extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public editarEmpresa() throws ClassNotFoundException {
        initComponents();
        conexao = ConexaoBD.conectadbd();
        this.setLocation(30,25);
        listarEmpresa();
        limparCampos();
    }

    public void deletarEmpresa() {

        String sql = "Delete from empresa where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigoTF.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
            listarEmpresa();
            limparCampos();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar cadastro.\nTente novamente.", "ERRO!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pesquisarEmpresa() {

        String sql = "Select *from empresa where nome like ? order by nome Asc";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeTF.getText() + "%");
            rs = pst.executeQuery();
            TabelaEmpresa.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, "Aluno não cadastrado.\nTente outra vez.", "ERRO!!", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void atualizarEmpresa() {

        String sql = "Update empresa set  nome = ?, cnpj = ?, estado = ?, cidade = ?,  telefone = ?, endereco = ?, bairro = ?, site = ?, "
                + "email = ? where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeTF.getText());
            pst.setString(2, cnpjTF.getText());
            pst.setString(3, (String) estadoCB.getSelectedItem());
            pst.setString(4, (String) cidadeCB.getSelectedItem());
            pst.setString(5, telTF.getText());
            pst.setString(6, enderecoTF.getText());
            pst.setString(7, (String) bairroCB.getSelectedItem());
            pst.setString(8, siteTF.getText());
            pst.setString(9, emailTF.getText());
            pst.setInt(10, Integer.parseInt(codigoTF.getText()));

            if (!nomeTF.getText().equals("")
                    && !cnpjTF.getText().equals("")
                    && !estadoCB.getSelectedItem().equals(-1)
                    && !cidadeCB.getSelectedItem().equals(-1)
                    && !telTF.getText().equals("")
                    && !enderecoTF.getText().equals("")
                    && !bairroCB.getSelectedItem().equals("")
                    && !siteTF.getText().equals("")
                    && !emailTF.getText().equals("")) {

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cadastro atualizado com sucesso", "Atualização concluída", JOptionPane.INFORMATION_MESSAGE);
                listarEmpresa();
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Alguns campos são obrigátorios", "ERRO NO CADASTRO", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }

    public void mostraInformacoes() {

        int seleciona = TabelaEmpresa.getSelectedRow();

        codigoTF.setText(TabelaEmpresa.getModel().getValueAt(seleciona, 0).toString());
        nomeTF.setText(TabelaEmpresa.getModel().getValueAt(seleciona, 1).toString());
        cnpjTF.setText(TabelaEmpresa.getModel().getValueAt(seleciona, 2).toString());
        estadoCB.setSelectedItem(TabelaEmpresa.getModel().getValueAt(seleciona, 3).toString());
        cidadeCB.setSelectedItem(TabelaEmpresa.getModel().getValueAt(seleciona, 4).toString());
        telTF.setText(TabelaEmpresa.getModel().getValueAt(seleciona, 5).toString());
        enderecoTF.setText(TabelaEmpresa.getModel().getValueAt(seleciona, 6).toString());
        bairroCB.setSelectedItem(TabelaEmpresa.getModel().getValueAt(seleciona, 7).toString());
        siteTF.setText(TabelaEmpresa.getModel().getValueAt(seleciona, 8).toString());
        emailTF.setText(TabelaEmpresa.getModel().getValueAt(seleciona, 9).toString());
    }

    public void listarEmpresa() {

        String sql = "Select *from estagiario order by codigo Asc";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            TabelaEmpresa.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }

    public void limparCampos() {

        codigoTF.setText("");
        nomeTF.setText("");
        cnpjTF.setText("");
        telTF.setText("");
        enderecoTF.setText("");
        siteTF.setText("");
        emailTF.setText("");
        estadoCB.setSelectedIndex(-1);
        cidadeCB.setSelectedIndex(-1);
        bairroCB.setSelectedIndex(-1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jpInfoempresa = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        enderecoTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bairroCB = new javax.swing.JComboBox();
        jbAddBairro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        telTF = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        estadoCB = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cidadeCB = new javax.swing.JComboBox();
        jbAddCidade = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        siteTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomeTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cnpjTF = new javax.swing.JTextField();
        codigoTF = new javax.swing.JTextField();
        jlCodigo = new javax.swing.JLabel();
        jpTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaEmpresa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbSalvarAlteracoes = new javax.swing.JButton();
        jbLimparCampos = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Editar/Consultar informações sobre a  Empresa");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/building_edit.png"))); // NOI18N

        jDesktopPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jDesktopPane1.setEnabled(false);

        jpInfoempresa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Endereço:");

        enderecoTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enderecoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Bairro:");

        bairroCB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bairroCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro" }));
        bairroCB.setSelectedIndex(-1);

        jbAddBairro.setText("+");
        jbAddBairro.setToolTipText("Adicionar Bairro");
        jbAddBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddBairroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Telefone de contato:");

        telTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        try {
            telTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Estado:");

        estadoCB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        estadoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre - AC", "Alagoas - AL", "Amapá - AP", "Amazonas - AM", "Bahia - BH", "Ceará - CE", "Distrito Federal - DF", "Espírito Santo - ES", "Goiás - GO", "Maranhão - MA", "Mato Grosso - MT", "Mato Grosso do Sul - MS", "Minas Gerais - MG", "Pará - PA", "Paraíba - PB", "Paraná - PR", "Pernambuco - PE", "Piauí - PI", "Rio de Janeiro - RJ", "Rio Grande do Norte - RN", "Rio Grande do Sul - RS", "Rondônia - RO", "Roraima - RR", "Santa Cantarina - SC", "São Paulo - SP", "Sergipe - SE", "Tocantins - TO" }));
        estadoCB.setSelectedIndex(-1);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Cidade:");

        cidadeCB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cidadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Campina Grande - PB" }));
        cidadeCB.setSelectedIndex(-1);

        jbAddCidade.setText("+");
        jbAddCidade.setToolTipText("Adicionar Cidade");
        jbAddCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddCidadeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Site:");

        siteTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        siteTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Nome da Empresa:");

        nomeTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nomeTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Email para contato:");

        emailTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setText("CNPJ:");

        cnpjTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cnpjTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        codigoTF.setEditable(false);
        codigoTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        codigoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        codigoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codigoTF.setEnabled(false);

        jlCodigo.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCodigo.setText("Código:");
        jlCodigo.setToolTipText("");

        javax.swing.GroupLayout jpInfoempresaLayout = new javax.swing.GroupLayout(jpInfoempresa);
        jpInfoempresa.setLayout(jpInfoempresaLayout);
        jpInfoempresaLayout.setHorizontalGroup(
            jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoempresaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpInfoempresaLayout.createSequentialGroup()
                            .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoempresaLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(10, 10, 10)
                            .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbAddBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cnpjTF))))
                        .addGroup(jpInfoempresaLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(siteTF, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpInfoempresaLayout.createSequentialGroup()
                            .addComponent(jlCodigo)
                            .addGap(5, 5, 5)
                            .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpInfoempresaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAddCidade)))
                .addContainerGap())
        );
        jpInfoempresaLayout.setVerticalGroup(
            jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel16)
                    .addComponent(cnpjTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(siteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cidadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddCidade)
                    .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jpTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabelaEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TabelaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CNPJ", "Endereço", "Bairro", "Site", "Email", "Telefone", "Estado", "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaEmpresa.getTableHeader().setReorderingAllowed(false);
        TabelaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaEmpresa);

        javax.swing.GroupLayout jpTabelaLayout = new javax.swing.GroupLayout(jpTabela);
        jpTabela.setLayout(jpTabelaLayout);
        jpTabelaLayout.setHorizontalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jpTabelaLayout.setVerticalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTabelaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jbSalvarAlteracoes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbSalvarAlteracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/tick.png"))); // NOI18N
        jbSalvarAlteracoes.setText("SALVAR ALTERAÇÕES");
        jbSalvarAlteracoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarAlteracoesActionPerformed(evt);
            }
        });

        jbLimparCampos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cancel.png"))); // NOI18N
        jbLimparCampos.setText("LIMPAR CAMPOS");
        jbLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparCamposActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/delete.png"))); // NOI18N
        jbExcluir.setText("EXCLUIR");
        jbExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cross.png"))); // NOI18N
        jbCancelar.setText("CANCELAR");
        jbCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jbSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLimparCampos)
                .addGap(18, 18, 18)
                .addComponent(jbExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbSalvarAlteracoes)
                        .addComponent(jbLimparCampos)
                        .addComponent(jbExcluir))
                    .addComponent(jbCancelar, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpInfoempresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jpInfoempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jpInfoempresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jpTabela, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddBairroActionPerformed
        try {
            AdicionarBairro addBairro = new AdicionarBairro();
            jDesktopPane1.add(addBairro);
            addBairro.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAddBairroActionPerformed

    private void jbAddCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddCidadeActionPerformed
        try {
            AdicionarCidade addCidade = new AdicionarCidade();
            jDesktopPane1.add(addCidade);
            addCidade.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAddCidadeActionPerformed

    private void TabelaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEmpresaMouseClicked
        mostraInformacoes();
    }//GEN-LAST:event_TabelaEmpresaMouseClicked

    private void jbSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarAlteracoesActionPerformed
        atualizarEmpresa();
    }//GEN-LAST:event_jbSalvarAlteracoesActionPerformed

    private void jbLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbLimparCamposActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        deletarEmpresa();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaEmpresa;
    private javax.swing.JComboBox bairroCB;
    private javax.swing.JComboBox cidadeCB;
    private javax.swing.JTextField cnpjTF;
    private javax.swing.JTextField codigoTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField enderecoTF;
    private javax.swing.JComboBox estadoCB;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAddBairro;
    private javax.swing.JButton jbAddCidade;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimparCampos;
    private javax.swing.JButton jbSalvarAlteracoes;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JPanel jpInfoempresa;
    private javax.swing.JPanel jpTabela;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JTextField siteTF;
    private javax.swing.JFormattedTextField telTF;
    // End of variables declaration//GEN-END:variables
}
