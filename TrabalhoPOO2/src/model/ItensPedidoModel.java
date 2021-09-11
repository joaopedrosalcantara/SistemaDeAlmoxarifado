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
public class ItensPedidoModel {
    
    private int id;
    private int idPedido;
    private int quant;
    private int idPeca;

    

    
    public ItensPedidoModel() {
        
    }
    public ItensPedidoModel(int id, int idPedido, int quant, int idPeca) {
        this.id = id;
        this.idPedido = idPedido;
        this.quant = quant;
        this.idPeca = idPeca;
    }

    
    public void insertItemPedidoBanco(int idPedido, int quant, int idPeca){
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO itens_pedido (ID_pedido, quant, ID_Peca) VALUES (?,?,?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idPedido);
            stmt.setInt(2, quant);
            stmt.setInt(3, idPeca);

            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateItemPedidoBanco(int id, int idPedido, int quant, int idPeca){
        try {
            // inserir codigo SQL aqui
            String query = "UPDATE itens_pedido SET ID_pedido=?, quant=?, ID_Peca=? WHERE ID_itens_pedido=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idPedido);
            stmt.setInt(2, quant);
            stmt.setInt(3, idPeca);
            stmt.setInt(4, id);
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   public void deleteItemPedidoBanco(int id){
        try {
            // inserir codigo SQL aqui
            String query = "DELETE FROM itens_pedido WHERE ID_itens_pedido=?;";
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
   
   public List listarItemPedido(int idQuery){
        
        List<ItensPedidoModel> listItensPedido = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM itens_pedido WHERE ID_pedido=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idQuery);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_itens_pedido");
                int idPedido = rs.getInt("ID_pedido");
                int quant = rs.getInt("quant");
                int idPeca = rs.getInt("ID_Peca");
                
                
                ItensPedidoModel itemPedido = new ItensPedidoModel(id, idPedido, quant, idPeca);
                listItensPedido.add(itemPedido);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listItensPedido;
    }
    
    
    public ItensPedidoModel listarUmPedido(int id){
        
        ItensPedidoModel itemPedido = new ItensPedidoModel();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM itens_pedido WHERE ID_itens_pedido=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            int idPedido = rs.getInt("ID_pedido");
            int quant = rs.getInt("quant");
            int idPeca = rs.getInt("ID_Peca");
            itemPedido = new ItensPedidoModel(id, idPedido, quant, idPeca);
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemPedido;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }


    
    
    
}
