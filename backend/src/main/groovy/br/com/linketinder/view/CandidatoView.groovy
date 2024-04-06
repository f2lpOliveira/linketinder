package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.model.entity.Candidato

class CandidatoView {

    CandidatoController candidatoController

    CandidatoView() {
        this.candidatoController = new CandidatoController()
    }

    void menuOpcoesCandidato(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        Boolean condicao = true

        while (condicao) {

            exibirOpcoesCandidato()
            String opcao = br.readLine()

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
        Scanner scanner = new Scanner(System.in)

        print "\nDigite o nome do candidato: "
        String nome = scanner.nextLine()

        print "Digite o email do candidato: "
        String email = scanner.nextLine()

        print "Digite o CPF do candidato: "
        String cpf = scanner.nextLine()

        print "Digite a idade do candidato: "
        int idade = scanner.nextInt()
        scanner.nextLine()

        print "Digite o estado do candidato: "
        String estado = scanner.nextLine()

        print "Digite o CEP do candidato: "
        String cep = scanner.nextLine()

        print "Digite a descrição do candidato: "
        String descricao = scanner.nextLine()

        print "Digite as competências do candidato (separadas por vírgula): "
        List<String> competencias = scanner.nextLine().split(',').collect { it.trim() }

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
        Scanner scanner = new Scanner(System.in)

        print "\nDigite seu CPF para atualizar seu cadastro: "
        String cpf = scanner.nextLine()

        print "Confirme seu nome: "
        String nome = scanner.nextLine()

        print "Confirme seu email: "
        String email = scanner.nextLine()

        print "Confirme sua idade: "
        int idade = scanner.nextInt()
        scanner.nextLine()

        print "Confirme seu estado: "
        String estado = scanner.nextLine()

        print "Confirme seu CEP: "
        String cep = scanner.nextLine()

        print "Confirme sua descrição: "
        String descricao = scanner.nextLine()

        print "Confirme suas competências (separadas por vírgula): "
        List<String> competencias = Arrays.asList(scanner.nextLine().split(',')).collect { it.trim() }

        Candidato candidato = new Candidato(nome, email, cpf, idade, estado, cep, descricao, competencias)

        candidatoController.atualizarCandidatoDAO(cpf, candidato)

        println("Cadastro atualizado com sucesso!")
    }

    void menuDeletarCandidato(){
        Scanner scanner = new Scanner(System.in)

        print "\nDigite seu CPF para excluir seu cadastro: "
        String cpf = scanner.nextLine()

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
