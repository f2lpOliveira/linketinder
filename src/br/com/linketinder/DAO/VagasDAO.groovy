package br.com.linketinder.DAO

class VagasDAO {

    List<String> atributoVagas = Arrays.asList(
            "empid SERIAL",
            "nome VARCHAR(100)",
            "local VARCHAR(100)",
            "descricao TEXT"
    )

    DBOperacoes dbOperacoes

    VagasDAO(DBOperacoes dbOperacoes) {
        this.dbOperacoes = dbOperacoes
    }

    void inserirDadosNaTabelaVagas() {
        dadosVagas.each { vaga ->
            dbOperacoes.insert("Vagas", vaga)
        }
    }

    List<Map<String, Object>> buscarVagas(String condicao, String orderBy = "empid ASC") {
        return dbOperacoes.select("Vagas", condicao, orderBy)
    }

    void atualizarCandidato(String cnpj, Map<String, Object> novosDados) {
        String condicao = "cnpj = '$cnpj'"
        dbOperacoes.update("Vagas", novosDados, condicao)
    }

    void excluirCandidato(String cnpj) {
        String condicao = "cnpj = '$cnpj'"
        dbOperacoes.delete("Vagas", condicao)
    }
}
