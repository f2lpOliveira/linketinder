package br.com.linketinder.menuIterativo

import br.com.linketinder.cadastro.Cadastro

class Menu {
    def cadastro = new Cadastro()

    void exibirMenu() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean continuar = true

            while (continuar) {

                opcoesMenuInicial()
                String opcao = br.readLine()

                switch (opcao) {
                    case '1':
                        cadastro.listarCandidatos()
                        break
                    case '2':
                        cadastro.listarEmpresas()
                        break
                    case '0':
                        println("Até logo!")
                        continuar = false
                        break
                    default:
                        println("Opção Inválida. Tente novamente!")
                        break
                }
            }
        } catch (IOException e) {
            e.printStackTrace()
        }
    }

    void opcoesMenuInicial() {
        println("Escolha uma das opções a seguir:")
        println("1. Listar Todos os Candidatos")
        println("2. Listar Todas as Empresas")
        println("0. Sair")
    }
}