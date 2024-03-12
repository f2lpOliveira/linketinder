package br.com.linketinder.model.entity

class Usuario {

    String nome
    String email
    String estado
    String cep
    String descricao
    List<String> competencias = []

    Usuario(String nome, String email, String estado, String cep, String descricao, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.competencias = competencias
    }
}