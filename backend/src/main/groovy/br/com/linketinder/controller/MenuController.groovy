package br.com.linketinder.controller

import br.com.linketinder.view.MenuEmpresaView
import br.com.linketinder.view.MenuInicialView
import br.com.linketinder.view.MenuCandidatoView
import br.com.linketinder.view.MenuVagaView

class MenuController {

    static MenuInicialView menuInicial = new MenuInicialView()
    static MenuCandidatoView menuCandidato = new MenuCandidatoView()
    static MenuEmpresaView menuEmpresa = new MenuEmpresaView()
    static MenuVagaView menuVaga = new MenuVagaView()

    void exibirMenuInicial(){
        menuInicial.iniciar()
    }

    void iniciarIteracaoCandidato(){
        menuCandidato.opcoesCandidato()
    }

    void iniciarIteracaoEmpresa(){
        menuEmpresa.opcoesEmpresa()
    }

    void iniciarIteracaoVaga(){
        menuVaga.opcoesVaga()
    }
}
