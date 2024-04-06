package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.tools.Tools

class CandidatoView {

    CandidatoController candidatoController = new CandidatoController()
    Tools tools = new Tools()

    void formularioCadastrarCandidato() {

        print "\nDigite o nome do candidato: "
        String nome = tools.entradaDados()

        print "Digite o email do candidato: "
        String email = tools.entradaDados()

        print "Digite o CPF do candidato: "
        String cpf = tools.entradaDados()

        print "Digite a idade do candidato: "
        String idadeStr = tools.entradaDados()
        int idade = Integer.parseInt(idadeStr)

        print "Digite o estado do candidato: "
        String estado = tools.entradaDados()

        print "Digite o CEP do candidato: "
        String cep = tools.entradaDados()

        print "Digite a descrição do candidato: "
        String descricao = tools.entradaDados()

        print "Digite as competências do candidato (separadas por vírgula): "
        List<String> competencias = tools.entradaDados().split(',').collect { it.trim() }

        Candidato candidato = new Candidato(nome, email, cpf, idade, estado, cep, descricao, competencias)

        candidatoController.setCandidatoDAO(candidato)

        println("Cadastro efetuado com sucesso!")
    }

    void listarCandidatos() {
        List<Candidato> candidatos = candidatoController.getCandidatosDAO()

        if (candidatos.isEmpty()) {
            println "\nNão há candidatos cadastrados."
        } else {
            print "\nCandidatos cadastrados:"
            candidatos.each { candidato ->
                print """
Nome: ${candidato.nome}
Email: ${candidato.email}
CPF: ${candidato.cpf}
Idade: ${candidato.idade}
Estado: ${candidato.estado}
CEP: ${candidato.cep}
Descrição Pessoal: ${candidato.descricao}"""

                if (!candidato.competencias.empty) {
                    print """
Competências: ${candidato.competencias.collect { it }.join(', ')}"""
                } else {
                    println "Nenhuma competência cadastrada para este candidato."
                }
                println ""
            }
        }
    }

    void formularioAtualizarCandidato(){

        print "\nDigite seu CPF para atualizar seu cadastro: "
        String cpf = tools.entradaDados()

        print "Confirme seu nome: "
        String nome = tools.entradaDados()

        print "Confirme seu email: "
        String email = tools.entradaDados()

        print "Confirme sua idade: "
        String idadeStr = tools.entradaDados()
        int idade = Integer.parseInt(idadeStr)

        print "Confirme seu estado: "
        String estado = tools.entradaDados()

        print "Confirme seu CEP: "
        String cep = tools.entradaDados()

        print "Confirme sua descrição: "
        String descricao = tools.entradaDados()

        print "Confirme suas competências (separadas por vírgula): "
        List<String> competencias = Arrays.asList(tools.entradaDados().split(',')).collect { it.trim() }

        Candidato candidato = new Candidato(nome, email, cpf, idade, estado, cep, descricao, competencias)

        candidatoController.atualizarCandidatoDAO(cpf, candidato)

        println("Cadastro atualizado com sucesso!")
    }

    void deletarCandidato(){

        print "\nDigite seu CPF para excluir seu cadastro: "
        String cpf = tools.entradaDados()

        boolean candidatoDeletado = candidatoController.deletarCandidatoDAO(cpf)

        if (candidatoDeletado){
            println("Cadastro removido com sucesso!")
        } else {
            println("Nenhum candidato encontrado com o CPF fornecido.")
        }
    }
}
