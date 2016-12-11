package projeto.interfaces.telasPrincipais;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import projeto.classes.*;
import projeto.interfaces.miniInterfaces.*;

public class ContratacaoDoEstagiario extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public ContratacaoDoEstagiario() throws ClassNotFoundException {
        initComponents();
        this.setLocation(20, 10);
        conexao = ConexaoBD.conectadbd();
        jCbDepartamento();
        pesquisarEmpresa();
        pesquisarEstagiario();
        limparCampos();
    }

    public void cadastrarEmprego() {

        String sql = "Insert into ivagasnet (empresa, cnpj, enderecoEmpresa, siteEmpresa, telefoneEmpresa, "
                + "nomeEstagiario, cpfEstagiario, idadeEstagiario, emailEstagiario, telefoneEstagiario, nivelEscolaridade, departamento, salario, admissao)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeEmpresaTF.getText());
            pst.setString(2, cnpjEmpresaTF.getText());
            pst.setString(3, enderecoEmpresaTF.getText());
            pst.setString(4, siteEmpresaTF.getText());
            pst.setString(5, telefoneEmpresaTF.getText());
            pst.setString(6, nomeEstagiarioTF.getText());
            pst.setString(7, cpfEstagiarioTF.getText());
            pst.setString(8, idadeEstagiarioTF.getText());
            pst.setString(9, emailEstagiarioTF.getText());
            pst.setString(10, telefoneEstagiarioTF.getText());
            pst.setString(11, nivelEscolaridadeTF.getText());
            pst.setString(12, String.valueOf(departamentoCB.getSelectedItem()));
            pst.setString(13, salarioTF.getText());
            pst.setString(14, admissaoTF.getText());

            if (!nomeEmpresaTF.getText().equals("")
                    && !cnpjEmpresaTF.getText().equals("")
                    && !enderecoEmpresaTF.getText().equals("")
                    && !siteEmpresaTF.getText().equals("")
                    && !telefoneEmpresaTF.getText().equals("")
                    && !nomeEstagiarioTF.getText().equals("")
                    && !cpfEstagiarioTF.getText().equals("")
                    && !idadeEstagiarioTF.getText().equals("")
                    && !emailEstagiarioTF.getText().equals("")
                    && !telefoneEstagiarioTF.getText().equals("")
                    && !departamentoCB.getSelectedItem().equals(-1)
                    && !salarioTF.getText().equals("")
                    && !admissaoTF.getText().equals("")) {

                pst.execute();
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!!", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                desativarCampos();

            } else {
                JOptionPane.showMessageDialog(this, "Alguns campos são obrigátorios", "ERRO NO CADASTRO", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void mostraEmpresa() {

        int seleciona = TabelaProcurarEmpresa.getSelectedRow();

        nomeProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 1).toString());
        cnpjProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 2).toString());
        enderecoProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 3).toString());
        bairroProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 4).toString());
        siteProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 5).toString());
        emailProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 6).toString());
        telefoneProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 7).toString());
        estadoProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 8).toString());
        cidadeProcurarEmpresaTF.setText(TabelaProcurarEmpresa.getModel().getValueAt(seleciona, 9).toString());
    }

    public void mostraCandidato() {

        int seleciona = TabelaProcurarCandidato.getSelectedRow();

        nomeEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 1).toString());
        cpfEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 2).toString());
        sexoEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 3).toString());
        idadeEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 4).toString());
        telefoneEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 5).toString());
        nivelEscolaridadelEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 6).toString());
        enderecoEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 7).toString());
        bairroEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 8).toString());
        emailEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 9).toString());
        estadoEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 10).toString());
        cidadeEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 11).toString());
        formacaoAcademicaEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 12).toString());
        experienciasEstagiarioProcurarTF.setText(TabelaProcurarCandidato.getModel().getValueAt(seleciona, 13).toString());
    }

    public void limparCampos() {

        nomeEmpresaTF.setText("");
        cnpjEmpresaTF.setText("");
        enderecoEmpresaTF.setText("");
        siteEmpresaTF.setText("");
        telefoneEmpresaTF.setText("");
        nomeEstagiarioTF.setText("");
        cpfEstagiarioTF.setText("");
        idadeEstagiarioTF.setText("");
        emailEstagiarioTF.setText("");
        telefoneEstagiarioTF.setText("");
        nivelEscolaridadeTF.setText("");
        departamentoCB.setSelectedItem(-1);
        salarioTF.setText("");
        admissaoTF.setText("");

        nomeProcurarEmpresaTF.setText("");
        cnpjProcurarEmpresaTF.setText("");
        enderecoProcurarEmpresaTF.setText("");
        bairroProcurarEmpresaTF.setText("");
        siteProcurarEmpresaTF.setText("");
        emailProcurarEmpresaTF.setText("");
        telefoneEmpresaTF.setText("");
        estadoProcurarEmpresaTF.setText("");
        cidadeProcurarEmpresaTF.setText("");

        nomeProcurarEmpresaTF.setText("");
        cpfEstagiarioProcurarTF.setText("");
        sexoEstagiarioProcurarTF.setText("");
        idadeEstagiarioProcurarTF.setText("");
        telefoneEstagiarioProcurarTF.setText("");
        nivelEscolaridadelEstagiarioProcurarTF.setText("");
        enderecoEstagiarioProcurarTF.setText("");
        bairroEstagiarioProcurarTF.setText("");
        emailEstagiarioProcurarTF.setText("");
        estadoEstagiarioProcurarTF.setText("");
        cidadeEstagiarioProcurarTF.setText("");
        nivelEscolaridadelEstagiarioProcurarTF.setText("");
        formacaoAcademicaEstagiarioProcurarTF.setText("");
        experienciasEstagiarioProcurarTF.setText("");

    }

    public void pesquisarEmpresa() {

        String sql = "Select *from empresa where nome like ? order by nome Asc";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeProcurarEmpresaTF.getText() + "%");
            rs = pst.executeQuery();
            TabelaProcurarEmpresa.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void pesquisarEstagiario() {

        String sql = "Select *from estagiario where nome like ? order by codigo Asc";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeEstagiarioProcurarTF.getText() + "%");
            rs = pst.executeQuery();
            TabelaProcurarEmpresa.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void jCbDepartamento() {

        String sql = "Select *from departamento";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                departamentoCB.addItem(rs.getString("nome"));

            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);

        }
    }

    public void ativarCampos() {

        jbProcurarCandidato.setEnabled(true);
        jbProcurarEmpresa.setEnabled(true);
        jbCadastrar.setEnabled(true);
        jbGerarPDF.setEnabled(true);
        jbAddDepartamento.setEnabled(true);
        jbLimparCampos.setEnabled(true);
        departamentoCB.setEnabled(true);
        salarioTF.setEnabled(true);
        admissaoTF.setEnabled(true);
        jbNovo.setEnabled(false);

    }

    public void desativarCampos() {

        jbProcurarCandidato.setEnabled(false);
        jbProcurarEmpresa.setEnabled(false);
        jbCadastrar.setEnabled(false);
        jbGerarPDF.setEnabled(false);
        jbAddDepartamento.setEnabled(false);
        jbLimparCampos.setEnabled(false);
        departamentoCB.setEnabled(false);
        salarioTF.setEnabled(false);
        admissaoTF.setEnabled(false);
        jbNovo.setEnabled(true);

    }

    public void admissao() {
        LocalDate hj = LocalDate.now();
        admissaoTF.setText(hj.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

    }

    public void atualizar() {
        jCbDepartamento();

    }

    public void geraCSV() {
        String sql = "copy (select *from ivagasnet) to 'c:/temp/curriculos.csv' with csv header";
        try {
            //realiza o salvamento do aquivo do banco de dados para CSV
            pst = conexao.prepareStatement(sql);
            //executando o backup
            pst.execute();
            JOptionPane.showMessageDialog(this, "Concluído");
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }

      public void listarEstagiario() {

        String sql = "Select *from estagiario order by nome Asc";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            TabelaProcurarCandidato.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }
        public void listarEmpresa() {

        String sql = "Select *from empresa order by nome Asc";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            TabelaProcurarEmpresa.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProcurarEmpresa = new javax.swing.JFrame();
        jpTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProcurarEmpresa = new javax.swing.JTable();
        jpInfoempresa1 = new javax.swing.JPanel();
        jlEnderecoEmpresaProcurarLivro = new javax.swing.JLabel();
        enderecoProcurarEmpresaTF = new javax.swing.JTextField();
        jlBairroEmpresaProcurarLivro = new javax.swing.JLabel();
        jlTelefoneEmpresaProcurarLivro = new javax.swing.JLabel();
        jlEstadoEmpresaProcurarLivro = new javax.swing.JLabel();
        jlCidadeEmpresaProcurarLivro = new javax.swing.JLabel();
        jlSiteEmpresaProcurarLivro = new javax.swing.JLabel();
        siteProcurarEmpresaTF = new javax.swing.JTextField();
        jlNomeEmpresaProcurarLivro = new javax.swing.JLabel();
        nomeProcurarEmpresaTF = new javax.swing.JTextField();
        jlEmailEmpresaProcurarLivro = new javax.swing.JLabel();
        emailProcurarEmpresaTF = new javax.swing.JTextField();
        jlCNPJEmpresaProcurarLivro = new javax.swing.JLabel();
        cnpjProcurarEmpresaTF = new javax.swing.JTextField();
        cidadeProcurarEmpresaTF = new javax.swing.JTextField();
        estadoProcurarEmpresaTF = new javax.swing.JTextField();
        telefoneProcurarEmpresaTF = new javax.swing.JTextField();
        bairroProcurarEmpresaTF = new javax.swing.JTextField();
        jbCancelarEmpresa = new javax.swing.JButton();
        jbOkEmpresa = new javax.swing.JButton();
        ProcurarCandidato = new javax.swing.JFrame();
        jpTabela1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaProcurarCandidato = new javax.swing.JTable();
        jbCancelarProcurarAluno = new javax.swing.JButton();
        jbOkProcurarEstagiario = new javax.swing.JButton();
        jpInfoFunc2 = new javax.swing.JPanel();
        nomeEstagiarioProcurarTF = new javax.swing.JTextField();
        enderecoEstagiarioProcurarTF = new javax.swing.JTextField();
        jlNomeAlunoProcurar = new javax.swing.JLabel();
        jlEnderecoAlunoProcurar = new javax.swing.JLabel();
        jlCPFAlunoProcurar = new javax.swing.JLabel();
        jlTelefoneAlunoProcurar = new javax.swing.JLabel();
        jlEstadoAlunoProcurar = new javax.swing.JLabel();
        jlBairroAlunoProcurar = new javax.swing.JLabel();
        jlCidadeAlunoProcurar = new javax.swing.JLabel();
        jlSexoAlunoProcurar = new javax.swing.JLabel();
        jlIdadeAlunoProcurar = new javax.swing.JLabel();
        jlEmailAlunoProcurar = new javax.swing.JLabel();
        emailEstagiarioProcurarTF = new javax.swing.JTextField();
        jlNivelEscolaridadeEstagiarioProcurar = new javax.swing.JLabel();
        jlFormacaoAcademicaAlunoProcurar = new javax.swing.JLabel();
        jlExperienciasAlunoProcurar = new javax.swing.JLabel();
        nivelEscolaridadelEstagiarioProcurarTF = new javax.swing.JTextField();
        cpfEstagiarioProcurarTF = new javax.swing.JTextField();
        idadeEstagiarioProcurarTF = new javax.swing.JTextField();
        cidadeEstagiarioProcurarTF = new javax.swing.JTextField();
        estadoEstagiarioProcurarTF = new javax.swing.JTextField();
        sexoEstagiarioProcurarTF = new javax.swing.JTextField();
        telefoneEstagiarioProcurarTF = new javax.swing.JTextField();
        bairroEstagiarioProcurarTF = new javax.swing.JTextField();
        experienciasEstagiarioProcurarTF = new javax.swing.JTextField();
        formacaoAcademicaEstagiarioProcurarTF = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jpTodasAsInformacoes = new javax.swing.JPanel();
        jpInfoempresa = new javax.swing.JPanel();
        jlEnderecoEmpresa = new javax.swing.JLabel();
        enderecoEmpresaTF = new javax.swing.JTextField();
        jlTelefoneEmpresa = new javax.swing.JLabel();
        jlSiteEmpresa = new javax.swing.JLabel();
        siteEmpresaTF = new javax.swing.JTextField();
        jlNomeEmpresa = new javax.swing.JLabel();
        nomeEmpresaTF = new javax.swing.JTextField();
        jbProcurarEmpresa = new javax.swing.JButton();
        telefoneEmpresaTF = new javax.swing.JTextField();
        jlCNPJEmpresaProcurarLivro1 = new javax.swing.JLabel();
        cnpjEmpresaTF = new javax.swing.JTextField();
        jpInfoFunc = new javax.swing.JPanel();
        nomeEstagiarioTF = new javax.swing.JTextField();
        jlNomeAluno = new javax.swing.JLabel();
        jlCpfAluno = new javax.swing.JLabel();
        jlTelefoneAluno = new javax.swing.JLabel();
        jlIdadeAluno = new javax.swing.JLabel();
        jlEmailAluno = new javax.swing.JLabel();
        emailEstagiarioTF = new javax.swing.JTextField();
        idadeEstagiarioTF = new javax.swing.JTextField();
        telefoneEstagiarioTF = new javax.swing.JTextField();
        cpfEstagiarioTF = new javax.swing.JTextField();
        jbProcurarCandidato = new javax.swing.JButton();
        nivelEscolaridadeTF = new javax.swing.JTextField();
        jlNivelEscolaridade = new javax.swing.JLabel();
        jpInforPreContratacao = new javax.swing.JPanel();
        departamentoCB = new javax.swing.JComboBox();
        jbAddDepartamento = new javax.swing.JButton();
        jlDepartamento = new javax.swing.JLabel();
        jlSalarioMensal = new javax.swing.JLabel();
        salarioTF = new javax.swing.JTextField();
        jlDataAdmissao = new javax.swing.JLabel();
        admissaoTF = new javax.swing.JTextField();
        jpBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbLimparCampos = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbGerarPDF = new javax.swing.JButton();

        ProcurarEmpresa.setLocationRelativeTo(null);
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/projeto/interfaces/imagens/icones/zoom.png");
            ProcurarEmpresa.setIconImage(icon);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 0);
        }
        ProcurarEmpresa.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ProcurarEmpresa.setTitle("Procurar Empresa");
        ProcurarEmpresa.setLocationRelativeTo(null);
        ProcurarEmpresa.setSize(new java.awt.Dimension(939, 512));
        ProcurarEmpresa.setLocationRelativeTo(null);
        ProcurarEmpresa.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                ProcurarEmpresaWindowOpened(evt);
            }
        });

        jpTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabelaProcurarEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TabelaProcurarEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CNPJ", "Estado", "Cidade", "Telefone", "Endereço", "Bairro", "Site", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaProcurarEmpresa.getTableHeader().setReorderingAllowed(false);
        TabelaProcurarEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProcurarEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaProcurarEmpresa);

        javax.swing.GroupLayout jpTabelaLayout = new javax.swing.GroupLayout(jpTabela);
        jpTabela.setLayout(jpTabelaLayout);
        jpTabelaLayout.setHorizontalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTabelaLayout.setVerticalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpInfoempresa1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROCURAR EMPRESA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jlEnderecoEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEnderecoEmpresaProcurarLivro.setText("Endereço:");

        enderecoProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enderecoProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        enderecoProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        enderecoProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        enderecoProcurarEmpresaTF.setEnabled(false);

        jlBairroEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlBairroEmpresaProcurarLivro.setText("Bairro:");

        jlTelefoneEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlTelefoneEmpresaProcurarLivro.setText("Telefone de contato:");

        jlEstadoEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEstadoEmpresaProcurarLivro.setText("Estado:");

        jlCidadeEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCidadeEmpresaProcurarLivro.setText("Cidade:");

        jlSiteEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlSiteEmpresaProcurarLivro.setText("Site:");

        siteProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        siteProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        siteProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        siteProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        siteProcurarEmpresaTF.setEnabled(false);

        jlNomeEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNomeEmpresaProcurarLivro.setText("Nome da Empresa:");

        nomeProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nomeProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nomeProcurarEmpresaTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeProcurarEmpresaTFKeyReleased(evt);
            }
        });

        jlEmailEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEmailEmpresaProcurarLivro.setText("Email para contato:");

        emailProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        emailProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        emailProcurarEmpresaTF.setEnabled(false);

        jlCNPJEmpresaProcurarLivro.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCNPJEmpresaProcurarLivro.setText("CNPJ:");

        cnpjProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cnpjProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnpjProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        cnpjProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        cnpjProcurarEmpresaTF.setEnabled(false);

        cidadeProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cidadeProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cidadeProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        cidadeProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        cidadeProcurarEmpresaTF.setEnabled(false);

        estadoProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        estadoProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        estadoProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        estadoProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        estadoProcurarEmpresaTF.setEnabled(false);

        telefoneProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telefoneProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefoneProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        telefoneProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        telefoneProcurarEmpresaTF.setEnabled(false);

        bairroProcurarEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bairroProcurarEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bairroProcurarEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        bairroProcurarEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        bairroProcurarEmpresaTF.setEnabled(false);

        javax.swing.GroupLayout jpInfoempresa1Layout = new javax.swing.GroupLayout(jpInfoempresa1);
        jpInfoempresa1.setLayout(jpInfoempresa1Layout);
        jpInfoempresa1Layout.setHorizontalGroup(
            jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                        .addGroup(jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                                .addComponent(jlEnderecoEmpresaProcurarLivro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoProcurarEmpresaTF))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoempresa1Layout.createSequentialGroup()
                                .addComponent(jlNomeEmpresaProcurarLivro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                                .addComponent(jlBairroEmpresaProcurarLivro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bairroProcurarEmpresaTF))
                            .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                                .addComponent(jlCNPJEmpresaProcurarLivro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cnpjProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                        .addComponent(jlSiteEmpresaProcurarLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siteProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jlEmailEmpresaProcurarLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailProcurarEmpresaTF))
                    .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                        .addComponent(jlTelefoneEmpresaProcurarLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefoneProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlEstadoEmpresaProcurarLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jlCidadeEmpresaProcurarLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidadeProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpInfoempresa1Layout.setVerticalGroup(
            jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoempresa1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNomeEmpresaProcurarLivro)
                    .addComponent(jlCNPJEmpresaProcurarLivro)
                    .addComponent(cnpjProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEnderecoEmpresaProcurarLivro)
                    .addComponent(enderecoProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBairroEmpresaProcurarLivro)
                    .addComponent(bairroProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSiteEmpresaProcurarLivro)
                    .addComponent(siteProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmailEmpresaProcurarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstadoEmpresaProcurarLivro)
                    .addComponent(jlCidadeEmpresaProcurarLivro)
                    .addComponent(jlTelefoneEmpresaProcurarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneProcurarEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jbCancelarEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbCancelarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cancel.png"))); // NOI18N
        jbCancelarEmpresa.setText("CANCELAR");
        jbCancelarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCancelarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarEmpresaActionPerformed(evt);
            }
        });

        jbOkEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbOkEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/tick.png"))); // NOI18N
        jbOkEmpresa.setText("OK");
        jbOkEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbOkEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProcurarEmpresaLayout = new javax.swing.GroupLayout(ProcurarEmpresa.getContentPane());
        ProcurarEmpresa.getContentPane().setLayout(ProcurarEmpresaLayout);
        ProcurarEmpresaLayout.setHorizontalGroup(
            ProcurarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcurarEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProcurarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProcurarEmpresaLayout.createSequentialGroup()
                        .addGroup(ProcurarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpInfoempresa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcurarEmpresaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbOkEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelarEmpresa)
                        .addGap(67, 67, 67))))
        );

        ProcurarEmpresaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCancelarEmpresa, jbOkEmpresa});

        ProcurarEmpresaLayout.setVerticalGroup(
            ProcurarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcurarEmpresaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jpInfoempresa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jpTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(ProcurarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbOkEmpresa)
                    .addComponent(jbCancelarEmpresa))
                .addGap(42, 42, 42))
        );

        ProcurarEmpresaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbCancelarEmpresa, jbOkEmpresa});

        ProcurarCandidato.setLocationRelativeTo(null);
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/projeto/interfaces/imagens/icones/zoom.png");
            ProcurarCandidato.setIconImage(icon);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 0);
        }
        ProcurarCandidato.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ProcurarCandidato.setTitle("Procurar Candidato");
        ProcurarCandidato.setSize(new java.awt.Dimension(1089, 580));
        ProcurarCandidato.setLocationRelativeTo(null);
        ProcurarCandidato.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                ProcurarCandidatoWindowOpened(evt);
            }
        });

        jpTabela1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabelaProcurarCandidato.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TabelaProcurarCandidato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Sexo", "Idade", "Telefone", "Nível Escolaridade", "Endereço", "Bairro", "Estado", "Cidade", "Formação Acadêmica", "Experiências"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaProcurarCandidato.getTableHeader().setReorderingAllowed(false);
        TabelaProcurarCandidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProcurarCandidatoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabelaProcurarCandidato);

        javax.swing.GroupLayout jpTabela1Layout = new javax.swing.GroupLayout(jpTabela1);
        jpTabela1.setLayout(jpTabela1Layout);
        jpTabela1Layout.setHorizontalGroup(
            jpTabela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTabela1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jpTabela1Layout.setVerticalGroup(
            jpTabela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTabela1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jbCancelarProcurarAluno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbCancelarProcurarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/cancel.png"))); // NOI18N
        jbCancelarProcurarAluno.setText("CANCELAR");
        jbCancelarProcurarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCancelarProcurarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarProcurarAlunoActionPerformed(evt);
            }
        });

        jbOkProcurarEstagiario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbOkProcurarEstagiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/tick.png"))); // NOI18N
        jbOkProcurarEstagiario.setText("OK");
        jbOkProcurarEstagiario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbOkProcurarEstagiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkProcurarEstagiarioActionPerformed(evt);
            }
        });

        jpInfoFunc2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROCURAR CANDITADO À VAGA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        nomeEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nomeEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nomeEstagiarioProcurarTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeEstagiarioProcurarTFKeyReleased(evt);
            }
        });

        enderecoEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enderecoEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        enderecoEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        enderecoEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        enderecoEstagiarioProcurarTF.setEnabled(false);

        jlNomeAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNomeAlunoProcurar.setText("Nome:");

        jlEnderecoAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEnderecoAlunoProcurar.setText("Endereço:");

        jlCPFAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCPFAlunoProcurar.setText("CPF:");

        jlTelefoneAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlTelefoneAlunoProcurar.setText("Telefone:");

        jlEstadoAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEstadoAlunoProcurar.setText("Estado:");

        jlBairroAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlBairroAlunoProcurar.setText("Bairro:");

        jlCidadeAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCidadeAlunoProcurar.setText("Cidade:");

        jlSexoAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlSexoAlunoProcurar.setText("Sexo:");

        jlIdadeAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlIdadeAlunoProcurar.setText("Idade:");

        jlEmailAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEmailAlunoProcurar.setText("Email:");

        emailEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        emailEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        emailEstagiarioProcurarTF.setEnabled(false);

        jlNivelEscolaridadeEstagiarioProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNivelEscolaridadeEstagiarioProcurar.setText("Nível de escolaridade:");

        jlFormacaoAcademicaAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlFormacaoAcademicaAlunoProcurar.setText("Formação Acadêmica:");

        jlExperienciasAlunoProcurar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlExperienciasAlunoProcurar.setText("Experiências:");

        nivelEscolaridadelEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nivelEscolaridadelEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nivelEscolaridadelEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nivelEscolaridadelEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        nivelEscolaridadelEstagiarioProcurarTF.setEnabled(false);

        cpfEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cpfEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpfEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        cpfEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        cpfEstagiarioProcurarTF.setEnabled(false);

        idadeEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idadeEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idadeEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        idadeEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        idadeEstagiarioProcurarTF.setEnabled(false);

        cidadeEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cidadeEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cidadeEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        cidadeEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        cidadeEstagiarioProcurarTF.setEnabled(false);

        estadoEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        estadoEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        estadoEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        estadoEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        estadoEstagiarioProcurarTF.setEnabled(false);

        sexoEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sexoEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sexoEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        sexoEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        sexoEstagiarioProcurarTF.setEnabled(false);

        telefoneEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telefoneEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefoneEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        telefoneEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        telefoneEstagiarioProcurarTF.setEnabled(false);

        bairroEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bairroEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bairroEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        bairroEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        bairroEstagiarioProcurarTF.setEnabled(false);

        experienciasEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        experienciasEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        experienciasEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        experienciasEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        experienciasEstagiarioProcurarTF.setEnabled(false);

        formacaoAcademicaEstagiarioProcurarTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        formacaoAcademicaEstagiarioProcurarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formacaoAcademicaEstagiarioProcurarTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        formacaoAcademicaEstagiarioProcurarTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        formacaoAcademicaEstagiarioProcurarTF.setEnabled(false);

        javax.swing.GroupLayout jpInfoFunc2Layout = new javax.swing.GroupLayout(jpInfoFunc2);
        jpInfoFunc2.setLayout(jpInfoFunc2Layout);
        jpInfoFunc2Layout.setHorizontalGroup(
            jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFunc2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoFunc2Layout.createSequentialGroup()
                        .addComponent(jlSexoAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sexoEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlTelefoneAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefoneEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNivelEscolaridadeEstagiarioProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nivelEscolaridadelEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlBairroAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bairroEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFunc2Layout.createSequentialGroup()
                        .addComponent(jlEnderecoAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enderecoEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFunc2Layout.createSequentialGroup()
                        .addComponent(jlEmailAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlEstadoAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCidadeAlunoProcurar))
                    .addGroup(jpInfoFunc2Layout.createSequentialGroup()
                        .addComponent(jlNomeAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlCPFAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlIdadeAlunoProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idadeEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cidadeEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpInfoFunc2Layout.createSequentialGroup()
                                .addComponent(jlFormacaoAcademicaAlunoProcurar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formacaoAcademicaEstagiarioProcurarTF))
                            .addGroup(jpInfoFunc2Layout.createSequentialGroup()
                                .addComponent(jlExperienciasAlunoProcurar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(experienciasEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jpInfoFunc2Layout.setVerticalGroup(
            jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFunc2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNomeAlunoProcurar)
                    .addComponent(jlCPFAlunoProcurar)
                    .addComponent(jlIdadeAlunoProcurar)
                    .addComponent(cpfEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idadeEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSexoAlunoProcurar)
                    .addComponent(jlTelefoneAlunoProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNivelEscolaridadeEstagiarioProcurar)
                    .addComponent(nivelEscolaridadelEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBairroAlunoProcurar)
                    .addComponent(bairroEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEnderecoAlunoProcurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmailAlunoProcurar)
                    .addComponent(jlCidadeAlunoProcurar)
                    .addComponent(jlEstadoAlunoProcurar)
                    .addComponent(cidadeEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFormacaoAcademicaAlunoProcurar)
                    .addComponent(formacaoAcademicaEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlExperienciasAlunoProcurar)
                    .addComponent(experienciasEstagiarioProcurarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ProcurarCandidatoLayout = new javax.swing.GroupLayout(ProcurarCandidato.getContentPane());
        ProcurarCandidato.getContentPane().setLayout(ProcurarCandidatoLayout);
        ProcurarCandidatoLayout.setHorizontalGroup(
            ProcurarCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcurarCandidatoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProcurarCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpInfoFunc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpTabela1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcurarCandidatoLayout.createSequentialGroup()
                        .addComponent(jbOkProcurarEstagiario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelarProcurarAluno)
                        .addGap(38, 38, 38)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        ProcurarCandidatoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCancelarProcurarAluno, jbOkProcurarEstagiario});

        ProcurarCandidatoLayout.setVerticalGroup(
            ProcurarCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcurarCandidatoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jpInfoFunc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jpTabela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ProcurarCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbOkProcurarEstagiario)
                    .addComponent(jbCancelarProcurarAluno))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        ProcurarCandidatoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbCancelarProcurarAluno, jbOkProcurarEstagiario});

        setClosable(true);
        setIconifiable(true);
        setTitle("Preencher Vaga");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/information.png"))); // NOI18N

        jDesktopPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jDesktopPane1.setEnabled(false);

        jpTodasAsInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMAÇÕES QUE SERÃO SALVAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jpInfoempresa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sobre a Empresa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jlEnderecoEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEnderecoEmpresa.setText("Endereço da Empresa:");

        enderecoEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enderecoEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        enderecoEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        enderecoEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        enderecoEmpresaTF.setEnabled(false);

        jlTelefoneEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlTelefoneEmpresa.setText("Telefone da Empresa:");

        jlSiteEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlSiteEmpresa.setText("Site:");

        siteEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        siteEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        siteEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        siteEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        siteEmpresaTF.setEnabled(false);

        jlNomeEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNomeEmpresa.setText("Nome da Empresa:");

        nomeEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nomeEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nomeEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        nomeEmpresaTF.setEnabled(false);

        jbProcurarEmpresa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbProcurarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/zoom.png"))); // NOI18N
        jbProcurarEmpresa.setText("PROCURAR EMPRESA");
        jbProcurarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbProcurarEmpresa.setEnabled(false);
        jbProcurarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurarEmpresaActionPerformed(evt);
            }
        });

        telefoneEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telefoneEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefoneEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        telefoneEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        telefoneEmpresaTF.setEnabled(false);

        jlCNPJEmpresaProcurarLivro1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCNPJEmpresaProcurarLivro1.setText("CNPJ:");

        cnpjEmpresaTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cnpjEmpresaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnpjEmpresaTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        cnpjEmpresaTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        cnpjEmpresaTF.setEnabled(false);

        javax.swing.GroupLayout jpInfoempresaLayout = new javax.swing.GroupLayout(jpInfoempresa);
        jpInfoempresa.setLayout(jpInfoempresaLayout);
        jpInfoempresaLayout.setHorizontalGroup(
            jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoempresaLayout.createSequentialGroup()
                        .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlEnderecoEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoEmpresaTF))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlNomeEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlCNPJEmpresaProcurarLivro1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cnpjEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                                .addComponent(jlTelefoneEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefoneEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jpInfoempresaLayout.createSequentialGroup()
                        .addComponent(jlSiteEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siteEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbProcurarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        jpInfoempresaLayout.setVerticalGroup(
            jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoempresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNomeEmpresa)
                    .addComponent(jlCNPJEmpresaProcurarLivro1)
                    .addComponent(cnpjEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEnderecoEmpresa)
                    .addComponent(enderecoEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTelefoneEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoempresaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpInfoempresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSiteEmpresa)
                            .addComponent(siteEmpresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoempresaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jbProcurarEmpresa)
                        .addContainerGap())))
        );

        jpInfoFunc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do funcionário selecionado para vaga de estágio", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        nomeEstagiarioTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nomeEstagiarioTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeEstagiarioTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nomeEstagiarioTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        nomeEstagiarioTF.setEnabled(false);

        jlNomeAluno.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNomeAluno.setText("Nome do estagiário:");

        jlCpfAluno.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlCpfAluno.setText("CPF:");

        jlTelefoneAluno.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlTelefoneAluno.setText("Telefone:");

        jlIdadeAluno.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlIdadeAluno.setText("Idade:");

        jlEmailAluno.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlEmailAluno.setText("Email:");

        emailEstagiarioTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailEstagiarioTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailEstagiarioTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        emailEstagiarioTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        emailEstagiarioTF.setEnabled(false);

        idadeEstagiarioTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idadeEstagiarioTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idadeEstagiarioTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        idadeEstagiarioTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        idadeEstagiarioTF.setEnabled(false);

        telefoneEstagiarioTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telefoneEstagiarioTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefoneEstagiarioTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        telefoneEstagiarioTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        telefoneEstagiarioTF.setEnabled(false);

        cpfEstagiarioTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cpfEstagiarioTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpfEstagiarioTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        cpfEstagiarioTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        cpfEstagiarioTF.setEnabled(false);

        jbProcurarCandidato.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbProcurarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/zoom.png"))); // NOI18N
        jbProcurarCandidato.setText("PROCURAR CANDIDATO");
        jbProcurarCandidato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbProcurarCandidato.setEnabled(false);
        jbProcurarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurarCandidatoActionPerformed(evt);
            }
        });

        nivelEscolaridadeTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nivelEscolaridadeTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nivelEscolaridadeTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        nivelEscolaridadeTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        nivelEscolaridadeTF.setEnabled(false);

        jlNivelEscolaridade.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlNivelEscolaridade.setText("Nível de escolaridade:");

        javax.swing.GroupLayout jpInfoFuncLayout = new javax.swing.GroupLayout(jpInfoFunc);
        jpInfoFunc.setLayout(jpInfoFuncLayout);
        jpInfoFuncLayout.setHorizontalGroup(
            jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlNivelEscolaridade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nivelEscolaridadeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbProcurarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlNomeAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlCpfAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpfEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addComponent(jlIdadeAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idadeEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlTelefoneAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefoneEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlEmailAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailEstagiarioTF)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jpInfoFuncLayout.setVerticalGroup(
            jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNomeAluno)
                    .addComponent(jlCpfAluno)
                    .addComponent(cpfEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTelefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIdadeAluno)
                    .addComponent(idadeEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailEstagiarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmailAluno))
                .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbProcurarCandidato))
                    .addGroup(jpInfoFuncLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jpInfoFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivelEscolaridadeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNivelEscolaridade))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpInforPreContratacao.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        departamentoCB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        departamentoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administração" }));
        departamentoCB.setSelectedIndex(-1);
        departamentoCB.setEnabled(false);

        jbAddDepartamento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbAddDepartamento.setText("+");
        jbAddDepartamento.setToolTipText("Adicionar Departamento");
        jbAddDepartamento.setEnabled(false);
        jbAddDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddDepartamentoActionPerformed(evt);
            }
        });

        jlDepartamento.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlDepartamento.setText("Departamento:");

        jlSalarioMensal.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlSalarioMensal.setText("Salário Mensal: (R$)");

        salarioTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        salarioTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        salarioTF.setEnabled(false);

        jlDataAdmissao.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jlDataAdmissao.setText("Data de Admissão:");

        admissaoTF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        admissaoTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        admissaoTF.setEnabled(false);

        javax.swing.GroupLayout jpInforPreContratacaoLayout = new javax.swing.GroupLayout(jpInforPreContratacao);
        jpInforPreContratacao.setLayout(jpInforPreContratacaoLayout);
        jpInforPreContratacaoLayout.setHorizontalGroup(
            jpInforPreContratacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInforPreContratacaoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlDepartamento)
                .addGap(6, 6, 6)
                .addComponent(departamentoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAddDepartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlSalarioMensal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDataAdmissao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admissaoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInforPreContratacaoLayout.setVerticalGroup(
            jpInforPreContratacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInforPreContratacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpInforPreContratacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDepartamento)
                    .addComponent(departamentoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddDepartamento)
                    .addComponent(jlSalarioMensal)
                    .addComponent(salarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDataAdmissao)
                    .addComponent(admissaoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jpTodasAsInformacoesLayout = new javax.swing.GroupLayout(jpTodasAsInformacoes);
        jpTodasAsInformacoes.setLayout(jpTodasAsInformacoesLayout);
        jpTodasAsInformacoesLayout.setHorizontalGroup(
            jpTodasAsInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTodasAsInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTodasAsInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpInfoempresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInfoFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInforPreContratacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTodasAsInformacoesLayout.setVerticalGroup(
            jpTodasAsInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTodasAsInformacoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpInfoempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jpInfoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpInforPreContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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

        jbGerarPDF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbGerarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/interfaces/imagens/icones/page_white_excel.png"))); // NOI18N
        jbGerarPDF.setText("EXPORTAR .CSV");
        jbGerarPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbGerarPDF.setEnabled(false);
        jbGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jbNovo)
                .addGap(18, 18, 18)
                .addComponent(jbCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbGerarPDF)
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
                    .addComponent(jbGerarPDF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jpTodasAsInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpTodasAsInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jpTodasAsInformacoes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jpBotoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbOkProcurarEstagiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkProcurarEstagiarioActionPerformed
        try {
            nomeEstagiarioTF.setText(nomeEstagiarioProcurarTF.getText());
            idadeEstagiarioTF.setText(idadeEstagiarioProcurarTF.getText());
            cpfEstagiarioTF.setText(cpfEstagiarioProcurarTF.getText());
            telefoneEstagiarioTF.setText(telefoneEstagiarioProcurarTF.getText());
            emailEstagiarioTF.setText(emailEstagiarioProcurarTF.getText());
            nivelEscolaridadeTF.setText(nivelEscolaridadelEstagiarioProcurarTF.getText());
            ContratacaoDoEstagiario cde = new ContratacaoDoEstagiario();
            cde.setVisible(true);
            ProcurarCandidato.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContratacaoDoEstagiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbOkProcurarEstagiarioActionPerformed

    private void jbCancelarProcurarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarProcurarAlunoActionPerformed
        ProcurarCandidato.dispose();
    }//GEN-LAST:event_jbCancelarProcurarAlunoActionPerformed

    private void nomeEstagiarioProcurarTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeEstagiarioProcurarTFKeyReleased
        pesquisarEstagiario();
    }//GEN-LAST:event_nomeEstagiarioProcurarTFKeyReleased

    private void nomeProcurarEmpresaTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeProcurarEmpresaTFKeyReleased
        pesquisarEmpresa();
    }//GEN-LAST:event_nomeProcurarEmpresaTFKeyReleased

    private void TabelaProcurarEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProcurarEmpresaMouseClicked
        mostraEmpresa();
    }//GEN-LAST:event_TabelaProcurarEmpresaMouseClicked

    private void jbOkEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkEmpresaActionPerformed
        try {
            nomeEmpresaTF.setText(nomeProcurarEmpresaTF.getText());
            cnpjEmpresaTF.setText(cnpjProcurarEmpresaTF.getText());
            enderecoEmpresaTF.setText(enderecoProcurarEmpresaTF.getText());
            siteEmpresaTF.setText(siteProcurarEmpresaTF.getText());
            telefoneEmpresaTF.setText(telefoneProcurarEmpresaTF.getText());
            ContratacaoDoEstagiario cde = new ContratacaoDoEstagiario();
            cde.setVisible(true);
            ProcurarEmpresa.dispose();
            jbAtualizar.setEnabled(true);
            admissao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContratacaoDoEstagiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbOkEmpresaActionPerformed

    private void jbCancelarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarEmpresaActionPerformed
        ProcurarEmpresa.dispose();
    }//GEN-LAST:event_jbCancelarEmpresaActionPerformed

    private void jbAddDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddDepartamentoActionPerformed
        try {
            AdicionarDepartamento addDepartamento = new AdicionarDepartamento();
            jDesktopPane1.add(addDepartamento);
            addDepartamento.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContratacaoDoEstagiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAddDepartamentoActionPerformed

    private void jbProcurarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurarEmpresaActionPerformed
        ProcurarEmpresa.setVisible(true);
    }//GEN-LAST:event_jbProcurarEmpresaActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        atualizar();
        jbAtualizar.setEnabled(false);
        JOptionPane.showMessageDialog(this, "jComboBox atualizado!!", "", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jbLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbLimparCamposActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        cadastrarEmprego();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        ativarCampos();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbProcurarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurarCandidatoActionPerformed
        ProcurarCandidato.setVisible(true);
    }//GEN-LAST:event_jbProcurarCandidatoActionPerformed

    private void jbGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerarPDFActionPerformed
        geraCSV();
    }//GEN-LAST:event_jbGerarPDFActionPerformed

    private void ProcurarCandidatoWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ProcurarCandidatoWindowOpened
        ProcurarCandidato.setLocationRelativeTo(null);
        listarEstagiario();
    }//GEN-LAST:event_ProcurarCandidatoWindowOpened

    private void ProcurarEmpresaWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ProcurarEmpresaWindowOpened
        ProcurarEmpresa.setLocationRelativeTo(null);
        listarEmpresa();
    }//GEN-LAST:event_ProcurarEmpresaWindowOpened

    private void TabelaProcurarCandidatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProcurarCandidatoMouseClicked
        mostraCandidato();
    }//GEN-LAST:event_TabelaProcurarCandidatoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame ProcurarCandidato;
    private javax.swing.JFrame ProcurarEmpresa;
    private javax.swing.JTable TabelaProcurarCandidato;
    private javax.swing.JTable TabelaProcurarEmpresa;
    private javax.swing.JTextField admissaoTF;
    private javax.swing.JTextField bairroEstagiarioProcurarTF;
    private javax.swing.JTextField bairroProcurarEmpresaTF;
    private javax.swing.JTextField cidadeEstagiarioProcurarTF;
    private javax.swing.JTextField cidadeProcurarEmpresaTF;
    private javax.swing.JTextField cnpjEmpresaTF;
    private javax.swing.JTextField cnpjProcurarEmpresaTF;
    private javax.swing.JTextField cpfEstagiarioProcurarTF;
    private javax.swing.JTextField cpfEstagiarioTF;
    private javax.swing.JComboBox departamentoCB;
    private javax.swing.JTextField emailEstagiarioProcurarTF;
    private javax.swing.JTextField emailEstagiarioTF;
    private javax.swing.JTextField emailProcurarEmpresaTF;
    private javax.swing.JTextField enderecoEmpresaTF;
    private javax.swing.JTextField enderecoEstagiarioProcurarTF;
    private javax.swing.JTextField enderecoProcurarEmpresaTF;
    private javax.swing.JTextField estadoEstagiarioProcurarTF;
    private javax.swing.JTextField estadoProcurarEmpresaTF;
    private javax.swing.JTextField experienciasEstagiarioProcurarTF;
    private javax.swing.JTextField formacaoAcademicaEstagiarioProcurarTF;
    private javax.swing.JTextField idadeEstagiarioProcurarTF;
    private javax.swing.JTextField idadeEstagiarioTF;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAddDepartamento;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelarEmpresa;
    private javax.swing.JButton jbCancelarProcurarAluno;
    private javax.swing.JButton jbGerarPDF;
    private javax.swing.JButton jbLimparCampos;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbOkEmpresa;
    private javax.swing.JButton jbOkProcurarEstagiario;
    private javax.swing.JButton jbProcurarCandidato;
    private javax.swing.JButton jbProcurarEmpresa;
    private javax.swing.JLabel jlBairroAlunoProcurar;
    private javax.swing.JLabel jlBairroEmpresaProcurarLivro;
    private javax.swing.JLabel jlCNPJEmpresaProcurarLivro;
    private javax.swing.JLabel jlCNPJEmpresaProcurarLivro1;
    private javax.swing.JLabel jlCPFAlunoProcurar;
    private javax.swing.JLabel jlCidadeAlunoProcurar;
    private javax.swing.JLabel jlCidadeEmpresaProcurarLivro;
    private javax.swing.JLabel jlCpfAluno;
    private javax.swing.JLabel jlDataAdmissao;
    private javax.swing.JLabel jlDepartamento;
    private javax.swing.JLabel jlEmailAluno;
    private javax.swing.JLabel jlEmailAlunoProcurar;
    private javax.swing.JLabel jlEmailEmpresaProcurarLivro;
    private javax.swing.JLabel jlEnderecoAlunoProcurar;
    private javax.swing.JLabel jlEnderecoEmpresa;
    private javax.swing.JLabel jlEnderecoEmpresaProcurarLivro;
    private javax.swing.JLabel jlEstadoAlunoProcurar;
    private javax.swing.JLabel jlEstadoEmpresaProcurarLivro;
    private javax.swing.JLabel jlExperienciasAlunoProcurar;
    private javax.swing.JLabel jlFormacaoAcademicaAlunoProcurar;
    private javax.swing.JLabel jlIdadeAluno;
    private javax.swing.JLabel jlIdadeAlunoProcurar;
    private javax.swing.JLabel jlNivelEscolaridade;
    private javax.swing.JLabel jlNivelEscolaridadeEstagiarioProcurar;
    private javax.swing.JLabel jlNomeAluno;
    private javax.swing.JLabel jlNomeAlunoProcurar;
    private javax.swing.JLabel jlNomeEmpresa;
    private javax.swing.JLabel jlNomeEmpresaProcurarLivro;
    private javax.swing.JLabel jlSalarioMensal;
    private javax.swing.JLabel jlSexoAlunoProcurar;
    private javax.swing.JLabel jlSiteEmpresa;
    private javax.swing.JLabel jlSiteEmpresaProcurarLivro;
    private javax.swing.JLabel jlTelefoneAluno;
    private javax.swing.JLabel jlTelefoneAlunoProcurar;
    private javax.swing.JLabel jlTelefoneEmpresa;
    private javax.swing.JLabel jlTelefoneEmpresaProcurarLivro;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpInfoFunc;
    private javax.swing.JPanel jpInfoFunc2;
    private javax.swing.JPanel jpInfoempresa;
    private javax.swing.JPanel jpInfoempresa1;
    private javax.swing.JPanel jpInforPreContratacao;
    private javax.swing.JPanel jpTabela;
    private javax.swing.JPanel jpTabela1;
    private javax.swing.JPanel jpTodasAsInformacoes;
    private javax.swing.JTextField nivelEscolaridadeTF;
    private javax.swing.JTextField nivelEscolaridadelEstagiarioProcurarTF;
    private javax.swing.JTextField nomeEmpresaTF;
    private javax.swing.JTextField nomeEstagiarioProcurarTF;
    private javax.swing.JTextField nomeEstagiarioTF;
    private javax.swing.JTextField nomeProcurarEmpresaTF;
    private javax.swing.JTextField salarioTF;
    private javax.swing.JTextField sexoEstagiarioProcurarTF;
    private javax.swing.JTextField siteEmpresaTF;
    private javax.swing.JTextField siteProcurarEmpresaTF;
    private javax.swing.JTextField telefoneEmpresaTF;
    private javax.swing.JTextField telefoneEstagiarioProcurarTF;
    private javax.swing.JTextField telefoneEstagiarioTF;
    private javax.swing.JTextField telefoneProcurarEmpresaTF;
    // End of variables declaration//GEN-END:variables
}
