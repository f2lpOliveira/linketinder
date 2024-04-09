package br.com.linketinder

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.model.factory.UsuarioFactory
import groovy.sql.Sql
import spock.lang.Specification

class CandidatoDAOTest extends Specification {

    Sql sql
    CandidatoDAO candidatoDAO

    void setup() {
        sql = Mock(Sql)
        candidatoDAO = new CandidatoDAO(sql: sql)
    }

    void dbCreateCandidatoDAOTest() {
        given:
        Candidato candidato = UsuarioFactory.criarCandidato(
                "João Silva",
                "joao@example.com",
                "123.456.789-00",
                30,
                "SP",
                "01000-000",
                "Descrição do candidato",
                ["Competência 1", "Competência 2"]
        )

        when:
        candidatoDAO.dbCreate(candidato)

        then:
        1 * sql.execute(_ as String, _ as List)
    }
}
