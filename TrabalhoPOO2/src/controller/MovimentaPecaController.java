/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import model.EstradoModel;
import model.ItensCompradosModel;
import model.PecasEstradoModel;
import model.ReceptaculoModel;

/**
 *
 * @author augus
 */
public class MovimentaPecaController {
    private static EstradoController estradoController = new EstradoController();
    private static PecasEstradoController pecasEstradoController = new PecasEstradoController();;
    private static OrdemCompraController ordemCompraController = new OrdemCompraController();;
    private static ReceptaculoController receptaculoController = new ReceptaculoController();
    
    public static void preencherEstrados(int ordemCompra){ 
        if(estradoController.listar().size() == 0) estradoController.inserir();
        
        List<EstradoModel> estrados = estradoController.listar();
        EstradoModel estrado = estrados.get(estrados.size()-1);
        int quantAtual = estrado.getQuantAtual();
        
        
        for(ItensCompradosModel pecas: ordemCompraController.listarItem(ordemCompra)){
            if((quantAtual+pecas.getQuantEntregue())<=50){
                quantAtual+=pecas.getQuantEntregue();
                estradoController.editar(estrado.getId(), quantAtual);
                pecasEstradoController.inserir(estrado.getId(), pecas.getQuantEntregue(), pecas.getIdPeca());
            }else{
                estradoController.inserir();
                estrados = estradoController.listar();
                estrado = estrados.get(estrados.size()-1);
                quantAtual = pecas.getQuantEntregue();
                
                estradoController.editar(estrado.getId(), quantAtual);
                pecasEstradoController.inserir(estrado.getId(), pecas.getQuantEntregue(), pecas.getId());
            }
        }
        
        ordemCompraController.editar(ordemCompra, 3);
    }
    
    public static void esvaziarEstrados(){
        // verifica se existe os tipos de receptaculos necessarios
        for(int idPeca : pecasEstradoController.listIdPecas()){
            // se não existe cria
            if(buscaTipoReceptac(idPeca) == -1) receptaculoController.inserir(idPeca);
        }
        
        // Move todas as peças para receptáculos
        for(ReceptaculoModel recep : receptaculoController.listar()){
            for(PecasEstradoModel pecas : pecasEstradoController.listarAll()){
                if(recep.getIdPeca() == pecas.getIdPeca()){
                    int atual = recep.getQuantAtual() + pecas.getQuantPeca();
                    receptaculoController.editar(recep.getId(), recep.getIdPeca(),recep.getPosicao(),recep.getCorredor(), 
                            atual);
                    recep.setQuantAtual(atual);
                    // remove a PE do banco
                    pecasEstradoController.deletar(pecas.getIdPE());
                }
            }
        }      
        // Limpa os estrados
        for(EstradoModel estrado : estradoController.listar()){
            estradoController.editar(estrado.getId(), 0);
        }
    }
    
    public static int buscaTipoReceptac(int idPeca){
        for(ReceptaculoModel recep : receptaculoController.listar()){
            if(recep.getIdPeca() == idPeca) return recep.getId();
        }
        return -1;
    }
    
}
