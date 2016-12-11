package projeto.interfaces.telasPrincipais;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import projeto.classes.*;
import projeto.interfaces.internas.editarCandidado;
import projeto.interfaces.miniInterfaces.*;

public class CadastroCandidato extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public CadastroCandidato() throws ClassNotFoundException {
        initComponents();
        conexao = ConexaoBD.conectadbd();
        this.setLocation(35, 20);
        this.jCbBairro();
        this.jCbCidade();
        limparCampos();
        mensagem();
    }

    public void mensagem(){
        JOptionPane.showMessageDialog(this, "Olá,\nPreencha seu cadastro gratuitamente e concorra a milhares de oportunidades!", "Cadastre o candidato", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void cadastrarFuncionario() {

        String sql = "Insert into estagiario (nome, cpf, sexo, idade, telefone, nivelEscolaridade, endereco, bairro, email, estado, cidade, formacaoAcademica, experiencias)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeTF.getText());
            pst.setString(2, cpfTF.getText());
            pst.setString(3, (String) sexoCB.getSelectedItem());
            pst.setString(4, (String) idadeCB.getSelectedItem());
            pst.setString(5, telTF.getText());
            pst.setString(6, (String) nivelEscolaridadeCB.getSelectedItem());
            pst.setString(7, enderecoTF.getText());
            pst.setString(8, (String) bairroCB.getSelectedItem());
            pst.setString(9, emailTF.getText());
            pst.setString(10, String.valueOf(estadoCB.getSelectedItem()));
            pst.setString(11, String.valueOf(cidadeCB.getSelectedItem()));
            pst.setString(12, formacaoAcademicaTF.getText());
            pst.setString(13, experienciasTF.getText());

            if (!nomeTF.getText().equals("")
                    && !cpfTF.getText().equals("")
                    && !sexoCB.getSelectedItem().equals(-1)
                    && !enderecoTF.getText().equals("")
                    && !nivelEscolaridadeCB.getSelectedItem().equals(-1)
                    && !enderecoTF.getText().equals("")
                    && !bairroCB.getSelectedItem().equals(-1)
                    && !estadoCB.getSelectedItem().equals(-1)
                    && !cidadeCB.getSelectedItem().equals(-1)
                    && !formacaoAcademicaTF.getText().equals(-1)
                    && !experienciasTF.getText().equals("")) {

                pst.execute();
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso\nTenha uma boa sorte, candidato!!", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
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
        cpfTF.setText("");
        telTF.setText("");
        enderecoTF.setText("");
        emailTF.setText("");
        formacaoAcademicaTF.setText("");
        experienciasTF.setText("");
        idadeCB.setSelectedIndex(-1);
        nivelEscolaridadeCB.setSelectedIndex(-1);
        bairroCB.setSelectedIndex(-1);
        estadoCB.setSelectedIndex(-1);
        cidadeCB.setSelectedIndex(-1);
        sexoCB.setSelectedIndex(-1);
        jbImagem.updateUI();
        
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
        cpfTF.setEnabled(true);
        sexoCB.setEnabled(true);
        idadeCB.setEnabled(true);
        telTF.setEnabled(true);
        nivelEscolaridadeCB.setEnabled(true);
        enderecoTF.setEnabled(true);
        bairroCB.setEnabled(true);
        emailTF.setEnabled(true);
        estadoCB.setEnabled(true);
        cidadeCB.setEnabled(true);
        formacaoAcademicaTF.setEnabled(true);
        experienciasTF.setEnabled(true);
        jbCadastrar.setEnabled(true);
        jbLimparCampos.setEnabled(true);
        jbEditarCandidato.setEnabled(true);
        jbAtualizar.setEnabled(true);
        jbAddBairro.setEnabled(true);
        jbAddCidade.setEnabled(true);
        jbNovo.setEnabled(false);
        nomeTF.requestFocus();
    }

    public void desativarCampos() {

        nomeTF.setEnabled(false);
        cpfTF.setEnabled(false);
        sexoCB.setEnabled(false);
        idadeCB.setEnabled(false);
        telTF.setEnabled(false);
        nivelEscolaridadeCB.setEnabled(false);
        enderecoTF.setEnabled(false);
        bairroCB.setEnabled(false);
        emailTF.setEnabled(false);
        estadoCB.setEnabled(false);
        cidadeCB.setEnabled(false);
        formacaoAcademicaTF.setEnabled(false);
        experienciasTF.setEnabled(false);
        jbCadastrar.setEnabled(false);
        jbLimparCampos.setEnabled(false);
        jbEditarCandidato.setEnabled(false);
        jbAtualizar.setEnabled(false);
        jbAddBairro.setEnabled(false);
        jbAddCidade.setEnabled(false);
        jbNovo.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AreaDeTrabalho = new javax.swing.JDesktopPane();
        jpBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbEditarCandidato = new javax.swing.JButton();
        jbLimparCampos = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jpInfoFunc = new javax.swing.JPanel();
        nomeTF = new javax.swing.JTextField();
        enderecoTF = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        cpfTF = new javax.swing.JFormattedTextField();
        jlTelefone = new javax.swing.JLabel();
        telTF = new javax.swing.JFormattedTextField();
        jlEstado = new javax.swing.JLabel();
        estadoCB = new javax.swing.JComboBox();
        jlCidade = new javax.swing.JLabel();
        cidadeCB = new javax.swing.JComboBox();
        jbAddCidade = new javax.swing.JButton();
        jlSexo = new javax.swing.JLabel();
        sexoCB = new javax.swing.JComboBox();
        jlIdade = new javax.swing.JLabel();
        idadeCB = new javax.swing.JComboBox();
        jlEmail = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jlNivelEscolaridade = new javax.swing.JLabel();
        nivelEscolaridadeCB = new javax.swing.JComboBox();
        jlFormacaoAcademica = new javax.swing.JLabel();
        jlExperiencias = new javax.swing.JLabel();
        formacaoAcademicaTF = new javax.swing.JTextField();
        experienciasTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bairroCB = new javax.swing.JComboBox();
        jbAddBairro = new javax.swing.JButton();
        jbImagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar o Candidato");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/buttom_candidato.png"))); // NOI18N

        AreaDeTrabalho.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        AreaDeTrabalho.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AreaDeTrabalho.setEnabled(false);

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

        jbEditarCandidato.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbEditarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/user_edit.png"))); // NOI18N
        jbEditarCandidato.setText("EDITAR CANDIDATO");
        jbEditarCandidato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditarCandidato.setEnabled(false);
        jbEditarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarCandidatoActionPerformed(evt);
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

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbNovo)
                .addGap(18, 18, 18)
                .addComponent(jbCadastrar)
                .addGap(18, 18, 18)
                .addComponent(jbEditarCandidato)
                .addGap(18, 18, 18)
                .addComponent(jbLimparCampos)
                .addGap(15, 15, 15)
                .addComponent(jbAtualizar)
                .addGap(54, 54, 54))
        );
        jpBotoesLayout.setVerticalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovo)
                    .addComponent(jbCadastrar)
                    .addComponent(jbEditarCandidato)
                    .addComponent(jbLimparCampos)
                    .addComponent(jbAtualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpInfoFunc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMAÇÕES DO CANDIDATO A VAGA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        nomeTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        nomeTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nomeTF.setEnabled(false);

        enderecoTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        enderecoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        enderecoTF.setEnabled(false);

        jlNome.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNome.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Endereço:");

        jlCPF.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCPF.setText("CPF:");

        cpfTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        try {
            cpfTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpfTF.setEnabled(false);
        cpfTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N

        jlTelefone.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlTelefone.setText("Telefone:");

        telTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        try {
            telTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telTF.setEnabled(false);
        telTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N

        jlEstado.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEstado.setText("Estado:");

        estadoCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        estadoCB.setMaximumRowCount(5);
        estadoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre - AC", "Alagoas - AL", "Amapá - AP", "Amazonas - AM", "Bahia - BH", "Ceará - CE", "Distrito Federal - DF", "Espírito Santo - ES", "Goiás - GO", "Maranhão - MA", "Mato Grosso - MT", "Mato Grosso do Sul - MS", "Minas Gerais - MG", "Pará - PA", "Paraíba - PB", "Paraná - PR", "Pernambuco - PE", "Piauí - PI", "Rio de Janeiro - RJ", "Rio Grande do Norte - RN", "Rio Grande do Sul - RS", "Rondônia - RO", "Roraima - RR", "Santa Cantarina - SC", "São Paulo - SP", "Sergipe - SE", "Tocantins - TO" }));
        estadoCB.setSelectedIndex(-1);
        estadoCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        estadoCB.setEnabled(false);

        jlCidade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCidade.setText("Cidade:");

        cidadeCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cidadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Campina Grande" }));
        cidadeCB.setSelectedIndex(-1);
        cidadeCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jlSexo.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlSexo.setText("Sexo:");

        sexoCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        sexoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        sexoCB.setSelectedIndex(-1);
        sexoCB.setEnabled(false);
        sexoCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sexoCBItemStateChanged(evt);
            }
        });

        jlIdade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlIdade.setText("Idade:");

        idadeCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        idadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "16 anos", "17 anos", "18 anos", "19 anos", "20 anos", "21 anos", "22 anos", "23 anos", "24 anos", "25 anos", "26 anos", "27 anos", "28 anos", "29 anos", "30 anos", "31 anos", "32 anos", "33 anos", "34 anos", "35 anos", "36 anos", "37 anos", "38 anos", "39 anos", "40 anos", "41 anos", "42 anos", "43 anos", "44 anos", "45 anos", "46 anos", "47 anos", "48 anos", "49 anos", "50 anos", "51 anos", "52 anos", "53 anos", "54 anos", "55 anos", "56 anos", "57 anos", "58 anos", "59 anos", "60 anos", "61 anos", "62 anos", "63 anos", "64 anos", "65 anos" }));
        idadeCB.setSelectedIndex(-1);
        idadeCB.setEnabled(false);

        jlEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEmail.setText("Email:");

        emailTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        emailTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        emailTF.setEnabled(false);

        jlNivelEscolaridade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNivelEscolaridade.setText("Nível de escolaridade:");

        nivelEscolaridadeCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        nivelEscolaridadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fundamental", "Ensino Médio", "Ensido Médio Técnico", "Superior Tecnólogo", "Superior", "Pós Gradução", "Mestrado", "Doutorado" }));
        nivelEscolaridadeCB.setSelectedIndex(-1);
        nivelEscolaridadeCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nivelEscolaridadeCB.setEnabled(false);

        jlFormacaoAcademica.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlFormacaoAcademica.setText("Formação Acadêmica:");

        jlExperiencias.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlExperiencias.setText("Experiências:");

        formacaoAcademicaTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        formacaoAcademicaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        formacaoAcademicaTF.setEnabled(false);

        experienciasTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        experienciasTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        experienciasTF.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Bairro:");

        bairroCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        bairroCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro" }));
        bairroCB.setSelectedIndex(-1);
        bairroCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jbImagem.setText("  ");

        javax.swing.GroupLayout jpInfoFuncLayout = new javax.swing.GroupLayout(jpInfoFunc);
        jpInfoFunc.setLayout(jpInfoFuncLayout);
        jpInfoFuncLayout.setHorizontalGroup(
            jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlExperiencias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(experienciasTF, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jlFormacaoAcademica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formacaoAcademicaTF)
                                .addGap(15, 15, 15))
                            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jlNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpfTF, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jlSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sexoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlNivelEscolaridade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nivelEscolaridadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jlEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cidadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAddCidade)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAddBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 10, Short.MAX_VALUE))))
        );
        jpInfoFuncLayout.setVerticalGroup(
            jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlIdade)
                        .addComponent(idadeCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlNome)
                        .addComponent(jlCPF)
                        .addComponent(cpfTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSexo)
                    .addComponent(sexoCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNivelEscolaridade)
                    .addComponent(nivelEscolaridadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jlEmail)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlCidade)
                        .addComponent(cidadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAddCidade)
                        .addComponent(jlEstado)
                        .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbAddBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFormacaoAcademica)
                    .addComponent(formacaoAcademicaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlExperiencias)
                    .addComponent(experienciasTF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/img/Logo iVagasNet.png"))); // NOI18N

        javax.swing.GroupLayout AreaDeTrabalhoLayout = new javax.swing.GroupLayout(AreaDeTrabalho);
        AreaDeTrabalho.setLayout(AreaDeTrabalhoLayout);
        AreaDeTrabalhoLayout.setHorizontalGroup(
            AreaDeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaDeTrabalhoLayout.createSequentialGroup()
                .addGroup(AreaDeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AreaDeTrabalhoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AreaDeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpInfoFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(AreaDeTrabalhoLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        AreaDeTrabalhoLayout.setVerticalGroup(
            AreaDeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaDeTrabalhoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpInfoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        AreaDeTrabalho.setLayer(jpBotoes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        AreaDeTrabalho.setLayer(jpInfoFunc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        AreaDeTrabalho.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AreaDeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AreaDeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddBairroActionPerformed
        try {
            AdicionarBairro addbairro = new AdicionarBairro();
            AreaDeTrabalho.add(addbairro);
            addbairro.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
        desativarCampos();
    }//GEN-LAST:event_jbAddBairroActionPerformed

    private void jbAddCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddCidadeActionPerformed
        try {
            AdicionarCidade addcidade = new AdicionarCidade();
            AreaDeTrabalho.add(addcidade);
            addcidade.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
        desativarCampos();
    }//GEN-LAST:event_jbAddCidadeActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        ativarCampos();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        cadastrarFuncionario();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbEditarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarCandidatoActionPerformed
        try {
            editarCandidado editar = new editarCandidado();
            AreaDeTrabalho.add(editar);
            editar.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEditarCandidatoActionPerformed

    private void jbLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbLimparCamposActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        jCbBairro();
        jCbCidade();
        jbAtualizar.setEnabled(false);
        JOptionPane.showMessageDialog(this, "jComboBox atualizado!!", "", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void sexoCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sexoCBItemStateChanged
        jbImagem.setIcon(icons[sexoCB.getSelectedIndex()]);
    }//GEN-LAST:event_sexoCBItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane AreaDeTrabalho;
    private javax.swing.JComboBox bairroCB;
    private javax.swing.JComboBox cidadeCB;
    private javax.swing.JFormattedTextField cpfTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField enderecoTF;
    private javax.swing.JComboBox estadoCB;
    private javax.swing.JTextField experienciasTF;
    private javax.swing.JTextField formacaoAcademicaTF;
    private javax.swing.JComboBox idadeCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbAddBairro;
    private javax.swing.JButton jbAddCidade;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditarCandidato;
    private javax.swing.JLabel jbImagem;
    private javax.swing.JButton jbLimparCampos;
    private javax.swing.JButton jbNovo;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlExperiencias;
    private javax.swing.JLabel jlFormacaoAcademica;
    private javax.swing.JLabel jlIdade;
    private javax.swing.JLabel jlNivelEscolaridade;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpInfoFunc;
    private javax.swing.JComboBox nivelEscolaridadeCB;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JComboBox sexoCB;
    private javax.swing.JFormattedTextField telTF;
    // End of variables declaration//GEN-END:variables

    private String names[] = {"src/projeto/interfaces/imagens/icones/user_gray.png", "src/projeto/interfaces/imagens/icones/user_female.png"};

    private Icon icons[] = {new ImageIcon(names[0]), new ImageIcon(names[1])};
}
