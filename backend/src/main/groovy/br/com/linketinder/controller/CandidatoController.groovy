package br.com.linketinder.controller

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.view.CandidatoView

class CandidatoController {

    void exibirFormularioCadastrarCandidato() {
        new CandidatoView().formularioCadastrarCandidato()
    }

    void exibirFormularioListarCandidatos() {
        new CandidatoView().listarCandidatos()
    }

    void exibirFormularioAtualizarCandidato() {
        new CandidatoView().formularioAtualizarCandidato()
    }

    void exibirFormularioDeletarCandidato() {
        new CandidatoView().deletarCandidato()
    }

    void setCandidatoDAO(candidato) {
        new CandidatoDAO().dbCreate(candidato)
    }

    List<Candidato> getCandidatosDAO() {
        return new CandidatoDAO().dbRead()
    }

    void atualizarCandidatoDAO(cpf, candidato) {
        new CandidatoDAO().dbUpdate(cpf, candidato)
    }

    boolean deletarCandidatoDAO(cpf) {
       return new CandidatoDAO().dbDelete(cpf)
    }
}
