/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
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
public class PecaModel {
    
    private int id;
    private float valor;
    private String local;
    private String upc;
    
    
    public PecaModel() {
        
    }
    public PecaModel(int id, float valor, String local, String upc) {
        this.id = id;
        this.valor = valor;
        this.local = local;
        this.upc = upc;
    }

   
    public void insertBanco(float valor, String local, String upc){
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO peca (valorPeca, local, UPC) VALUES (?, ?, ?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setFloat(1, valor);
            stmt.setString(2, local);
            stmt.setString(3, upc);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateBanco(int id, float valor, String local, String upc){
        try {
            // inserir codigo SQL aqui
            String query = "UPDATE peca SET valorPeca=?, local=?, UPC=? WHERE ID_Peca=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(4, id);
            stmt.setFloat(1, valor);
            stmt.setString(2, local);
            stmt.setString(3, upc);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteBanco(int id){
        try {
            // inserir codigo SQL aqui
            String query = "DELETE FROM peca WHERE ID_Peca=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            stmt.setFloat(1, id);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List listar(){
        
        List<PecaModel> listPeca = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM peca;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_Peca");
                float valorPeca = rs.getFloat("ValorPeca");
                String local = rs.getString("Local");
                String upc = rs.getString("UPC");
                PecaModel peca = new PecaModel(id, valorPeca, local, upc);
                listPeca.add(peca);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPeca;
    }
  
    
public PecaModel listarPeca(int id){
        
        PecaModel peca = new PecaModel();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM peca WHERE ID_Peca=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int idPeca = rs.getInt("ID_Peca");
            float valorPeca = rs.getFloat("ValorPeca");
            String local = rs.getString("Local");
            String upc = rs.getString("UPC");
            peca = new PecaModel(idPeca, valorPeca, local, upc);
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return peca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }
    

    
}
