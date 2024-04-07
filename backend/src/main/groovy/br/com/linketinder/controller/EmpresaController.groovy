package br.com.linketinder.controller

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.view.EmpresaView

class EmpresaController {

    static EmpresaView empresaView = new EmpresaView()
    EmpresaDAO empresaDAO = new EmpresaDAO()

    void exibirFormularioCadastrarEmpresa() {
        empresaView.formularioCadastrarEmpresa()
    }

    void listarEmpresas() {
        empresaView.listarEmpresas()
    }

    void exibirFormularioAtualizarEmpresa() {
        empresaView.formularioAtualizarEmpresa()
    }

    void exibirFormularioDeletarEmpresa() {
        empresaView.deletarEmpresa()
    }

    void setEmpresaDAO(Empresa empresa) {
        empresaDAO.dbCreate(empresa)
    }

    List<Empresa> getEmpresasDAO() {
        return empresaDAO.dbRead()
    }

    void atualizarEmpresaDAO(String cnpj, Empresa empresa) {
        empresaDAO.dbUpdate(cnpj, empresa)
    }

    boolean deletarEmpresaDAO(String cnpj) {
        return empresaDAO.dbDelete(cnpj)
    }
}
