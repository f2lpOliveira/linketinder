package br.com.linketinder.controller

import br.com.linketinder.view.EmpresaView

class EmpresaController {

    void cadastrarEmpresa() {
        new EmpresaView().menuCadastrarEmpresa()
    }

    void listarEmpresas() {
        new EmpresaView().menuListarEmpresas()
    }

    void atualizarEmpresa() {
        new EmpresaView().menuAtualizarEmpresa()
    }

    void excluirEmpresa() {
        new EmpresaView().menuDeletarEmpresa()
    }
}
