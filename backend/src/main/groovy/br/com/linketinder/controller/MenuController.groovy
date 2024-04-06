package br.com.linketinder.controller

import br.com.linketinder.view.EmpresaView
import br.com.linketinder.view.MenuInicial
import br.com.linketinder.view.MenuCandidato

class MenuController {

    void exibirMenuInicial(){
        new MenuInicial().iniciar()
    }

    void iniciarIteracaoCandidato(){
        new MenuCandidato().opcoesCandidato()
    }

    void iniciarIteracaoEmpresa(){
        new EmpresaView().menuOpcoesEmpresa()
    }
}
