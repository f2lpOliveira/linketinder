package br.com.linketinder.service

import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.model.entity.Vaga

class VagaService {

    VagaDAO vagaDAO = new VagaDAO()

    void setVagaDAO(Vaga vaga) {
        vagaDAO.dbCreate(vaga)
    }
}
