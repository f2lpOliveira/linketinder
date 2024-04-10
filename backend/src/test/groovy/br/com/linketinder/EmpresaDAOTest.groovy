package br.com.linketinder

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.model.factory.UsuarioFactory
import groovy.sql.Sql
import org.junit.jupiter.api.Test
import spock.lang.Specification
import static org.junit.jupiter.api.Assertions.*

class EmpresaDAOTest extends Specification {

    Sql sql
    EmpresaDAO empresaDAO

    void setup() {
        sql = Mock(Sql)
        empresaDAO = new EmpresaDAO(sql: sql)
    }

    @Test
    void dbCreateEmpresaDAOTest() {
        given:
        Empresa empresa = UsuarioFactory.criarEmpresa(
                "XPTO",
                "contato@xpto.com.br",
                "12.345.678/0001-00",
                "Brasil",
                "SP",
                "01000-000",
                "Descrição da empresa"
        )

        when:
        empresaDAO.dbCreate(empresa)

        then:
        assertEquals("XPTO", empresa.nome)
        assertEquals("contato@xpto.com.br", empresa.email)
        assertEquals("12.345.678/0001-00", empresa.cnpj)
        assertEquals("Brasil", empresa.pais)
        assertEquals("SP", empresa.estado)
        assertEquals("01000-000", empresa.cep)
        assertEquals("Descrição da empresa", empresa.descricao)
    }
}
