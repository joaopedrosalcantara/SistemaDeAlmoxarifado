/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.ItensCompradosModel;
import model.OrdemCompraModel;


/**
 *
 * @author Kinorth
 */
public class OrdemCompraController {
    

     public void inserir(int status){
        
        OrdemCompraModel ordemCompra = new OrdemCompraModel();
        ordemCompra.insertBanco(status);
    }
    
    public void editar(int id, int status){
        
        OrdemCompraModel ordemCompra = new OrdemCompraModel();
        ordemCompra.updateBanco(id, status);
    }
    public void deletar(int id){
        
        OrdemCompraModel ordemCompra = new OrdemCompraModel();
        ordemCompra.deleteBanco(id);
    }
    
    public List<OrdemCompraModel> listar(){
        List<OrdemCompraModel> listOrdemCompra = new ArrayList<>();
        OrdemCompraModel ordemCompra = new OrdemCompraModel();
        listOrdemCompra = ordemCompra.listar();
        return listOrdemCompra;
    }
    
    public OrdemCompraModel listarPedido(int id){
        OrdemCompraModel busca = new OrdemCompraModel();
        OrdemCompraModel ordemCompra;
        ordemCompra = busca.listarOrdemCompra(id);
        return ordemCompra;
    }
    
     public void inserirItem(int idPeca, int quantEntregue, int quantComprada, int idOrdemCompra){
        
        ItensCompradosModel itensComprados = new ItensCompradosModel();
        itensComprados.insertBanco(idPeca, quantEntregue, quantComprada, idOrdemCompra);
    }
    
    public void deletarItem(int id){
        
        ItensCompradosModel itensComprados = new ItensCompradosModel();
        itensComprados.deleteBanco(id);
    }
    
    public List<ItensCompradosModel> listarItem(int id){
        List<ItensCompradosModel> listItensComprados = new ArrayList<>();
        ItensCompradosModel itensComprados = new ItensCompradosModel();
        listItensComprados = itensComprados.listar(id);
        return listItensComprados;
    }

}
