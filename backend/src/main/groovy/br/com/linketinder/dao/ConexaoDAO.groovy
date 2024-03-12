package br.com.linketinder.dao

import java.sql.Connection
import java.sql.DriverManager

class ConexaoDAO {

    static Connection connection = null

    ConexaoDAO(){}

    static Connection conexao() {

        String dbname = "linketinder"
        String user = "postgres"
        String password = "@celeraZG5"

        try {
            Class.forName("org.postgresql.Driver")
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/$dbname", user, password)
            if (connection != null) {
                println("Conexão estabelecida!")
            } else {
                println("Falha na conexão!")
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
        return connection
    }

    static void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close()
                println("Conexão encerrada!")
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
