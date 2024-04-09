package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.controller.EmpresaController
import br.com.linketinder.controller.VagaController
import br.com.linketinder.tools.Tools

class MenuEmpresaView {

    CandidatoController candidatoController = new CandidatoController()
    EmpresaController empresaController = new EmpresaController()
    VagaController vagaController = new VagaController()
    Tools tools = new Tools()

    void opcoesEmpresa(){

        Boolean condicao = true

        while (condicao) {

            exibirOpcoesEmpresa()
            String opcao = tools.entradaDados()

            switch (opcao) {
                case '1':
                    empresaController.exibirFormularioCadastrarEmpresa()
                    break
                case '2':
                    candidatoController.listarCandidatos()
                    break
                case '3':
                    empresaController.exibirFormularioAtualizarEmpresa()
                    break
                case '4':
                    empresaController.exibirFormularioDeletarEmpresa()
                    break
                case '5':
                    vagaController.exibirFormularioCadastrarVaga()
                    break
                case '6':
                    vagaController.exibirFormularioAtualizarVaga()
                    break
                case '7':
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

    void exibirOpcoesEmpresa(){
        print """
Escolha uma das opções a seguir:
1. Cadastro
2. Listar Candidatos
3. Atualizar Cadastro
4. Excluir Cadastro
5. Cadastrar Vaga
6. Atualizar Vaga
7. Excluir Vaga
0. Voltar ao Menu Anterior
"""
    }
}
