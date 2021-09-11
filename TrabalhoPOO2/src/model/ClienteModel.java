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
public class ClienteModel {
    
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String cnpj;

    public ClienteModel() {
        
    }
    public ClienteModel(int id, String nome, String telefone, String endereco, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public void insertBanco(String nome, String telefone, String endereco, String cnpj){
        
        try {
            // inserir codigo SQL aqui
            String query = "INSERT INTO cliente (nome, telefone, endereco, cnpj) VALUES (?, ?, ?, ?);";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, endereco);
            stmt.setString(4, cnpj);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void updateBanco(int id, String nome, String telefone, String endereco, String cnpj){
        try {
            // inserir codigo SQL aqui
            String query = "UPDATE cliente SET nome=?, telefone=?, endereco=?, cnpj=? WHERE ID_cliente=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            stmt.setInt(5, id);
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, endereco);
            stmt.setString(4, cnpj);
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
            String query = "DELETE FROM cliente WHERE ID_cliente=?;";
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
        
        List<ClienteModel> listCliente = new ArrayList<>();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM cliente;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID_cliente");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                String cnpj = rs.getString("cnpj");
                
                ClienteModel cliente = new ClienteModel(id, nome, telefone, endereco, cnpj);
                listCliente.add(cliente);
            }
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listCliente;
    }
    
    public ClienteModel listarCliente(int id){
        
        ClienteModel cliente = new ClienteModel();
        try {
            // inserir codigo SQL aqui
            String query = "SELECT * FROM cliente WHERE ID_cliente=?;";
            BancoDeDados conexao = new BancoDeDados();          
            PreparedStatement stmt = conexao.getConn().prepareStatement(query);
            //PecaModel pecas = stmt
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int idCliente = rs.getInt("ID_cliente");
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            String endereco = rs.getString("endereco");
            String cnpj = rs.getString("cnpj");
            
            cliente = new ClienteModel(idCliente, nome, telefone, endereco, cnpj);
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PecaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
