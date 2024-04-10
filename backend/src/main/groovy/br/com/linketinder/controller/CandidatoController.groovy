package br.com.linketinder.controller

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.view.InteracaoCandidatoView

class CandidatoController {

    static InteracaoCandidatoView interacaoCandidatoView = new InteracaoCandidatoView()
    CandidatoDAO candidatoDAO = new CandidatoDAO()

    void exibirFormularioCadastrarCandidato() {
        interacaoCandidatoView.formularioCadastrarCandidato()
    }

    void listarCandidatos() {
        interacaoCandidatoView.listarCandidatos()
    }

    void exibirFormularioAtualizarCandidato() {
        interacaoCandidatoView.formularioAtualizarCandidato()
    }

    void exibirFormularioDeletarCandidato() {
        interacaoCandidatoView.deletarCandidato()
    }

    void inserirCandidatoDAO(Candidato candidato) {
        candidatoDAO.dbCreate(candidato)
    }

    List<Candidato> listarCandidatosDAO() {
        return candidatoDAO.dbRead()
    }

    void atualizarCandidatoDAO(String cpf, Candidato candidato) {
        candidatoDAO.dbUpdate(cpf, candidato)
    }

    boolean deletarCandidatoDAO(String cpf) {
        return candidatoDAO.dbDelete(cpf)
    }
}
