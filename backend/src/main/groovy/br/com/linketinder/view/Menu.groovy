package br.com.linketinder.view

import br.com.linketinder.controller.Cadastro

class Menu {

    def cadastro = new Cadastro()

    void exibirMenu(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

        def opcao

        do {
            println("Escolha uma das opções a seguir:")
            println("1. Listar Todos os Candidatos")
            println("2. Listar Todas as Empresas")
            println("0. Sair")

            opcao = br.readLine()

            switch (opcao){
                case '1' :
                    cadastro.listarCandidatos()
                    break
                case '2' :
                    cadastro.listarEmpresas()
                    break
                case '0' :
                    println("Até logo!")
                    break
                default:
                    println("Opção Inválida. Tente novamente!")
                    break
            }
        } while (opcao != '0')
    }
}

