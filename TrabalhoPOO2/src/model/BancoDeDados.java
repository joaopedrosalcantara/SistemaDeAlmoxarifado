package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDeDados {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost";
    //private static final String URL = "jdbc:mysql://127.0.0.1/";
    private static final String PORT = "3306";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    private static final String BANCO = "trabalhopoo2";
    private static final String TIMEZONE = "useTimezone=true&serverTimezone=UTC";
    
    private Connection conn;
    private static BancoDeDados instance;

    public BancoDeDados() throws ClassNotFoundException, SQLException {
        String conexao = URL + ":" + PORT + "/" + BANCO + "?" + TIMEZONE;
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(conexao, USUARIO, SENHA);
    } 

    public static BancoDeDados getInstance() throws ClassNotFoundException, SQLException {
        
        if(instance == null)
            instance = new BancoDeDados();
        else if(instance.getConn().isClosed())
            instance = new BancoDeDados();
        
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

    public void realizarQuery(int um, float dois, String tres) {
      
        String query = "INSERT INTO peca (UPC, valorPeca, local) VALUES (?, ?, ?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, um);
            stmt.setFloat(2, dois);
            stmt.setString(3, tres);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
