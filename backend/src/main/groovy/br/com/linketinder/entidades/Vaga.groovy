package br.com.linketinder.entidades

class Vaga extends Usuario{

    Vaga(String nome, String email, String pais, String estado, String cep, String descricao, List<String> competencias) {
        super(nome, null, pais, estado, cep, descricao, competencias)
    }
}
