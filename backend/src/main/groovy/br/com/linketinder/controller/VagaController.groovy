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

    void exibirFormularioAtualizarVaga() {
        vagaView.formularioAtualizarVaga()
    }

    void exibirFormularioDeletarVaga() {
        vagaView.deletarVaga()
    }

    void exibirFormularioCadastrarVagaEmpresa() {
       vagaView.opcaoCadastroEmpresaVaga()
    }

    void setVagaDAO(Vaga vaga) {
        vagaDAO.dbCreate(vaga)
    }

    List<Vaga> getVagasDAO() {
        return vagaDAO.dbRead()
    }

    void atualizarVagaDAO() {
        vagaDAO.dbUpdate()
    }

    boolean deletarVagaDAO() {
        return vagaDAO.dbDelete()
    }
}
