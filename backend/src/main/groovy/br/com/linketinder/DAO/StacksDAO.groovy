package br.com.linketinder.DAO

class StacksDAO {

    List<String> atributoStacks = Arrays.asList(
            "empid SERIAL",
            "nome VARCHAR(100)"
    )

    DBOperacoes dbOperacoes

    StacksDAO(DBOperacoes dbOperacoes) {
        this.dbOperacoes = dbOperacoes
    }

    void inserirDadosNaTabelaStacks() {
        dadosStacks.each { stack ->
            dbOperacoes.insert("Stacks", stack)
        }
    }

    List<Map<String, Object>> buscarStacks(String condicao, String orderBy = "empid ASC") {
        return dbOperacoes.select("Stacks", condicao, orderBy)
    }

    void atualizarCandidato(String cnpj, Map<String, Object> novosDados) {
        String condicao = "cnpj = '$cnpj'"
        dbOperacoes.update("Stacks", novosDados, condicao)
    }

    void excluirCandidato(String cnpj) {
        String condicao = "cnpj = '$cnpj'"
        dbOperacoes.delete("Stacks", condicao)
    }
}
