package br.com.linketinder.dao

class EmpresasDAO {

    List<String> atributoEmpresas = Arrays.asList(
            "empid SERIAL",
            "nome VARCHAR(100)",
            "cnpj VARCHAR(50) PRIMARY KEY",
            "email VARCHAR(255)",
            "pais VARCHAR(100)",
            "cep VARCHAR(15)",
            "descricao TEXT",
            "senha VARCHAR(255)"
    )

    List<Map<String, Object>> dadosEmpresas = [
            [
                    "nome": "Kyoto Tech",
                    "cnpj": "12.345.678/0001-90",
                    "email": "kyototech@example.com",
                    "pais": "Japão",
                    "cep": "1234567",
                    "descricao": "Empresa tech especializada em desenvolvimento de software.",
                    "senha": "senha123"
            ],
            [
                    "nome": "Tokyo Tech",
                    "cnpj": "23.456.789/0001-01",
                    "email": "tokyotech@example.com",
                    "pais": "Japão",
                    "cep": "2345678",
                    "descricao": "Empresa tech líder em inovação tecnológica.",
                    "senha": "senha456"
            ],
            [
                    "nome": "Osaka Tech",
                    "cnpj": "34.567.890/0001-12",
                    "email": "osakatech@example.com",
                    "pais": "Japão",
                    "cep": "3456789",
                    "descricao": "Empresa tech focada em soluções de inteligência artificial.",
                    "senha": "senha789"
            ],
            [
                    "nome": "Kyushu Tech",
                    "cnpj": "45.678.901/0001-23",
                    "email": "kyushutech@example.com",
                    "pais": "Japão",
                    "cep": "4567890",
                    "descricao": "Empresa tech especializada em cibersegurança.",
                    "senha": "senhaabc"
            ],
            [
                    "nome": "Hokkaido Tech",
                    "cnpj": "56.789.012/0001-34",
                    "email": "hokkaidotech@example.com",
                    "pais": "Japão",
                    "cep": "5678901",
                    "descricao": "Empresa tech pioneira em blockchain.",
                    "senha": "senhaxyz"
            ]
    ]

    DBOperacoes dbOperacoes

    EmpresasDAO(DBOperacoes dbOperacoes) {
        this.dbOperacoes = dbOperacoes
    }

    void inserirDadosNaTabelaEmpresas() {
        dadosEmpresas.each { empresa ->
            dbOperacoes.insert("Empresas", empresa)
        }
    }

    List<Map<String, Object>> buscarEmpresas(String condicao, String orderBy = "empid ASC") {
        return dbOperacoes.select("Empresas", condicao, orderBy)
    }

    void atualizarCandidato(String cnpj, Map<String, Object> novosDados) {
        String condicao = "cnpj = '$cnpj'"
        dbOperacoes.update("Empresas", novosDados, condicao)
    }

    void excluirCandidato(String cnpj) {
        String condicao = "cnpj = '$cnpj'"
        dbOperacoes.delete("Empresas", condicao)
    }
}
