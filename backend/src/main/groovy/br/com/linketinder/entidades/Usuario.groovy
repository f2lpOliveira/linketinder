package br.com.linketinder.entidades

class Usuario {
    String nome
    String email
    String pais
    String estado
    String cep
    String descricao
    List<String> competencias = []

    Usuario(String nome, String email, String pais, String estado, String cep, String descricao, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.pais = pais
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.competencias = competencias
    }
}
