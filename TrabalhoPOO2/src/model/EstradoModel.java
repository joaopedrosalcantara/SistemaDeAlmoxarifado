/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class EstradoModel {
    
    private int id;
    private int quantAtual;
    private int quantMax = 50;
    
    
    public EstradoModel() {
        
    }
    public EstradoModel(int id, int quantAtual, int quantMax) {
        this.id = id;
        this.quantAtual = quantAtual;
        this.quantMax = quantMax;
    }
   
    public void insertBanco(){
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO estrado (quantAtual, quantMax) VALUES (?, ?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, 50);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateBanco(int id, int quantAtual){
        try {
            // inserir codigo SQL aqui
            String query = "UPDATE estrado SET quantAtual=?, quantMax=? WHERE ID_estrado=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(3, id);
            stmt.setInt(1, quantAtual);
            stmt.setInt(2, 50);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteBanco(int id){
        try {
            // inserir codigo SQL aqui
            String query = "DELETE FROM estrado WHERE ID_estrado=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List listar(){
        
        List<EstradoModel> listEstrado = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM estrado;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_estrado");
                int qtAtual = rs.getInt("quantAtual");
                int qtMax = rs.getInt("quantMax");
                EstradoModel estrado = new EstradoModel(id, qtAtual, qtMax);
                listEstrado.add(estrado);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listEstrado;
    }
  
    public EstradoModel listarEstrado(int id){
        
        EstradoModel estrado = new EstradoModel();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM pecas_estrados WHERE ID_estrado=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();  
            int idEstrado = rs.getInt("ID_estrado");
            int qtAtual = rs.getInt("quantAtual");
            int qtMax = rs.getInt("quantMax");
            estrado = new EstradoModel(idEstrado, qtAtual, qtMax);
            stmt.close();    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estrado;
    }
    
    ////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the quantAtual
     */
    public int getQuantAtual() {
        return quantAtual;
    }

    /**
     * @param quantAtual the quantAtual to set
     */
    public void setQuantAtual(int quantAtual) {
        this.quantAtual = quantAtual;
    }

    /**
     * @return the quantMax
     */
    public int getQuantMax() {
        return quantMax;
    }

    /**
     * @param quantMax the quantMax to set
     */
    public void setQuantMax(int quantMax) {
        this.quantMax = quantMax;
    }
   
}
