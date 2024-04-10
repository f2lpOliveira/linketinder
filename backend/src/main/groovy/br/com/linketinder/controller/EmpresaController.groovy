package br.com.linketinder.controller

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.view.InteracaoEmpresaView

class EmpresaController {

    static InteracaoEmpresaView empresaView = new InteracaoEmpresaView()
    EmpresaDAO empresaDAO = new EmpresaDAO()

    void exibirFormularioCadastrarEmpresa() {
        empresaView.formularioCadastrarEmpresa()
    }

    void exibirFormularioAtualizarEmpresa() {
        empresaView.formularioAtualizarEmpresa()
    }

    void exibirFormularioDeletarEmpresa() {
        empresaView.deletarEmpresa()
    }

    void inserirEmpresaDAO(Empresa empresa) {
        empresaDAO.dbCreate(empresa)
    }

    void atualizarEmpresaDAO(String cnpj, Empresa empresa) {
        empresaDAO.dbUpdate(cnpj, empresa)
    }

    boolean deletarEmpresaDAO(String cnpj) {
        return empresaDAO.dbDelete(cnpj)
    }
}
