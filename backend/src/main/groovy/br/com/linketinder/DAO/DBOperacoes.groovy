package br.com.linketinder.DAO

import groovy.sql.GroovyRowResult
import groovy.sql.Sql

import java.sql.SQLException

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

    List<Map<String, Object>> select(String tableName, String condition, String orderBy) {
        try {
            String query = "SELECT * FROM " + tableName
            if (condition != null && !condition.isEmpty()) {
                query += " WHERE " + condition
            }
            if (orderBy != null && !orderBy.isEmpty()) {
                query += " ORDER BY " + orderBy
            }

            List<GroovyRowResult> rows = sql.rows(query)

            println(rows.isEmpty() ? "Nenhum resultado encontrado." : "Resultados da consulta:")
            rows.each { row ->
                row.each { columnName, value ->
                    println("$columnName: $value")
                }
                println()
            }

            return rows.collect { row ->
                row.getProperties()
            }
        } catch (SQLException e) {
            e.printStackTrace()
            return null
        }
    }

    void update(String tableName, Map<String, Object> newData, String condition) {
        try {
            StringBuilder queryBuilder = new StringBuilder("UPDATE " + tableName + " SET ")
            for (Map.Entry<String, Object> entry : newData.entrySet()) {
                queryBuilder.append(entry.getKey()).append(" = ")
                if (entry.getValue() instanceof String) {
                    queryBuilder.append("'").append(entry.getValue()).append("'")
                } else {
                    queryBuilder.append(entry.getValue())
                }
                queryBuilder.append(", ")
            }
            queryBuilder.setLength(queryBuilder.length() - 2)
            if (condition != null && !condition.isEmpty()) {
                queryBuilder.append(" WHERE ").append(condition)
            }

            sql.execute(queryBuilder.toString())
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    void delete(String tableName, String condition) {
        try {
            String query = "DELETE FROM $tableName"
            if (condition != null && !condition.isEmpty()) {
                query += " WHERE $condition"
            }

            sql.execute(query)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

}

