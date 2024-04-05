package br.com.linketinder.controller

import br.com.linketinder.model.CandidatoModel
import br.com.linketinder.view.CandidatoView

class CandidatoController {

    void cadastrarCandidato(){
        new CandidatoView().cadastrar()
    }

    void listarCandidatos(){
        new CandidatoView().listar()
    }

    void atualizarCandidato(){
        new CandidatoModel().update()
    }

    void excluirCandidato(){
        new CandidatoModel().delete()
    }
}
