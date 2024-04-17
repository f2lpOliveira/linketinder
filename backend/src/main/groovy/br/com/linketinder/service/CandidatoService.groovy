package br.com.linketinder.service

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato

class CandidatoService {

    CandidatoDAO candidatoDAO = new CandidatoDAO()

    void inserirCandidatoDAO(Candidato candidato) {
        candidatoDAO.dbCreate(candidato)
    }
}
