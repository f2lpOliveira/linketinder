package br.com.linketinder.candidato

class Candidato {

    String nome
    String email
    String cpf
    int idade
    String estado
    String cep
    String descricaoPessoal
    List<String> competencias = []

    Candidato(String nome, String email, String cpf, int idade, String estado, String cep, String descricaoPessoal, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.cpf = cpf
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.descricaoPessoal = descricaoPessoal
        this.competencias = competencias
    }
}
