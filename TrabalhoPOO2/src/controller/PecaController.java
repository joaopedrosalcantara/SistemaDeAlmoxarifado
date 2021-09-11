/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.PecaModel;

/**
 *
 *
 */
public class PecaController {
    
    
    public void inserir(float valor, String local, String upc){     
        PecaModel peca = new PecaModel();
        peca.insertBanco(valor, local, upc);
    }
    
    public void editar(int id, float valor, String local, String upc){
        
        PecaModel peca = new PecaModel();
        peca.updateBanco(id, valor, local, upc);
    }
    public void deletar(int id){
        
        PecaModel peca = new PecaModel();
        peca.deleteBanco(id);
    }
    
    public List<PecaModel> listar(){
        List<PecaModel> listPeca = new ArrayList<>();
        PecaModel peca = new PecaModel();
        listPeca = peca.listar();
        return listPeca;
    }
    
    public PecaModel listarPeca(int id){
        PecaModel busca = new PecaModel();
        PecaModel peca;
        peca = busca.listarPeca(id);
        return peca;
    }
    
    
}
