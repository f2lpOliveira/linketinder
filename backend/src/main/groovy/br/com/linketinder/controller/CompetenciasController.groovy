package br.com.linketinder.controller

import br.com.linketinder.dao.CompetenciasDAO
import br.com.linketinder.model.entity.Candidato

class CompetenciasController {

    CompetenciasDAO competenciasDAO = new CompetenciasDAO()

    void getCompetenciasCandidato (String cpf) {
        competenciasDAO.getCompetenciasCandidato(cpf)
    }

    void listarCompetenciasCandidato (Integer empid) {
        competenciasDAO.listarCompetenciasCandidato(empid)
    }

    void removerCompetenciasCandidato (Integer empid) {
        competenciasDAO.removerCompetencias(empid)
    }

    void atualizarCompetenciasCandidato (Integer empid, List<String> competencias) {
        competenciasDAO.removerCompetencias(empid, competencias)
    }

    void setCompetenciasCandidato (Candidato candidato) {
        competenciasDAO.inserirCompetenciasCandidato(candidato)
    }

    void setAssociacaoCompetenciaCandidato (Candidato candidato) {
        competenciasDAO.associarCompetenciasAoCandidato(candidato)
    }
}