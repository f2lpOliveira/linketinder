package br.com.linketinder

import br.com.linketinder.dao.CandidatoDAO
import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.model.factory.UsuarioFactory
import groovy.sql.Sql
import org.junit.jupiter.api.Test
import spock.lang.Specification
import static org.junit.jupiter.api.Assertions.*

class CandidatoDAOTest extends Specification {

    Sql sql
    CandidatoDAO candidatoDAO

    void setup() {
        sql = Mock(Sql)
        candidatoDAO = new CandidatoDAO(sql: sql)
    }

    @Test
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
        assertEquals("João Silva", candidato.nome)
        assertEquals("joao@example.com", candidato.email)
        assertEquals("123.456.789-00", candidato.cpf)
        assertEquals(30, candidato.idade)
        assertEquals("SP", candidato.estado)
        assertEquals("01000-000", candidato.cep)
        assertEquals("Descrição do candidato", candidato.descricao)
        assertEquals(2, candidato.competencias.size())
    }
}
