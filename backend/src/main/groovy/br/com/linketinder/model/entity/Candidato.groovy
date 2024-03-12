package br.com.linketinder.model.entity

class Candidato extends Usuario {

    String cpf
    int idade

    Candidato(String nome, String email, String cpf, int idade, String estado, String cep, String descricao, List<String> competencias) {
        super(nome, email, estado, cep, descricao, competencias)
        this.cpf = cpf
        this.idade = idade
    }


}
