package br.com.linketinder.DAO

import groovy.sql.Sql

class DBOperacoes {

    Sql sql = Sql.newInstance(DBConexao.conexao())

    void createTable(String nomeTabela){
        try {
            def resultado = sql.firstRow("""                
                SELECT EXISTS(
                    SELECT 1
                    FROM   information_schema.tables 
                    WHERE  table_name = $nomeTabela
                )
            """)
            if (resultado.EXISTS) {
                println("A tabela já existe.")
                return
            }
            String query = """
                CREATE TABLE $nomeTabela (
                    empid SERIAL,
                    nome VARCHAR(10),
                    sobrenome VARCHAR(10),
                    data_de_nascimento DATE,
                    email VARCHAR(50),
                    cpf VARCHAR(11) PRIMARY KEY,
                    pais VARCHAR(15),
                    cep VARCHAR(8),
                    descricao_pessoal VARCHAR(200),
                    senha VARCHAR(12)
                )
            """
            sql.execute(query)
            println("Tabela criada com sucesso!")
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
