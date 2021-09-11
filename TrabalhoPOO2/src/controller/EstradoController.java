/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.EstradoModel;

/**
 *
 * 
 */
public class EstradoController {
    
    public void inserir(){
        EstradoModel model = new EstradoModel();
        model.insertBanco();
    }
    
    public void editar(int id, int quantAtual){  
        EstradoModel model = new EstradoModel();    
        model.updateBanco(id, quantAtual);
    }
    public void deletar(int id){
        
        EstradoModel model = new EstradoModel();
        model.deleteBanco(id);
    }
    
    public List<EstradoModel> listar(){
        EstradoModel model = new EstradoModel();
        return model.listar();
    }
    
    
}
