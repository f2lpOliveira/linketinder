package br.com.linketinder

import br.com.linketinder.dao.VagaDAO
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.model.factory.UsuarioFactory
import groovy.sql.Sql
import org.junit.jupiter.api.Test
import spock.lang.Specification
import static org.junit.jupiter.api.Assertions.*

class VagaDAOTest extends Specification {

    Sql sql
    VagaDAO vagaDAO

    void setup() {
        sql = Mock(Sql)
        vagaDAO = new VagaDAO(sql: sql)
    }

    @Test
    void dbCreateVagaDAOTest() {
        given:
        Vaga vaga = UsuarioFactory.criarVaga(
                "Estágio Desenvolvedor Backend Java",
                "Paraná",
                "47.123-456",
                "Desenvolver Software Desktop",
                ["Competência 1", "Competência 2", "Competência 3"]
        )

        when:
        vagaDAO.dbCreate(vaga)

        then:
        assertEquals("Estágio Desenvolvedor Backend Java", vaga.nome)
        assertEquals("Paraná", vaga.estado)
        assertEquals("47.123-456", vaga.cep)
        assertEquals("Desenvolver Software Desktop", vaga.descricao)
        assertEquals(3, vaga.competencias.size())
    }
}
