package br.com.linketinder.view

import br.com.linketinder.controller.EmpresaController
import br.com.linketinder.controller.VagaController
import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.tools.Tools

class EmpresaView {

    EmpresaController empresaController = new EmpresaController()
    VagaController vagaController = new VagaController()
    Tools tools = new Tools()

    void formularioCadastrarEmpresa() {

        print "\nDigite o nome da empresa: "
        String nome = tools.entradaDados()

        print "Digite o email da empresa: "
        String email = tools.entradaDados()

        print "Digite o CNPJ da empresa: "
        String cnpj = tools.entradaDados()

        print "Digite o país da empresa: "
        String pais = tools.entradaDados()

        print "Digite o estado da empresa: "
        String estado = tools.entradaDados()

        print "Digite o CEP da empresa: "
        String cep = tools.entradaDados()

        print "Digite a descrição da empresa: "
        String descricao = tools.entradaDados()

        Empresa empresa = new Empresa(nome, email, cnpj, pais, estado, cep, descricao)

        vagaController.exibirFormularioCadastrarVagaEmpresa()

        empresaController.setEmpresaDAO(empresa)

        println("Cadastro efetuado com sucesso!")
    }

    void listarEmpresas() {
        List<Empresa> empresas = empresaController.getEmpresasDAO()

        if (empresas.isEmpty()) {
            println "\nNão há empresas cadastradas."
        } else {
            print "\nEmpresas cadastradas:"
            empresas.each { empresa ->
                print """
Empresa: ${empresa.nome}
Email: ${empresa.email}
CNPJ: ${empresa.cnpj}
Pais: ${empresa.pais}
Estado: ${empresa.estado}
CEP: ${empresa.cep}
Descrição da Empresa: ${empresa.descricao}
"""

            }
        }
    }

    void formularioAtualizarEmpresa() {

        print "\nDigite o CNPJ da empresa que deseja atualizar: "
        String cnpj = tools.entradaDados()

        print "Confirme o nome da empresa: "
        String nome = tools.entradaDados()

        print "Digite o novo email da empresa: "
        String email = tools.entradaDados()

        print "Digite o novo país da empresa: "
        String pais = tools.entradaDados()

        print "Digite o novo estado da empresa: "
        String estado = tools.entradaDados()

        print "Digite o novo CEP da empresa: "
        String cep = tools.entradaDados()

        print "Digite a nova descrição da empresa: "
        String descricao = tools.entradaDados()

        Empresa empresa = new Empresa(nome, email, cnpj, pais, estado, cep, descricao)

        empresaController.atualizarEmpresaDAO(cnpj, empresa)

        println("\nEmpresa atualizada com sucesso!")
    }

    void deletarEmpresa() {

        print "\nDigite o CNPJ da empresa que deseja deletar: "
        String cnpj = tools.entradaDados()

        boolean empresaDeletada = empresaController.deletarEmpresaDAO(cnpj)

        if (empresaDeletada){
            println("Cadastro removido com sucesso!")
        } else {
            println("\nNenhuma empresa encontrada com o CNPJ fornecido.")
        }
    }
}
