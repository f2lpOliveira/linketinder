package br.com.linketinder.entidades

class Empresa extends Usuario{
    String cnpj

    Empresa(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao, List<String> competencias) {
        super(nome, email, pais, estado, cep, descricao, competencias)
        this.cnpj = cnpj
    }
}
