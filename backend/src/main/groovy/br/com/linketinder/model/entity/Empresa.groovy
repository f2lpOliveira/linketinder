package br.com.linketinder.model.entity

class Empresa extends Usuario{

    String cnpj
    String pais

    Empresa(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao, List<String> competencias) {
        super(nome, email, estado, cep, descricao, competencias)
        this.cnpj = cnpj
        this.pais = pais
    }
}
