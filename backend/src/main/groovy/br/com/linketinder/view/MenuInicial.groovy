package br.com.linketinder.view

import br.com.linketinder.controller.MenuController

class MenuInicial {

    MenuController menuController = new MenuController()

    void iniciar() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        Boolean condicao = true

        while (condicao){

            exibirOpcoes()
            String opcao = br.readLine()

            switch (opcao) {
                case '1':
                    menuController.iniciarIteracaoCandidato()
                    break
                case '2':
                    new EmpresaView().menu()
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

    void exibirOpcoes(){
        println("Escolha uma das opções a seguir:")
        println("1. Para Candidatos")
        println("2. Para Empresas")
        println("0. Sair")
    }
}

