package br.com.linketinder.controller

import br.com.linketinder.view.MenuEmpresaView
import br.com.linketinder.view.MenuInicialView
import br.com.linketinder.view.MenuCandidatoView

class MenuController {

    static MenuInicialView menuInicialView = new MenuInicialView()
    static MenuCandidatoView menuCandidatoView = new MenuCandidatoView()
    static MenuEmpresaView menuEmpresaView = new MenuEmpresaView()

    void exibirMenuInicial(){
        menuInicialView.iniciar()
    }

    void iniciarIteracaoCandidato(){
        menuCandidatoView.opcoesCandidato()
    }

    void iniciarIteracaoEmpresa(){
        menuEmpresaView.opcoesEmpresa()
    }
}
