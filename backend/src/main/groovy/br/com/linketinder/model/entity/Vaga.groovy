package br.com.linketinder.model.entity

class Vaga {

    String nome
    String estado
    String cep
    String descricao
    List<String> competencias

    Vaga(String nome, String estado, String cep, String descricao, List<String> competencias) {
        this.nome = nome
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.competencias = competencias
    }
}
