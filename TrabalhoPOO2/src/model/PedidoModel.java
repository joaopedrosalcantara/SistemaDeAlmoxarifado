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
 * 
 */
public class PedidoModel {
    
    private int id;
    private int idCliente;

    

    
    public PedidoModel() {
        
    }
    public PedidoModel(int id, int idCliente) {
        this.id = id;
        this.idCliente = idCliente;
    }

    
    public void insertBanco(int idCliente){
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO pedido (ID_cliente) VALUES (?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idCliente);

            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBanco(int id, int idCliente){
        try {
            // inserir codigo SQL aqui
            String query = "UPDATE pedido SET ID_cliente=? WHERE ID_pedido=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idCliente);
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
            String query = "DELETE FROM pedido WHERE ID_pedido=?;";
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
        
        List<PedidoModel> listPedido = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM pedido;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_pedido");
                int idCliente = rs.getInt("ID_cliente");
                
                
                PedidoModel pedido = new PedidoModel(id, idCliente);
                listPedido.add(pedido);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPedido;
    }
    
    
    public PedidoModel listarPedido(int id){
        
        PedidoModel pedido = new PedidoModel();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM pedido WHERE ID_pedido=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            int idCliente = rs.getInt("ID_cliente");      
            pedido = new PedidoModel(id, idCliente);
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pedido;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
