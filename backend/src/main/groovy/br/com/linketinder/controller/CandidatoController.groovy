package br.com.linketinder.controller

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.view.CandidatoView

class CandidatoController {

    static CandidatoView candidatoView = new CandidatoView()
    CandidatoDAO candidatoDAO = new CandidatoDAO()

    void exibirFormularioCadastrarCandidato() {
        candidatoView.formularioCadastrarCandidato()
    }

    void exibirFormularioListarCandidatos() {
        candidatoView.listarCandidatos()
    }

    void exibirFormularioAtualizarCandidato() {
        candidatoView.formularioAtualizarCandidato()
    }

    void exibirFormularioDeletarCandidato() {
        candidatoView.deletarCandidato()
    }

    void setCandidatoDAO(Candidato candidato) {
        candidatoDAO.dbCreate(candidato)
    }

    List<Candidato> getCandidatosDAO() {
        return candidatoDAO.dbRead()
    }

    void atualizarCandidatoDAO(String cpf, Candidato candidato) {
        candidatoDAO.dbUpdate(cpf, candidato)
    }

    boolean deletarCandidatoDAO(String cpf) {
        return candidatoDAO.dbDelete(cpf)
    }
}
