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
 * 
 */
public class ReceptaculoModel {
        
    private int id;
    private int idPeca;
    private int posicao;
    private int corredor;
    private int quantAtual;
    private int quantMax;
    
    public ReceptaculoModel(){
        
    }

    public ReceptaculoModel(int id, int idPeca, int posicao, int corredor, int quantAtual, int quantMax) {
        this.id = id;
        this.idPeca = idPeca;
        this.posicao = posicao;
        this.corredor = corredor;
        this.quantAtual = quantAtual;
        this.quantMax = quantMax;
    }
    
    public void InserirBanco(int idPeca, int posicao, int corredor, int quantAtual, int quantMax){
        
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO receptaculo (ID_Peca, posicao, corredor, quantAtual, quantMax) VALUES (?, ?, ?, ?, ?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(1, idPeca);
            stmt.setInt(2, posicao);
            stmt.setInt(3, corredor);
            stmt.setInt(4, quantAtual);
            stmt.setInt(5, quantMax);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
           
    public void updateBanco(int id, int idPeca, int posicao, int corredor, int quantAtual, int quantMax){
        try {
            // inserir codigo SQL aqui
            String query = "UPDATE receptaculo SET ID_Peca=?, posicao=?, corredor=?, quantAtual=?, quantMax=? WHERE ID_receptaculo=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(6, id);
            stmt.setInt(1, idPeca);
            stmt.setInt(2, posicao);
            stmt.setInt(3, corredor);
            stmt.setInt(4, quantAtual);
            stmt.setInt(5, quantMax);
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
            String query = "DELETE FROM receptaculo WHERE ID_receptaculo=?;";
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
        
        List<ReceptaculoModel> listReceptaculo = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM receptaculo;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_receptaculo");
                int idPeca = rs.getInt("ID_Peca");
                int posicao = rs.getInt("posicao");
                int corredor = rs.getInt("corredor");
                int quantAtual = rs.getInt("quantAtual");
                int quantMax = rs.getInt("quantMax");
                ReceptaculoModel receptaculo = new ReceptaculoModel(id, idPeca, posicao, corredor, quantAtual, quantMax);
                listReceptaculo.add(receptaculo);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listReceptaculo;
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


    public int getQuantMax() {
        return quantMax;
    }

    public void setQuantMax(int quantMax) {
        this.quantMax = quantMax;
    }

    /**
     * @return the posicao
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * @param posicao the posicao to set
     */
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    /**
     * @return the corredor
     */
    public int getCorredor() {
        return corredor;
    }

    /**
     * @param corredor the corredor to set
     */
    public void setCorredor(int corredor) {
        this.corredor = corredor;
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
    
    
}
