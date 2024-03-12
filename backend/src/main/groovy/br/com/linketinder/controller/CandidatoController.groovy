package br.com.linketinder.controller

import br.com.linketinder.model.CandidatoModel

class CandidatoController {

    void inserirCandidato(){
        new CandidatoModel().create()
    }

    void listarCandidatos(){
        new CandidatoModel().read()
    }

    void atualizarCandidato(){
        new CandidatoModel().update()
    }

    void excluirCandidato(){
        new CandidatoModel().delete()
    }
}
