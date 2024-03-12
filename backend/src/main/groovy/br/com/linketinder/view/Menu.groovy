package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.model.Cadastro

class Menu {

    void iniciarMenu(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

        def opcao

        do {
            println("Escolha uma das opções a seguir:")
            println("1. Listar Todos os Candidatos")
            println("2. Listar Todas as Empresas")
            println("3. Cadastrar Candidato")
            println("4. Atualizar Candidato")
            println("5. Excluir Candidato")
            println("0. Sair")

            opcao = br.readLine()

            switch (opcao){
                case '1' :
                    new CandidatoController().listarCandidatos()
                    break
                case '2' :
                    new Cadastro().listarEmpresas()
                    break
                case '3' :
                    new CandidatoController().inserirCandidato()
                    break
                case '4' :
                    new CandidatoController().atualizarCandidato()
                    break
                case '5' :
                    new CandidatoController().excluirCandidato()
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

