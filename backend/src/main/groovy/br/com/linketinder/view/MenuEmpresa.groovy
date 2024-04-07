package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.controller.EmpresaController
import br.com.linketinder.tools.Tools

class MenuEmpresa {

    CandidatoController candidatoController = new CandidatoController()
    EmpresaController empresaController = new EmpresaController()
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
1. Cadastrar
2. Listar Candidatos
3. Atualizar Cadastro
4. Excluir Cadastro
0. Voltar ao Menu Anterior
"""
    }
}
