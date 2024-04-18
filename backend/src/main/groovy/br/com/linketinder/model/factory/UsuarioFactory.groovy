package br.com.linketinder.model.factory

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.model.entity.Empresa

class UsuarioFactory {

    static Candidato criarCandidato(String nome, String email, String cpf, int idade, String estado, String cep, String descricao, List<String> competencias) {
        return new Candidato(nome, email, cpf, idade, estado, cep, descricao, competencias)
    }

    static Empresa criarEmpresa(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao) {
        return new Empresa(nome, email, cnpj, pais, estado, cep, descricao)
    }
}
