package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.controller.VagaController
import br.com.linketinder.tools.Tools

class MenuCandidatoView {

    CandidatoController candidatoController = new CandidatoController()
    VagaController vagaController = new VagaController()
    Tools tools = new Tools()

    void opcoesCandidato(){

        Boolean condicao = true

        while (condicao) {

            exibirOpcoesCandidato()
            String opcao = tools.entradaDados()

            switch (opcao) {
                case '1':
                    candidatoController.exibirFormularioCadastrarCandidato()
                    break
                case '2':
                    vagaController.listarVagas()
                    break
                case '3':
                    candidatoController.exibirFormularioAtualizarCandidato()
                    break
                case '4':
                    candidatoController.exibirFormularioDeletarCandidato()
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

    void exibirOpcoesCandidato(){
        print """
Escolha uma das opções a seguir:
1. Cadastro
2. Listar Vagas
3. Atualizar Cadastro
4. Excluir Cadastro
0. Voltar ao Menu Anterior
"""
    }
}
