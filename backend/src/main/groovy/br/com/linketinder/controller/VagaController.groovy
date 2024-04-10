package br.com.linketinder.controller

import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.view.InteracaoVagaView

class VagaController {

    static InteracaoVagaView vagaView = new InteracaoVagaView()
    VagaDAO vagaDAO = new VagaDAO()

    void exibirFormularioCadastrarVaga() {
        vagaView.formularioCadastrarVaga()
    }

    void listarVagas() {
        vagaView.listarVagas()
    }

    void exibirFormularioCadastrarVagaEmpresa() {
       vagaView.opcaoCadastroEmpresaVaga()
    }

    void setVagaDAO(Vaga vaga) {
        vagaDAO.dbCreate(vaga)
    }
}
