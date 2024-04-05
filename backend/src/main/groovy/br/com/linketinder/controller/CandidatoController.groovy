package br.com.linketinder.controller

import br.com.linketinder.model.CandidatoModel
import br.com.linketinder.view.CandidatoView

class CandidatoController {

    void cadastrarCandidato(){
        new CandidatoView().menuCadastrarCandidato()
    }

    void listarCandidatos(){
        new CandidatoView().menuListarCandidatos()
    }

    void atualizarCandidato(){
        new CandidatoModel().update()
    }

    void excluirCandidato(){
        new CandidatoModel().delete()
    }
}
