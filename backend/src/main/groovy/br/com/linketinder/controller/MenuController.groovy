package br.com.linketinder.controller

import br.com.linketinder.view.MenuEmpresa
import br.com.linketinder.view.MenuInicial
import br.com.linketinder.view.MenuCandidato

class MenuController {

    static MenuInicial menuInicial = new MenuInicial()
    static MenuCandidato menuCandidato = new MenuCandidato()
    static MenuEmpresa menuEmpresa = new MenuEmpresa()

    void exibirMenuInicial(){
        menuInicial.iniciar()
    }

    void iniciarIteracaoCandidato(){
        menuCandidato.opcoesCandidato()
    }

    void iniciarIteracaoEmpresa(){
        menuEmpresa.opcoesEmpresa()
    }
}
