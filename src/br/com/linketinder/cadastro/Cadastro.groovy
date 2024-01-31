package br.com.linketinder.cadastro

import br.com.linketinder.candidato.Candidato
import br.com.linketinder.empresa.Empresa

class Cadastro {

    List<Candidato> candidatos= [
            new Candidato(
            "Joao",
            "joao@email.com",
            "123.456.789-00",
            30,
            "SP",
            "12345-678",
            "Me formei em Engenharia de software pela Estácio.",
            ["Java", "JavaScript", "Git"]
    ),
    new Candidato(
            "Priscila",
            "priscila@email.com",
            "987.654.321-00",
            25,
            "RJ",
            "54321-876",
            "Sou formada em enfermagem e busco uma transição de carreira para a área de tecnologia.",
            ["Python", "C#", "Docker"]
    ),
            new Candidato(
                    "Ana",
                    "ana@email.com",
                    "111.222.333-44",
                    28,
                    "MG",
                    "98765-432",
                    "Atualmente estudo Análise e Desenvolvimento de Sistemas pelo IFMG e busco uma oportunidade de estágio.",
                    ["Ruby", "React", "SQL"]
            ),
            new Candidato(
                    "Carlos",
                    "carlos@email.com",
                    "555.666.777-88",
                    32,
                    "RS",
                    "87654-321",
                    "Sou formado em Ciência da Computação pelo IFRS e concluí uma pós em Ciber Segurança pela mesma instituição.",
                    ["C++", "Angular", "AWS"]
            ),
            new Candidato(
                    "Marina",
                    "marina@email.com",
                    "999.888.777-66",
                    23,
                    "BA",
                    "65432-109",
                    "Tenho interesse em atuar como desenvolvedora mobile.",
                    ["Swift", "iOS Development", "Firebase"]
            )
    ]
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
