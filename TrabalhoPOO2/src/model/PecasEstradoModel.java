/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augus
 */
public class PecasEstradoModel {
    private int idPE;
    private int idEstrado;
    private int quantPeca;
    private int idPeca;
    
    public PecasEstradoModel() {
    }
    public PecasEstradoModel(int id, int idEstr, int qtPeca, int peca) {
       this.idPE = id;
       this.idEstrado = idEstr;
       this.quantPeca = qtPeca;
       this.idPeca = peca;
    }
    
    public void insertBanco(int idEstrado, int quantPeca, int idPeca){
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO pecas_estrados (ID_estrado, quantPeca, ID_Peca) VALUES (?, ?, ?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idEstrado);
            stmt.setInt(2, quantPeca);
            stmt.setInt(3, idPeca);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void updateBanco(int idPE, int idEstrado, int quantPeca, int idPeca){
        try {
            String query = "UPDATE pecas_estrados SET ID_estrado=?, quantPeca=?, ID_Peca=? WHERE ID_pecaEstrado=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(4, idPE);
            stmt.setInt(1, idEstrado);
            stmt.setInt(2, quantPeca);
            stmt.setInt(3, idPeca);
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
            String query = "DELETE FROM pecas_estrados WHERE ID_pecaEstrado=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List listarID(int id){
        List<PecasEstradoModel> listPecas = new ArrayList();
        try {
            String query = "";
            if(id != 0) query = "SELECT * FROM pecas_estrados WHERE ID_estrado = ?;";
            else query = "SELECT * FROM pecas_estrados;";
            
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            if(id != 0) stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID_pecaEstrado");
                int idEstr = rs.getInt("ID_estrado");
                int qtPeca = rs.getInt("quantPeca");
                int peca = rs.getInt("ID_Peca");
                PecasEstradoModel estrado = new PecasEstradoModel(id, idEstr, qtPeca, peca);
                listPecas.add(estrado);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPecas;
    }

    public List listar(){
        return listarID(0);
    }
    
    public List listIdPecas(){
        List<Integer> listIdPecas = new ArrayList();
        try {
            String query = "SELECT ID_Peca FROM pecas_estrados GROUP BY ID_Peca;";
            
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int peca = rs.getInt("ID_Peca");
                listIdPecas.add(peca);
            }
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstradoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listIdPecas;
    }
    
    /**
     * @return the idPE
     */
    public int getIdPE() {
        return idPE;
    }

    /**
     * @param idPE the idPE to set
     */
    public void setIdPE(int idPE) {
        this.idPE = idPE;
    }

    /**
     * @return the idEstrado
     */
    public int getIdEstrado() {
        return idEstrado;
    }

    /**
     * @param idEstrado the idEstrado to set
     */
    public void setIdEstrado(int idEstrado) {
        this.idEstrado = idEstrado;
    }

    /**
     * @return the quantPeca
     */
    public int getQuantPeca() {
        return quantPeca;
    }

    /**
     * @param quantPeca the quantPeca to set
     */
    public void setQuantPeca(int quantPeca) {
        this.quantPeca = quantPeca;
    }

    /**
     * @return the idPeca
     */
    public int getIdPeca() {
        return idPeca;
    }

    /**
     * @param idPeca the idPeca to set
     */
    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }
}
