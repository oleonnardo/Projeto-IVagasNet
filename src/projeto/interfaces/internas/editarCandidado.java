
package projeto.interfaces.internas;

import projeto.interfaces.telasPrincipais.CadastroCandidato;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import projeto.classes.*;
import projeto.interfaces.miniInterfaces.*;

public class editarCandidado extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public editarCandidado() throws ClassNotFoundException {
        initComponents();
        conexao = ConexaoBD.conectadbd();
        this.setLocation(18, 2);
        listarEstagiario();
        limparCampos();
    }
    
 public void deletarEstagiario() {

        String sql = "Delete from estagiario where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigoTF.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
            listarEstagiario();
            limparCampos();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar cadastro.\nTente novamente.", "ERRO!!", JOptionPane.ERROR_MESSAGE);
        }
    }
  public void pesquisarEstagiario() {

        String sql = "Select *from estagiario where nome like ? order by nome Asc";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeTF.getText() + "%");
            rs = pst.executeQuery();
            TabelaEstagiario.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, "Aluno não cadastrado.\nTente outra vez.", "ERRO!!", JOptionPane.ERROR_MESSAGE);

        }
    }
      public void atualizarEstagiario() {

        String sql = "Update estagiario set  nome = ?, cpf = ?, sexo = ?, idade = ?,  telefone = ?, nivelEscolaridade = ?, endereco = ?, bairro = ?, "
                + "email = ?, estado = ?, cidade = ?, formacaoAcademica = ?,  experiencias = ? where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeTF.getText());
            pst.setString(2, cpfTF.getText());
            pst.setString(3, (String) sexoCB.getSelectedItem());
            pst.setString(4, (String) idadeCB.getSelectedItem());
            pst.setString(5, telTF.getText());
            pst.setString(6, (String) nivelEscolaridadeCB.getSelectedItem());
            pst.setString(7, enderecoTF.getText());
            pst.setString(8, String.valueOf(bairroCB.getSelectedItem()));
            pst.setString(9, emailTF.getText());
            pst.setString(10, (String) cidadeCB.getSelectedItem());
            pst.setString(11, (String) estadoCB.getSelectedItem());
            pst.setString(12, formacaoAcademicaTF.getText());
            pst.setString(13, experienciasTF.getText());
            pst.setInt(14, Integer.parseInt(codigoTF.getText()));

            if (!nomeTF.getText().equals("")
                    && !cpfTF.getText().equals("")
                    && !sexoCB.getSelectedItem().equals(-1)
                    && !idadeCB.getSelectedItem().equals(-1)
                    && !telTF.getText().equals("")
                    && !nivelEscolaridadeCB.getSelectedItem().equals(-1)
                    && !enderecoTF.getText().equals("")
                    && !bairroCB.getSelectedItem().equals("")
                    && !emailTF.getText().equals("")
                    && !cidadeCB.getSelectedItem().equals(-1)
                    && !estadoCB.getSelectedItem().equals("")
                    && !formacaoAcademicaTF.getText().equals("")
                    && !experienciasTF.getText().equals("")) {

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cadastro atualizado com sucesso", "Atualização concluída", JOptionPane.INFORMATION_MESSAGE);
                listarEstagiario();
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Alguns campos são obrigátorios", "ERRO NO CADASTRO", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
      }
      
    public void mostraInformacoes() {

        int seleciona = TabelaEstagiario.getSelectedRow();

        codigoTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 0).toString());
        nomeTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 1).toString());
        cpfTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 2).toString());
        sexoCB.setSelectedItem(TabelaEstagiario.getModel().getValueAt(seleciona, 3).toString());
        idadeCB.setSelectedItem(TabelaEstagiario.getModel().getValueAt(seleciona, 4).toString());
        telTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 5).toString());
        nivelEscolaridadeCB.setSelectedItem(TabelaEstagiario.getModel().getValueAt(seleciona, 6).toString());
        enderecoTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 7).toString());
        bairroCB.setSelectedItem(TabelaEstagiario.getModel().getValueAt(seleciona, 8).toString());
        emailTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 9).toString());
        cidadeCB.setSelectedItem(TabelaEstagiario.getModel().getValueAt(seleciona, 1).toString());
        estadoCB.setSelectedItem(TabelaEstagiario.getModel().getValueAt(seleciona, 11).toString());
        formacaoAcademicaTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 12).toString());
        experienciasTF.setText(TabelaEstagiario.getModel().getValueAt(seleciona, 13).toString());
    }
    
     public void listarEstagiario() {

        String sql = "Select *from estagiario order by codigo Asc";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            TabelaEstagiario.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }
     
     public void limparCampos(){
         codigoTF.setText("");
        nomeTF.setText("");
        cpfTF.setText("");
        sexoCB.setSelectedItem("");
        idadeCB.setSelectedItem("");
        telTF.setText("");
        nivelEscolaridadeCB.setSelectedItem("");
        enderecoTF.setText("");
        bairroCB.setSelectedItem("");
        emailTF.setText("");
        cidadeCB.setSelectedItem("");
        experienciasTF.setText("");
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jpTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaEstagiario = new javax.swing.JTable();
        jpInfoFunc = new javax.swing.JPanel();
        codigoTF = new javax.swing.JTextField();
        jlCodigo = new javax.swing.JLabel();
        experienciasTF = new javax.swing.JTextField();
        telTF = new javax.swing.JFormattedTextField();
        jlEstado = new javax.swing.JLabel();
        estadoCB = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        bairroCB = new javax.swing.JComboBox();
        jbAddBairro = new javax.swing.JButton();
        jlCidade = new javax.swing.JLabel();
        cidadeCB = new javax.swing.JComboBox();
        jbAddCidade = new javax.swing.JButton();
        jlSexo = new javax.swing.JLabel();
        sexoCB = new javax.swing.JComboBox();
        jlIdade = new javax.swing.JLabel();
        idadeCB = new javax.swing.JComboBox();
        jlEmail = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        nomeTF = new javax.swing.JTextField();
        jlNivelEscolaridade = new javax.swing.JLabel();
        enderecoTF = new javax.swing.JTextField();
        nivelEscolaridadeCB = new javax.swing.JComboBox();
        jlNome = new javax.swing.JLabel();
        jlFormacaoAcademica = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlExperiencias = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        formacaoAcademicaTF = new javax.swing.JTextField();
        cpfTF = new javax.swing.JFormattedTextField();
        jlTelefone = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbSalvarAlteracoes = new javax.swing.JButton();
        jbLimparCampos = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("Editar/Consultar informações sobre o Candidato");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/user_edit.png"))); // NOI18N

        jDesktopPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jDesktopPane1.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jpTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabelaEstagiario.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TabelaEstagiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Sexo", "Idade", "Telefone", "Nível Escolaridade", "Endereço", "Bairro", "Estado", "Cidade", "Formação Acadêmica", "Experiências"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaEstagiario.getTableHeader().setReorderingAllowed(false);
        TabelaEstagiario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEstagiarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaEstagiario);

        javax.swing.GroupLayout jpTabelaLayout = new javax.swing.GroupLayout(jpTabela);
        jpTabela.setLayout(jpTabelaLayout);
        jpTabelaLayout.setHorizontalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTabelaLayout.setVerticalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jpInfoFunc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        codigoTF.setEditable(false);
        codigoTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        codigoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        codigoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codigoTF.setEnabled(false);

        jlCodigo.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCodigo.setText("Código:");
        jlCodigo.setToolTipText("");

        experienciasTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        experienciasTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        telTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        try {
            telTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N

        jlEstado.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEstado.setText("Estado:");

        estadoCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        estadoCB.setMaximumRowCount(5);
        estadoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre - AC", "Alagoas - AL", "Amapá - AP", "Amazonas - AM", "Bahia - BH", "Ceará - CE", "Distrito Federal - DF", "Espírito Santo - ES", "Goiás - GO", "Maranhão - MA", "Mato Grosso - MT", "Mato Grosso do Sul - MS", "Minas Gerais - MG", "Pará - PA", "Paraíba - PB", "Paraná - PR", "Pernambuco - PE", "Piauí - PI", "Rio de Janeiro - RJ", "Rio Grande do Norte - RN", "Rio Grande do Sul - RS", "Rondônia - RO", "Roraima - RR", "Santa Cantarina - SC", "São Paulo - SP", "Sergipe - SE", "Tocantins - TO" }));
        estadoCB.setSelectedIndex(-1);
        estadoCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Bairro:");

        bairroCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        bairroCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro" }));
        bairroCB.setSelectedIndex(-1);
        bairroCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbAddBairro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbAddBairro.setText("+");
        jbAddBairro.setToolTipText("Adicionar Bairro");
        jbAddBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddBairroActionPerformed(evt);
            }
        });

        jlCidade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCidade.setText("Cidade:");

        cidadeCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cidadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Campina Grande" }));
        cidadeCB.setSelectedIndex(-1);
        cidadeCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbAddCidade.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbAddCidade.setText("+");
        jbAddCidade.setToolTipText("Adicionar Cidade");
        jbAddCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jlIdade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlIdade.setText("Idade:");

        idadeCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        idadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "16 anos", "17 anos", "18 anos", "19 anos", "20 anos", "21 anos", "22 anos", "23 anos", "24 anos", "25 anos", "26 anos", "27 anos", "28 anos", "29 anos", "30 anos", "31 anos", "32 anos", "33 anos", "34 anos", "35 anos", "36 anos", "37 anos", "38 anos", "39 anos", "40 anos", "41 anos", "42 anos", "43 anos", "44 anos", "45 anos", "46 anos", "47 anos", "48 anos", "49 anos", "50 anos", "51 anos", "52 anos", "53 anos", "54 anos", "55 anos", "56 anos", "57 anos", "58 anos", "59 anos", "60 anos", "61 anos", "62 anos", "63 anos", "64 anos", "65 anos" }));
        idadeCB.setSelectedIndex(-1);

        jlEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEmail.setText("Email:");

        emailTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        emailTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        nomeTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        nomeTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        jlNivelEscolaridade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNivelEscolaridade.setText("Nível de escolaridade:");

        enderecoTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        enderecoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        nivelEscolaridadeCB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        nivelEscolaridadeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fundamental", "Ensino Médio", "Ensido Médio Técnico", "Superior Tecnólogo", "Superior", "Pós Gradução", "Mestrado", "Doutorado" }));
        nivelEscolaridadeCB.setSelectedIndex(-1);
        nivelEscolaridadeCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlNome.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNome.setText("Nome:");

        jlFormacaoAcademica.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlFormacaoAcademica.setText("Formação Acadêmica:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Endereço:");

        jlExperiencias.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlExperiencias.setText("Experiências:");

        jlCPF.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCPF.setText("CPF:");

        formacaoAcademicaTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        formacaoAcademicaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));

        cpfTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        try {
            cpfTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpfTF.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N

        jlTelefone.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlTelefone.setText("Telefone:");

        javax.swing.GroupLayout jpInfoFuncLayout = new javax.swing.GroupLayout(jpInfoFunc);
        jpInfoFunc.setLayout(jpInfoFuncLayout);
        jpInfoFuncLayout.setHorizontalGroup(
            jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlCodigo)
                        .addGap(5, 5, 5)
                        .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sexoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNivelEscolaridade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nivelEscolaridadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(idadeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jlEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cidadeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jlEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTF))
                            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                                .addComponent(jbAddCidade)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAddBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlExperiencias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(experienciasTF))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlFormacaoAcademica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formacaoAcademicaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInfoFuncLayout.setVerticalGroup(
            jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlIdade)
                        .addComponent(idadeCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlNome)
                        .addComponent(jlCPF)
                        .addComponent(cpfTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSexo)
                    .addComponent(sexoCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNivelEscolaridade)
                    .addComponent(nivelEscolaridadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jlEmail)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCidade)
                    .addComponent(cidadeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddCidade)
                    .addComponent(jlEstado)
                    .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(bairroCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFormacaoAcademica)
                    .addComponent(formacaoAcademicaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlExperiencias)
                    .addComponent(experienciasTF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbSalvarAlteracoes)
                        .addComponent(jbLimparCampos)
                        .addComponent(jbExcluir))
                    .addComponent(jbCancelar, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpTabela, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInfoFunc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpInfoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaEstagiarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEstagiarioMouseClicked
        mostraInformacoes();
    }//GEN-LAST:event_TabelaEstagiarioMouseClicked

    private void jbSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarAlteracoesActionPerformed
       atualizarEstagiario();
    }//GEN-LAST:event_jbSalvarAlteracoesActionPerformed

    private void jbLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbLimparCamposActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
       deletarEstagiario();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbAddBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddBairroActionPerformed
        try {
            AdicionarBairro addbairro = new AdicionarBairro();
            jDesktopPane1.add(addbairro);
            addbairro.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAddBairroActionPerformed

    private void jbAddCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddCidadeActionPerformed
        try {
            AdicionarCidade addcidade = new AdicionarCidade();
            jDesktopPane1.add(addcidade);
            addcidade.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAddCidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaEstagiario;
    private javax.swing.JComboBox bairroCB;
    private javax.swing.JComboBox cidadeCB;
    private javax.swing.JTextField codigoTF;
    private javax.swing.JFormattedTextField cpfTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField enderecoTF;
    private javax.swing.JComboBox estadoCB;
    private javax.swing.JTextField experienciasTF;
    private javax.swing.JTextField formacaoAcademicaTF;
    private javax.swing.JComboBox idadeCB;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlExperiencias;
    private javax.swing.JLabel jlFormacaoAcademica;
    private javax.swing.JLabel jlIdade;
    private javax.swing.JLabel jlNivelEscolaridade;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JPanel jpInfoFunc;
    private javax.swing.JPanel jpTabela;
    private javax.swing.JComboBox nivelEscolaridadeCB;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JComboBox sexoCB;
    private javax.swing.JFormattedTextField telTF;
    // End of variables declaration//GEN-END:variables
}
