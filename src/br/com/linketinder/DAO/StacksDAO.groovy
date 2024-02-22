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
}
