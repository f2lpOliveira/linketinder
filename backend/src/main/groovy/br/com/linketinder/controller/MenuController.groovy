package br.com.linketinder.controller

import br.com.linketinder.view.CandidatoView
import br.com.linketinder.view.EmpresaView
import br.com.linketinder.view.MenuInicial

class MenuController {

    void iniciarIteracaoPrincipal(){
        new MenuInicial().iniciar()
    }

    void iniciarIteracaoCandidato(){
        new CandidatoView().menuOpcoesCandidato()
    }

    void iniciarIteracaoEmpresa(){
        new EmpresaView().menuOpcoesEmpresa()
    }
}
