package br.com.linketinder.model

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato

class CandidatoModel {
    private CandidatoDAO candidatoDAO;

    CandidatoModel() {
        this.candidatoDAO = new CandidatoDAO();
    }
}
