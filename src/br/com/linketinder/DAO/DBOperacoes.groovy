package br.com.linketinder.DAO

import groovy.sql.Sql

class DBOperacoes {

    Sql sql = Sql.newInstance(DBConexao.conexao())

    void createTable(String nomeTabela, List<String> campos) {
        try {
            def resultado = sql.firstRow("""
            SELECT EXISTS(
                SELECT 1
                FROM   information_schema.tables 
                WHERE  table_name = $nomeTabela
            )
        """)
            if (resultado.EXISTS) {
                println("""A tabela $nomeTabela já existe.""")
                return
            }

            def camposString = campos.join(", ")

            String query = """
            CREATE TABLE $nomeTabela (
                $camposString
            )
        """
            sql.execute(query)
            println("""Tabela $nomeTabela criada com sucesso!""")
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    void insert(String nomeTabela, Map<String, Object> dados) {
        try {
            String colunas = dados.keySet().join(',')
            String valores = dados.values().collect { it instanceof String ? "'$it'" : it }.join(',')

            String query = """
            INSERT INTO $nomeTabela ($colunas)
            VALUES ($valores)
        """

            sql.execute(query)
            println("Dados inseridos com sucesso!")
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
