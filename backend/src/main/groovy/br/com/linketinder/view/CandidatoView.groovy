package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.tools.Tools

class CandidatoView {

    CandidatoController candidatoController
    Tools tools

    CandidatoView() {
        this.candidatoController = new CandidatoController()
        this.tools = new Tools()
    }

    void menuOpcoesCandidato(){

        Boolean condicao = true

        while (condicao) {

            exibirOpcoesCandidato()
            String opcao = tools.entradaDados()

            switch (opcao) {
                case '1':
                    candidatoController.exibirMenuCadastrarCandidato()
                    break
                case '2':
                    candidatoController.exibirMenuListarCandidatos()
                    break
                case '3':
                    candidatoController.exibirMenuAtualizarCandidato()
                    break
                case '4':
                    candidatoController.exibirMenuExcluirCandidato()
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

    void menuCadastrarCandidato() {

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

    void menuListarCandidatos() {
        List<Candidato> candidatos = candidatoController.getCandidatosDAO()

        if (candidatos.isEmpty()) {
            println "Não há candidatos cadastrados."
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

    void menuAtualizarCandidato(){

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

    void menuDeletarCandidato(){

        print "\nDigite seu CPF para excluir seu cadastro: "
        String cpf = tools.entradaDados()

        boolean candidatoDeletado = candidatoController.deletarCandidatoDAO(cpf)

        if (candidatoDeletado){
            println("Cadastro removido com sucesso!")
        } else {
            println("Nenhum candidato encontrado com o CPF fornecido.")
        }
    }

    void exibirOpcoesCandidato(){
        print """
Escolha uma das opções a seguir:
1. Cadastrar
2. Listar Vagas
3. Atualizar Cadastro
4. Excluir Cadastro
0. Voltar ao Menu Anterior
"""
    }
}
