package br.com.linketinder.view

import br.com.linketinder.controller.CompetenciasController
import br.com.linketinder.controller.VagaController
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.model.factory.UsuarioFactory
import br.com.linketinder.tools.Tools

class InteracaoVagaView {

    VagaController vagaController = new VagaController()
    CompetenciasController competenciasController = new CompetenciasController()
    Tools tools = new Tools()

    void formularioCadastrarVaga() {

        print "\nDigite o nome da vaga: "
        String nome = tools.entradaDados()

        print "Digite o estado da vaga: "
        String estado = tools.entradaDados()

        print "Digite o CEP da vaga: "
        String cep = tools.entradaDados()

        print "Digite a descrição da vaga: "
        String descricao = tools.entradaDados()

        print "Digite as competências da vaga (separadas por vírgula): "
        List<String> competencias = Arrays.asList(tools.entradaDados().split(',')).collect { it.trim() }

        Vaga vaga = UsuarioFactory.criarVaga(nome, estado, cep, descricao, competencias)

        vagaController.setVagaDAO(vaga)
        competenciasController.setCompetenciasVaga(vaga)
        competenciasController.setAssociacaoCompetenciaVaga(vaga)

        println("Cadastro efetuado com sucesso!")
    }

    void opcaoCadastroEmpresaVaga() {
        print """
Deseja cadastrar uma vaga para essa empresa? (s/n):
"""
        String opcao = tools.entradaDados()

        if(opcao.equalsIgnoreCase("s")){
            print "\nDigite o nome da vaga: "
            String nome = tools.entradaDados()

            print "Digite o estado da vaga: "
            String estado = tools.entradaDados()

            print "Digite o cep da vaga: "
            String cep = tools.entradaDados()

            print "Digite a descricao da vaga: "
            String descricao = tools.entradaDados()

            print "Digite as competências da vaga (separadas por vírgula): "
            List<String> competencias = Arrays.asList(tools.entradaDados().split(',')).collect { it.trim() }

            Vaga vaga = UsuarioFactory.criarVaga(nome, estado, cep, descricao, competencias)

            vagaController.setVagaDAO(vaga)
            competenciasController.setCompetenciasVaga(vaga)
            competenciasController.setAssociacaoCompetenciaVaga(vaga)
        }
    }
}
