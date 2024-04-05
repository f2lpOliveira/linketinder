package br.com.linketinder.model

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato

class CandidatoModel {
    private CandidatoDAO candidatoDAO;

    CandidatoModel() {
        this.candidatoDAO = new CandidatoDAO();
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
