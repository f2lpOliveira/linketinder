package br.com.linketinder.model.entity

class Vaga extends Usuario{

    Vaga(String nome, String estado, String cep, String descricao, List<String> competencias) {
        super(nome, null, estado, cep, descricao, competencias)
    }
}
