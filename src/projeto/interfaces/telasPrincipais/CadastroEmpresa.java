package projeto.interfaces.telasPrincipais;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import projeto.classes.*;
import projeto.interfaces.internas.editarEmpresa;
import projeto.interfaces.miniInterfaces.*;

public class CadastroEmpresa extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public CadastroEmpresa() throws ClassNotFoundException {
        initComponents();
        conexao = ConexaoBD.conectadbd();
        this.setLocation(20, 5);
        limparCampos();
        jCbBairro();
        jCbCidade();
        mensagem();
    }

    public void cadastrarEmpresa() {

        String sql = "Insert into empresa (nome, cnpj, estado, cidade, telefone, endereco, bairro, site, email)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

            if (!nomeTF.getText().equals("")
                    && !cnpjTF.getText().equals("")
                    && !estadoCB.getSelectedItem().equals(-1)
                    && !cidadeCB.getSelectedItem().equals(-1)
                    && !telTF.getText().equals("")
                    && !enderecoTF.getText().equals("")
                    && !bairroCB.getSelectedItem().equals(-1)
                    && !siteTF.getText().equals("")
                    && !emailTF.getText().equals("")) {

                pst.execute();
                JOptionPane.showMessageDialog(this, "Empresa cadastrada", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                desativarCampos();

            } else {
                JOptionPane.showMessageDialog(this, "Alguns campos são obrigátorios", "ERRO NO CADASTRO", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void limparCampos() {

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

    public void jCbBairro() {

        String sql = "Select *from bairro";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                bairroCB.addItem(rs.getString("nome"));

            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void jCbCidade() {

        String sql = "Select *from cidade";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cidadeCB.addItem(rs.getString("nome"));

            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void ativarCampos() {

        nomeTF.setEnabled(true);
        cnpjTF.setEnabled(true);
        estadoCB.setEnabled(true);
        cidadeCB.setEnabled(true);
        telTF.setEnabled(true);
        enderecoTF.setEnabled(true);
        bairroCB.setEnabled(true);
        siteTF.setEnabled(true);
        emailTF.setEnabled(true);

        jbCadastrar.setEnabled(true);
        jbEditarEmpresa.setEnabled(true);
        jbLimparCampos.setEnabled(true);
        jbAtualizar.setEnabled(true);

        jbAddBairro.setEnabled(true);
        jbAddCidade.setEnabled(true);
        jbNovo.setEnabled(false);

        nomeTF.requestFocus();
    }

    public void desativarCampos() {

        nomeTF.setEnabled(false);
        cnpjTF.setEnabled(false);
        estadoCB.setEnabled(false);
        cidadeCB.setEnabled(false);
        telTF.setEnabled(false);
        enderecoTF.setEnabled(false);
        bairroCB.setEnabled(false);
        siteTF.setEnabled(false);
        emailTF.setEnabled(false);

        jbCadastrar.setEnabled(false);
        jbLimparCampos.setEnabled(false);
        jbEditarEmpresa.setEnabled(false);
        jbAtualizar.setEnabled(false);

        jbAddBairro.setEnabled(false);
        jbAddCidade.setEnabled(false);
        jbNovo.setEnabled(true);
    }

    public void atualizar() {
        jCbBairro();
        jCbCidade();

    }

    public void gerarSequencia() {
        Random gerador = new Random();

        for (int i = 1; i <= 12; i++) {
            LicencaTF.setText(String.valueOf(gerador.nextInt()));
        }
    }

    public void mensagem() {
        JOptionPane.showMessageDialog(this, "Cadastre uma nova empresa ao sistema iVagasNet", "Cadastrar Empresa", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jpInfoempresa = new javax.swing.JPanel();
        jlEndereco = new javax.swing.JLabel();
        enderecoTF = new javax.swing.JTextField();
        jlBairro = new javax.swing.JLabel();
        bairroCB = new javax.swing.JComboBox();
        jbAddBairro = new javax.swing.JButton();
        jlTelefone = new javax.swing.JLabel();
        telTF = new javax.swing.JFormattedTextField();
        jlEstado = new javax.swing.JLabel();
        estadoCB = new javax.swing.JComboBox();
        jlCidade = new javax.swing.JLabel();
        cidadeCB = new javax.swing.JComboBox();
        jbAddCidade = new javax.swing.JButton();
        jlSite = new javax.swing.JLabel();
        siteTF = new javax.swing.JTextField();
        jlNomeEmpresa = new javax.swing.JLabel();
        nomeTF = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jlCNPJ = new javax.swing.JLabel();
        cnpjTF = new javax.swing.JFormattedTextField();
        jpBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbLimparCampos = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbEditarEmpresa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        LicencaTF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Empresa no Sistema iVagasNet");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/building_add.png"))); // NOI18N

        jDesktopPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jDesktopPane1.setEnabled(false);

        jpInfoempresa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMAÇÕES DA EMPRESA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jlEndereco.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEndereco.setText("Endereço:");

        enderecoTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enderecoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        enderecoTF.setEnabled(false);

        jlBairro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlBairro.setText("Bairro:");

        bairroCB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bairroCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro" }));
        bairroCB.setSelectedIndex(-1);
        bairroCB.setEnabled(false);

        jbAddBairro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbAddBairro.setText("+");
        jbAddBairro.setToolTipText("Adicionar Bairro");
        jbAddBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddBairro.setEnabled(false);
        jbAddBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddBairroActionPerformed(evt);
            }
        });

        jlTelefone.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlTelefone.setText("Telefone de contato:");

        telTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        try {
            telTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telTF.setEnabled(false);
        telTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jlEstado.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEstado.setText("Estado:");

        estadoCB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        estadoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre - AC", "Alagoas - AL", "Amapá - AP", "Amazonas - AM", "Bahia - BH", "Ceará - CE", "Distrito Federal - DF", "Espírito Santo - ES", "Goiás - GO", "Maranhão - MA", "Mato Grosso - MT", "Mato Grosso do Sul - MS", "Minas Gerais - MG", "Pará - PA", "Paraíba - PB", "Paraná - PR", "Pernambuco - PE", "Piauí - PI", "Rio de Janeiro - RJ", "Rio Grande do Norte - RN", "Rio Grande do Sul - RS", "Rondônia - RO", "Roraima - RR", "Santa Cantarina - SC", "São Paulo - SP", "Sergipe - SE", "Tocantins - TO" }));
        estadoCB.setSelectedIndex(-1);
        estadoCB.setEnabled(false);

        jlCidade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCidade.setText("Cidade:");

        cidadeCB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cidadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Campina Grande - PB" }));
        cidadeCB.setSelectedIndex(-1);
        cidadeCB.setEnabled(false);

        jbAddCidade.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbAddCidade.setText("+");
        jbAddCidade.setToolTipText("Adicionar Cidade");
        jbAddCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddCidade.setEnabled(false);
        jbAddCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddCidadeActionPerformed(evt);
            }
        });

        jlSite.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlSite.setText("Site:");

        siteTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        siteTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        siteTF.setEnabled(false);

        jlNomeEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNomeEmpresa.setText("Nome da Empresa:");

        nomeTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nomeTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nomeTF.setEnabled(false);

        jlEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEmail.setText("Email para contato:");

        emailTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        emailTF.setEnabled(false);

        jlCNPJ.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCNPJ.setText("CNPJ:");

        cnpjTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        try {
            cnpjTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cnpjTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnpjTF.setEnabled(false);
        cnpjTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpInfoempresaLayout = new javax.swing.GroupLayout(jpInfoempresa);
        jpInfoempresa.setLayout(jpInfoempresaLayout);
        jpInfoempresaLayout.setHorizontalGroup(
            jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoempresaLayout.createSequentialGroup()
                        .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jlCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cidadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbAddCidade)
                                .addGap(18, 18, 18)
                                .addComponent(jlBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAddBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlSite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(siteTF, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(jpInfoempresaLayout.createSequentialGroup()
                        .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlCNPJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cnpjTF, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlNomeEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jpInfoempresaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAddBairro, jbAddCidade});

        jpInfoempresaLayout.setVerticalGroup(
            jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoempresaLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNomeEmpresa)
                    .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCNPJ)
                    .addComponent(cnpjTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEndereco)
                    .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstado)
                    .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCidade)
                    .addComponent(cidadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddCidade)
                    .addComponent(jlBairro)
                    .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSite)
                    .addComponent(siteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jpInfoempresaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbAddBairro, jbAddCidade});

        jpBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jbNovo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/add.png"))); // NOI18N
        jbNovo.setText("NOVO");
        jbNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbCadastrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/accept.png"))); // NOI18N
        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCadastrar.setEnabled(false);
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbLimparCampos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cancel.png"))); // NOI18N
        jbLimparCampos.setText("LIMPAR CAMPOS");
        jbLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbLimparCampos.setEnabled(false);
        jbLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparCamposActionPerformed(evt);
            }
        });

        jbAtualizar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/page_refresh.png"))); // NOI18N
        jbAtualizar.setText("ATUALIZAR");
        jbAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAtualizar.setEnabled(false);
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbEditarEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbEditarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/building_edit.png"))); // NOI18N
        jbEditarEmpresa.setText("EDITAR EMPRESA");
        jbEditarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditarEmpresa.setEnabled(false);
        jbEditarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jbNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEditarEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbLimparCampos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBotoesLayout.setVerticalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovo)
                    .addComponent(jbCadastrar)
                    .addComponent(jbLimparCampos)
                    .addComponent(jbAtualizar)
                    .addComponent(jbEditarEmpresa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número da Licença", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextPane2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jTextPane2.setText("*Esta única sequência numérica deve ser entregue ao dono da empresa. Ela será necessária para confirmar os dados da empresa.");
        jTextPane2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextPane2.setEnabled(false);
        jScrollPane2.setViewportView(jTextPane2);

        LicencaTF.setEditable(false);
        LicencaTF.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        try {
            LicencaTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        LicencaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LicencaTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        LicencaTF.setEnabled(false);
        LicencaTF.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LicencaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LicencaTF)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/Logo iVagasNet.png"))); // NOI18N

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInfoempresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpInfoempresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1.setLayer(jpInfoempresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jpBotoes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddBairroActionPerformed
        try {
            AdicionarBairro addBairro = new AdicionarBairro();
            jDesktopPane1.add(addBairro);
            addBairro.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAddBairroActionPerformed

    private void jbAddCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddCidadeActionPerformed
        try {
            AdicionarCidade addCidade = new AdicionarCidade();
            jDesktopPane1.add(addCidade);
            addCidade.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAddCidadeActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        ativarCampos();
        gerarSequencia();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        cadastrarEmpresa();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbLimparCamposActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        atualizar();
        jbAtualizar.setEnabled(false);
        JOptionPane.showMessageDialog(this, "jComboBox atualizado!!", "", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jbEditarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarEmpresaActionPerformed
        try {
            editarEmpresa editar = new editarEmpresa();
            jDesktopPane1.add(editar);
            editar.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEditarEmpresaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField LicencaTF;
    private javax.swing.JComboBox bairroCB;
    private javax.swing.JComboBox cidadeCB;
    private javax.swing.JFormattedTextField cnpjTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField enderecoTF;
    private javax.swing.JComboBox estadoCB;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton jbAddBairro;
    private javax.swing.JButton jbAddCidade;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditarEmpresa;
    private javax.swing.JButton jbLimparCampos;
    private javax.swing.JButton jbNovo;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCNPJ;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlNomeEmpresa;
    private javax.swing.JLabel jlSite;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpInfoempresa;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JTextField siteTF;
    private javax.swing.JFormattedTextField telTF;
    // End of variables declaration//GEN-END:variables
}
