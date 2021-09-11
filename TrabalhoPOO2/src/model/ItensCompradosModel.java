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
public class ItensCompradosModel {
    
    private int id;
    private int idPeca;
    private int quantEntregue;
    private int quantComprada;
    private int idOrdemCompra;
    
    public ItensCompradosModel() {
        
    }

    public ItensCompradosModel(int id, int idPeca, int quantEntregue, int quantComprada, int idOrdemCompra) {
        this.id = id;
        this.idPeca = idPeca;
        this.quantEntregue = quantEntregue;
        this.quantComprada = quantComprada;
        this.idOrdemCompra = idOrdemCompra;
    }
    
    
    public void insertBanco(int idPeca, int quantEntregue, int quantComprada, int idOrdemCompra){
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO itens_comprados (ID_Peca, quant_entregue_total, quant_compra, ID_OrdemCompra) VALUES (?,?,?,?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idPeca);
            stmt.setInt(2, quantEntregue);
            stmt.setInt(3, quantComprada);
            stmt.setInt(4, idOrdemCompra);

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
            String query = "DELETE FROM itens_comprados WHERE ID_itens_comprados=?;";
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
   
   public List listar(int idQuery){
        
        List<ItensCompradosModel> listItensComprados = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM itens_comprados WHERE ID_OrdemCompra=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setFloat(1, idQuery);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_itens_comprados");
                int idPeca = rs.getInt("ID_Peca");
                int quantEntregue = rs.getInt("quant_entregue_total");
                int quantComprada = rs.getInt("quant_compra");
                int idOrdemCompra = rs.getInt("ID_OrdemCompra");
                
             
                ItensCompradosModel ordemCompra = new ItensCompradosModel(id, idPeca, quantEntregue, quantComprada, idOrdemCompra);
                listItensComprados.add(ordemCompra);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listItensComprados;
    }
    


  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getQuantEntregue() {
        return quantEntregue;
    }

    public void setQuantEntregue(int quantEntregue) {
        this.quantEntregue = quantEntregue;
    }

    public int getQuantComprada() {
        return quantComprada;
    }

    public void setQuantComprada(int quantComprada) {
        this.quantComprada = quantComprada;
    }

    public int getIdOrdemCompra() {
        return idOrdemCompra;
    }

    public void setIdOrdemCompra(int idOrdemCompra) {
        this.idOrdemCompra = idOrdemCompra;
    }


    
    
    
}
