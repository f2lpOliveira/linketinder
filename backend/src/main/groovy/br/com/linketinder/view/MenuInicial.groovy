package br.com.linketinder.view

import br.com.linketinder.controller.MenuController
import br.com.linketinder.tools.Tools

class MenuInicial {

    MenuController menuController = new MenuController()
    Tools tools = new Tools()

    void iniciar() {

        Boolean condicao = true

        while (condicao){

            exibirOpcoesIniciais()
            String opcao = tools.entradaDados()

            switch (opcao) {
                case '1':
                    menuController.iniciarIteracaoCandidato()
                    break
                case '2':
                    menuController.iniciarIteracaoEmpresa()
                    break
                case '3':
                    menuController.iniciarIteracaoVaga()
                    break
                case '0':
                    println("\nAté logo!")
                    condicao = false
                    break
                default:
                    println("Opção Inválida. Tente novamente!")
                    break
            }
        }
    }

    void exibirOpcoesIniciais(){
        print """Escolha uma das opções a seguir:
1. Para Candidatos
2. Para Empresas
3. Para Vagas
0. Sair
"""
    }
}

