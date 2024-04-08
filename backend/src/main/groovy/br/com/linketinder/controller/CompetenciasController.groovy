package br.com.linketinder.controller

import br.com.linketinder.dao.CompetenciasDAO
import br.com.linketinder.model.entity.Candidato

class CompetenciasController {

    CompetenciasDAO competenciasDAO = new CompetenciasDAO()

    void setCompetenciasCandidato (Candidato candidato) {
        competenciasDAO.inserirCompetenciasCandidato(candidato)
    }

    void setAssociacaoCompetenciaCandidato (Candidato candidato) {
        competenciasDAO.associarCompetenciasAoCandidato(candidato)
    }
}