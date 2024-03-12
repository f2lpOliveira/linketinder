package br.com.linketinder.dao

import groovy.sql.Sql

class OperacoesDAO {

    private Sql sql

    OperacoesDAO(Sql sqlInstance){
        this.sql = sqlInstance
    }

    void createTable(String nomeTabela, List<String> campos) {
        try {
            if (tabelaExiste(nomeTabela)) {
                println("A tabela $nomeTabela já existe.")
                return
            }

            String camposString = campos.join(", ")
            String query = "CREATE TABLE $nomeTabela ($camposString)"
            sql.execute(query)

            println("Tabela $nomeTabela criada com sucesso!")
        } catch (Exception e) {
            println("Erro ao criar tabela $nomeTabela: ${e.message}")
        }
    }

    private boolean tabelaExiste(String nomeTabela) {
        def resultado = sql.firstRow("""
            SELECT EXISTS(
                SELECT 1
                FROM   information_schema.tables
                WHERE  table_name = $nomeTabela
            )
        """)
        return resultado?.EXISTS
    }
}
