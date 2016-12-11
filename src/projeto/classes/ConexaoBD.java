package projeto.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBD {

    public static Connection conectadbd() throws ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ivagasnet", "postgres", "12345");
            /* Class.forName("com.mysql.jdbc.Driver");
             Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ivagasnet", "root","");
             */ /* JOptionPane.showMessageDialog(null, "Conectado com sucesso");
             */
            return conexao;
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
            
        }

    }
}