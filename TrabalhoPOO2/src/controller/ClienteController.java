/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.ClienteModel;

/**
 *
 * 
 */
public class ClienteController {
    
    public void inserir(String nome, String telefone, String endereco, String cnpj){
        
        ClienteModel cliente = new ClienteModel();
        cliente.insertBanco(nome, telefone, endereco, cnpj);
    }
    
    public void editar(int id, String nome, String telefone, String endereco, String cnpj){
        
        ClienteModel cliente = new ClienteModel();
        cliente.updateBanco(id, nome, telefone, endereco, cnpj);
    }
    public void deletar(int id){
        
        ClienteModel cliente = new ClienteModel();
        cliente.deleteBanco(id);
    }
    
    public List listar(){
        List<ClienteModel> listCliente = new ArrayList<>();
        ClienteModel cliente = new ClienteModel();
        listCliente = cliente.listar();
        return listCliente;
    }
    
    public ClienteModel listarCliente(int id){
        ClienteModel busca = new ClienteModel();
        ClienteModel cliente;
        cliente = busca.listarCliente(id);
        return cliente;
    }
    
    
}
