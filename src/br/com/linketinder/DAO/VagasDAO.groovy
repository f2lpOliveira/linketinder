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
}
