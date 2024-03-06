package br.com.linketinder.empresa

class Empresa {

    String nome
    String email
    String cnpj
    String pais
    String estado
    String cep
    String descricaoEmpresa
    List<String> competencias = []

    Empresa(String nome, String email, String cnpj, String pais, String estado, String cep, String descricaoEmpresa, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.cnpj = cnpj
        this.pais = pais
        this.estado = estado
        this.cep = cep
        this.descricaoEmpresa = descricaoEmpresa
        this.competencias = competencias
    }
}
