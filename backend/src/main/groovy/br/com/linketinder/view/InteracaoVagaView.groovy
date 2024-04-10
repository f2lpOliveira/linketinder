package br.com.linketinder.view

import br.com.linketinder.controller.CompetenciasController
import br.com.linketinder.controller.VagaController
import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.model.factory.UsuarioFactory
import br.com.linketinder.tools.Tools

class InteracaoVagaView {

    VagaController vagaController = new VagaController()
    CompetenciasController competenciasController = new CompetenciasController()
    Tools tools = new Tools()

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
            competenciasController.associarCompetenciasVaga(vaga)
            competenciasController.setAssociacaoCompetenciaVaga(vaga)
        }
    }

    void listarVagas() {
        List<Vaga> vagas = new VagaDAO().dbRead()

        if (vagas.isEmpty()) {
            println "\nNão há vagas cadastrados."
        } else {
            print "\nCandidatos cadastrados:"
            vagas.each { vaga ->
                print """
Nome: ${vaga.nome}
Estado: ${vaga.estado}
CEP: ${vaga.cep}
Descrição: ${vaga.descricao}"""

                if (!vaga.competencias.empty) {
                    print """
Competências: ${vaga.competencias.collect { it }.join(', ')}"""
                } else {
                    println "Nenhuma competência cadastrada para este vaga."
                }
                println ""
            }
        }
    }
}
