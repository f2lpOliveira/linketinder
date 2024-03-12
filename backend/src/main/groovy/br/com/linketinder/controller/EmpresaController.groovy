package br.com.linketinder.controller

import br.com.linketinder.model.EmpresaModel

class EmpresaController {

    void inserirEmpresa(){
        new EmpresaModel().create()
    }

    void listarEmpresas(){
        new EmpresaModel().read()
    }

    void atualizarEmpresa(){
        new EmpresaModel().update()
    }

    void excluirEmpresa(){
        new EmpresaModel().delete()
    }
}
