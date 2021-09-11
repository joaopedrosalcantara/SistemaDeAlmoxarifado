/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.ItensPedidoModel;
import model.PedidoModel;


/**
 *
 * 
 */
public class PedidoController {
    
    public void inserir(int idCliente){
        
        PedidoModel pedido = new PedidoModel();
        pedido.insertBanco(idCliente);
    }
    
    public void editar(int id, int idCliente){
        
        PedidoModel pedido = new PedidoModel();
        pedido.updateBanco(id, idCliente);
    }
    public void deletar(int id){
        
        PedidoModel pedido = new PedidoModel();
        pedido.deleteBanco(id);
    }
    
    public List listar(){
        List<PedidoModel> listPedido = new ArrayList<>();
        PedidoModel cliente = new PedidoModel();
        listPedido = cliente.listar();
        return listPedido;
    }
    
    public PedidoModel listarPedido(int id){
        PedidoModel busca = new PedidoModel();
        PedidoModel pedido;
        pedido = busca.listarPedido(id);
        return pedido;
    }

    public void inserirItemPedido(int idPedido, int quant, int idPeca){
        
        ItensPedidoModel itemPedido = new ItensPedidoModel();
        itemPedido.insertItemPedidoBanco(idPedido, quant, idPeca);
    }
    
    public void editarItemPedido(int id, int idPedido, int quant, int idPeca){
        
        ItensPedidoModel itemPedido = new ItensPedidoModel();
        itemPedido.updateItemPedidoBanco(id, idPedido, quant, idPeca);
    }
    public void deletarItemPedido(int id){
        
        ItensPedidoModel itemPedido = new ItensPedidoModel();
        itemPedido.deleteItemPedidoBanco(id);
    }
    
    public List listarItemPedido(int id){
        List<ItensPedidoModel> listItemPedido = new ArrayList<>();
        ItensPedidoModel itemPedido = new ItensPedidoModel();
        listItemPedido = itemPedido.listarItemPedido(id);
        return listItemPedido;
    }
    
    public ItensPedidoModel listarPedidoItemPedido(int id){
        ItensPedidoModel busca = new ItensPedidoModel();
        ItensPedidoModel itemPedido;
        itemPedido = busca.listarUmPedido(id);
        return itemPedido;
    }
    
}
