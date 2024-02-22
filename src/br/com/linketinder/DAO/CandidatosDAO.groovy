package br.com.linketinder.DAO

class CandidatosDAO {

    List<String> atributoCandidatos = Arrays.asList(
            "empid SERIAL",
            "nome VARCHAR(100)",
            "sobrenome VARCHAR(100)",
            "data_de_nascimento DATE",
            "email VARCHAR(255)",
            "cpf VARCHAR(15) PRIMARY KEY",
            "pais VARCHAR(100)",
            "cep VARCHAR(15)",
            "descricao TEXT",
            "senha VARCHAR(255)"
    )

    List<Map<String, Object>> dadosCandidatos = [
            [
                    "nome"              : "Yuji",
                    "sobrenome"         : "Itadori",
                    "data_de_nascimento": "2004-09-04",
                    "email"             : "yuji.itadori@example.com",
                    "cpf"               : "123.456.789-01",
                    "pais"              : "Japão",
                    "cep"               : "12345-678",
                    "descricao"         : "Estudante do primeiro ano do ensino médio.",
                    "senha"             : "senha123"
            ],
            [
                    "nome"              : "Megumi",
                    "sobrenome"         : "Fushiguro",
                    "data_de_nascimento": "2004-12-06",
                    "email"             : "megumi.fushiguro@example.com",
                    "cpf"               : "123.456.789-02",
                    "pais"              : "Japão",
                    "cep"               : "12345-678",
                    "descricao"         : "Estudante do primeiro ano do ensino médio.",
                    "senha"             : "senha123"
            ],
            [
                    "nome"              : "Nobara",
                    "sobrenome"         : "Kugisaki",
                    "data_de_nascimento": "2004-05-09",
                    "email"             : "nobara.kugisaki@example.com",
                    "cpf"               : "123.456.789-03",
                    "pais"              : "Japão",
                    "cep"               : "12345-678",
                    "descricao"         : "Estudante do primeiro ano do ensino médio.",
                    "senha"             : "senha123"
            ],
            [
                    "nome"              : "Satoru",
                    "sobrenome"         : "Gojo",
                    "data_de_nascimento": "1976-06-01",
                    "email"             : "satoru.gojo@example.com",
                    "cpf"               : "123.456.789-04",
                    "pais"              : "Japão",
                    "cep"               : "12345-678",
                    "descricao"         : "Professor da Tokyo Metropolitan Curse Technical College.",
                    "senha"             : "senha123"
            ],
            [
                    "nome"              : "Kento",
                    "sobrenome"         : "Nanami",
                    "data_de_nascimento": "1979-07-01",
                    "email"             : "kento.nanami@example.com",
                    "cpf"               : "123.456.789-05",
                    "pais"              : "Japão",
                    "cep"               : "12345-678",
                    "descricao"         : "Professor da Tokyo Metropolitan Curse Technical College.",
                    "senha"             : "senha123"
            ]
    ]

    DBOperacoes dbOperacoes

    CandidatosDAO(DBOperacoes dbOperacoes) {
        this.dbOperacoes = dbOperacoes
    }

    void inserirDadosNaTabelaCandidatos() {
        dadosCandidatos.each { candidato ->
            dbOperacoes.insert("Candidatos", candidato)
        }
    }
}