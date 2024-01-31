package br.com.linketinder.cadastro

import br.com.linketinder.candidato.Candidato
import br.com.linketinder.empresa.Empresa

class Cadastro {

    List<Candidato> candidatos= []
    List<Empresa> empresas= []

    void cadastrarCandidato(Candidato candidato){
        candidatos.add(candidato)
    }

    void cadastrarEmpresa(Empresa empresa){
        empresas.add(empresa)
    }

    void listarCandidatos(){

        candidatos.each {candidato -> println("Nome: ${candidato.nome}, Email: ${candidato.email}, CPF: ${candidato.cpf}, Idade: ${candidato.idade}, Estado: ${candidato.estado}, CEP: ${candidato.cep}, Descrição Pessoal: ${candidato.descricaoPessoal}, Competências: ${candidato.competencias}, ")}
    }

    void listarEmpresas(){

        empresas.each {empresa -> println("Empresa: ${empresa.nome}, Email Corporativo: ${empresa.email}, CNPJ: ${empresa.cnpj}, Pais: ${empresa.pais}, Estado: ${empresa.estado}, CEP: ${empresa.cep}, Descrição da Empresa: ${empresa.descricaoEmpresa}, Competências: ${empresa.competencias}, ")}
    }
}
