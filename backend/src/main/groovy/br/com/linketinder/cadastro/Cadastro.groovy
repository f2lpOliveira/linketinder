package br.com.linketinder.cadastro

import br.com.linketinder.entidades.Candidato
import br.com.linketinder.entidades.Empresa

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

    List<Empresa> empresas= [
            new Empresa(
                    "ABC Tech",
                    "contato@abc.com",
                    "123.456.789/0001-01",
                    "Brasil",
                    "SP",
                    "12345-678",
                    "Empresa de tecnologia inovadora",
                    ["Java", "JavaScript", "AWS"]
            ),
            new Empresa(
                    "XYZ Solutions",
                    "contato@xyz.com",
                    "987.654.321/0001-02",
                    "EUA",
                    "CA",
                    "98765-432",
                    "Consultoria em soluções empresariais",
                    ["Python", "Django", "Machine Learning"]
            ),
            new Empresa(
                    "Global Soft",
                    "contato@globalsoft.com",
                    "456.789.123/0001-03",
                    "Índia",
                    "MH",
                    "56789-012",
                    "Desenvolvimento de software personalizado",
                    ["C#", "ASP.NET", "SQL Server"]
            ),
            new Empresa(
                    "Tech Innovators",
                    "contato@techinnovators.com",
                    "789.123.456/0001-04",
                    "Alemanha",
                    "BW",
                    "34567-890",
                    "Startup focada em inovações tecnológicas",
                    ["React", "Node.js", "MongoDB"]
            ),
            new Empresa(
                    "Data Systems",
                    "contato@datasystems.com",
                    "234.567.890/0001-05",
                    "Canadá",
                    "ON",
                    "23456-789",
                    "Soluções de gerenciamento de dados",
                    ["SQL", "Power BI", "Big Data"]
            )
    ]

    void cadastrarCandidato(Candidato candidato){
        candidatos.add(candidato)
    }

    void cadastrarEmpresa(Empresa empresa){
        empresas.add(empresa)
    }

    void listarCandidatos(){

        candidatos.each {candidato -> println("Nome: ${candidato.nome}, Email: ${candidato.email}, CPF: ${candidato.cpf}, Idade: ${candidato.idade}, Estado: ${candidato.estado}, CEP: ${candidato.cep}, Descrição Pessoal: ${candidato.descricao}, Competências: ${candidato.competencias}, ")}
    }

    void listarEmpresas(){

        empresas.each {empresa -> println("Empresa: ${empresa.nome}, Email Corporativo: ${empresa.email}, CNPJ: ${empresa.cnpj}, Pais: ${empresa.pais}, Estado: ${empresa.estado}, CEP: ${empresa.cep}, Descrição da Empresa: ${empresa.descricao}, Competências: ${empresa.competencias}, ")}
    }
}
