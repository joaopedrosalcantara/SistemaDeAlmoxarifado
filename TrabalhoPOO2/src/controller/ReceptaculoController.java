/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import model.ReceptaculoModel;

/**
 *
 *
 */
public class ReceptaculoController {
    private int posicao;
    private int corredor;
    private static int quantMax = 50;

    public ReceptaculoController() {
        List<ReceptaculoModel> l = listar();
        if(l.size()>0){
            int pos = l.get(l.size()-1).getPosicao();
            int corr = l.get(l.size()-1).getCorredor();

            this.posicao = pos++;
            if(pos<10){
                this.corredor = corr+1;
            }else if(pos == 10){
                pos = 1;
            }
        }else{
          this.posicao = 1;
          this.corredor = 1;
        }
    }
    
    public void inserir(int idPeca){
        ReceptaculoModel receptaculo = new ReceptaculoModel();
        receptaculo.InserirBanco(idPeca, getPosicao(), getCorredor(),  0, quantMax);
    }
    
    public void editar(int id, int idPeca, int posicao, int corredor, int quantAtual){ 
        ReceptaculoModel receptaculo = new ReceptaculoModel();
        receptaculo.updateBanco(id, idPeca, posicao, corredor, quantAtual, quantMax);
    }
    public void deletar(int id){      
        ReceptaculoModel receptaculo = new ReceptaculoModel();
        receptaculo.deleteBanco(id);
    }
    
    public List<ReceptaculoModel> listar(){
        ReceptaculoModel receptaculo = new ReceptaculoModel();
        return receptaculo.listar();
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
    
}
