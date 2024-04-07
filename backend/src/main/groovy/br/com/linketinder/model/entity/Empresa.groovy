package br.com.linketinder.model.entity

class Empresa extends Usuario{

    String cnpj
    String pais

    Empresa(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao) {
        super(nome, email, estado, cep, descricao, null)
        this.cnpj = cnpj
        this.pais = pais
    }
}
