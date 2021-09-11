/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kinorth
 */
public class OrdemCompraModel {
    
    private int id;
    private int status;
    
    public OrdemCompraModel() {
       
    }

    public OrdemCompraModel(int id, int status) {
        this.id = id;
        this.status = status;
    }
    
    
    public void insertBanco(int status){
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO ordem_compra (status) VALUES (?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, status);

            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBanco(int id, int status){
        try {
            // inserir codigo SQL aqui
            String query = "UPDATE ordem_compra SET status=? WHERE ID_Ordem_compra=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, status);
            stmt.setInt(2, id);
            
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
            String query = "DELETE FROM ordem_compra WHERE ID_Ordem_compra=?;";
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
        
        List<OrdemCompraModel> listOrdemCompra = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM ordem_compra;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_Ordem_compra");
                int status = rs.getInt("status");
                
                
                OrdemCompraModel ordemCompra = new OrdemCompraModel(id, status);
                listOrdemCompra.add(ordemCompra);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listOrdemCompra;
    }
    
    
    public OrdemCompraModel listarOrdemCompra(int id){
        
        OrdemCompraModel ordemCompra = new OrdemCompraModel();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM ordem_compra WHERE ID_Ordem_compra=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            int status = rs.getInt("status");      
            ordemCompra = new OrdemCompraModel(id, status);
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ordemCompra;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
