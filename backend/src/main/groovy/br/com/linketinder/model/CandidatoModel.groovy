package br.com.linketinder.model

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato

class CandidatoModel {
    private CandidatoDAO candidatoDAO;

    CandidatoModel() {
        this.candidatoDAO = new CandidatoDAO();
    }

    void create() {
        Scanner scanner = new Scanner(System.in)

        print "Digite o nome do candidato: "
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
        new CandidatoDAO().dbCreate(candidato)
    }

    void read() {
        List<Candidato> candidatos = candidatoDAO.dbRead()

        if (candidatos.isEmpty()) {
            println "Não há candidatos cadastrados."
        } else {
            println "Candidatos cadastrados:"
            candidatos.each { candidato ->
                print "Nome: ${candidato.nome}\nEmail: ${candidato.email}\nCPF: ${candidato.cpf}\nIdade: ${candidato.idade}\nEstado: ${candidato.estado}\nCEP: ${candidato.cep}\nDescrição Pessoal: ${candidato.descricao}\n"

                if (!candidato.competencias.empty) {
                    println "Competências: ${candidato.competencias.collect { it }.join(', ')}"
            } else {
                    println "Nenhuma competência cadastrada para este candidato."
                }
                println ""
            }
        }
    }

    void update(){
        Scanner scanner = new Scanner(System.in)

        print "Digite o CPF do candidato que deseja atualizar: "
        String cpf = scanner.nextLine()

        print "Digite o novo nome do candidato: "
        String nome = scanner.nextLine()

        print "Digite o novo email do candidato: "
        String email = scanner.nextLine()

        print "Digite a nova idade do candidato: "
        int idade = scanner.nextInt()
        scanner.nextLine()

        print "Digite o novo estado do candidato: "
        String estado = scanner.nextLine()

        print "Digite o novo CEP do candidato: "
        String cep = scanner.nextLine()

        print "Digite a nova descrição do candidato: "
        String descricao = scanner.nextLine()

        print "Digite as novas competências do candidato (separadas por vírgula): "
        List<String> competencias = Arrays.asList(scanner.nextLine().split(',')).collect { it.trim() }

        Candidato candidato = new Candidato(nome, email, cpf, idade, estado, cep, descricao, competencias)
        candidatoDAO.dbUpdate(cpf, candidato)
    }

    void delete(){
        Scanner scanner = new Scanner(System.in)

        print "Digite o CPF do candidato que deseja deletar: "
        String cpf = scanner.nextLine()

        candidatoDAO.dbDelete(cpf)
    }
}
