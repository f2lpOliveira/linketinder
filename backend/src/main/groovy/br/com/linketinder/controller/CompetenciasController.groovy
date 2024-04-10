package br.com.linketinder.controller

import br.com.linketinder.dao.CompetenciasDAO
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.model.entity.Vaga

class CompetenciasController {

    CompetenciasDAO competenciasDAO = new CompetenciasDAO()

    void inserirCompetenciasCandidato(Candidato candidato) {
        competenciasDAO.inserirCompetenciasCandidato(candidato)
    }

    void associarCompetenciaCandidato(Candidato candidato) {
        competenciasDAO.associarCompetenciasAoCandidato(candidato)
    }

    void atualizarCompetenciasCandidato (Integer empid, List<String> competencias) {
        competenciasDAO.atualizarCompetencias(empid, competencias)
    }

    void removerCompetenciasCandidato (Integer empid) {
        competenciasDAO.removerCompetenciasCandidato(empid)
    }

    void associarCompetenciasVaga(Vaga vaga) {
        competenciasDAO.inserirCompetenciasVaga(vaga)
    }

    void setAssociacaoCompetenciaVaga (Vaga vaga) {
        competenciasDAO.associarCompetenciasVaga(vaga)
    }
}