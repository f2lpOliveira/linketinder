package br.com.linketinder.DAO

import java.sql.Connection
import java.sql.DriverManager

class DBConexao {

    static Connection connection = null

    private DBConexao(){}

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
}
