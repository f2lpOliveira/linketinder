package br.com.linketinder.controller

import br.com.linketinder.view.CandidatoView

class CandidatoController {

    void cadastrarCandidato() {
        new CandidatoView().menuCadastrarCandidato()
    }

    void listarCandidatos() {
        new CandidatoView().menuListarCandidatos()
    }

    void atualizarCandidato() {
        new CandidatoView().menuAtualizarCandidato()
    }

    void excluirCandidato() {
        new CandidatoView().menuDeletarCandidato()
    }
}
