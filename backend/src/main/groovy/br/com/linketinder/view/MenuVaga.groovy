package br.com.linketinder.view

import br.com.linketinder.controller.VagaController
import br.com.linketinder.tools.Tools

class MenuVaga {

    VagaController vagaController = new VagaController()
    Tools tools = new Tools()

    void opcoesVaga(){

        Boolean condicao = true

        while (condicao) {

            exibirOpcoesVaga()
            String opcao = tools.entradaDados()

            switch (opcao) {
                case '1':
                    vagaController.exibirFormularioCadastrarVaga()
                    break
                case '2':
                    empresaController.listarEmpresas()
                    break
                case '3':
                    vagaController.exibirFormularioAtualizarVaga()
                    break
                case '4':
                    vagaController.exibirFormularioDeletarVaga()
                    break
                case '0':
                    println ("")
                    condicao = false
                    break
                default:
                    println("Opção Inválida. Tente novamente!")
                    break
            }
        }
    }

    void exibirOpcoesVaga() {
        print """
Escolha uma das opções a seguir:
1. Cadastrar Vaga
2. Listar Vagas
3. Atualizar Vaga
4. Excluir Vaga
0. Voltar ao Menu Anterior
"""
    }
}
