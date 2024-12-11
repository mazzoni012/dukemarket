package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gerencia a conexão com o banco de dados. Possui as instruções necessárias para 
 * conectar ao banco.
 * @author Gml
 */
public class MySQLConnection {
    
    // Define Strings de conexão com o banco.
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.16.0.30:3306/mvp_dukemarket";
    private static final String USER = "marcos";
    private static final String PASS = "senai";

    /**
     * Cria conexão com o banco de dados MySQL
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na Conexão com o BD. Verifique!", ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Falha na carga do DRIVER", ex);
        }
    }

    /**
     * Fecha a Conexão com o DB.
     * @param conn Conexão
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a Conexão com o DB.
     * @param conn Conexão
     * @param stmt Statement
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection(conn);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a Conexão com o DB.
     * @param conn Conexão
     * @param stmt Statement
     * @param rs ResultSet
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
