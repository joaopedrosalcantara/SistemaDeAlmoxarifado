/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.PecasEstradoModel;

/**
 *
 * @author augus
 */
public class PecasEstradoController {
    public void inserir(int idEstrado, int quantPeca, int idPeca){
        PecasEstradoModel model = new PecasEstradoModel();
        model.insertBanco(idEstrado, quantPeca, idPeca);
        
    }
    public void editar(int id, int idEstrado, int quantPeca, int idPeca){
        PecasEstradoModel model = new PecasEstradoModel();
        model.updateBanco(id, idEstrado, quantPeca, idPeca);
    }
    public void deletar(int id){
        PecasEstradoModel model = new PecasEstradoModel();
        model.deleteBanco(id);
    }
    public List<PecasEstradoModel> listar(int id){
        PecasEstradoModel model = new PecasEstradoModel();
        return model.listarID(id);
    }
    public List<PecasEstradoModel> listarAll(){
        PecasEstradoModel model = new PecasEstradoModel();
        return model.listar();
    }
    public List<Integer> listIdPecas(){
        PecasEstradoModel model = new PecasEstradoModel();
        return model.listIdPecas();
    }
}
