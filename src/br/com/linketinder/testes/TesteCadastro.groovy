package br.com.linketinder.cadastro

import br.com.linketinder.candidato.Candidato
import br.com.linketinder.empresa.Empresa
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.assertEquals

class TesteCadastro {

    Cadastro cadastro

    @Before
    void setUp() {
        cadastro = new Cadastro()
    }

    @Test
    void testCadastrarCandidato() {
        // Given
        Candidato novoCandidato = new Candidato(
                "Teste",
                "teste@email.com",
                "111.222.333-44",
                25,
                "SP",
                "12345-678",
                "Descrição de teste",
                ["Java", "JavaScript"]
        )

        // When
        cadastro.cadastrarCandidato(novoCandidato)

        // Then
        assertEquals(6, cadastro.candidatos.size())
        assertEquals(novoCandidato, cadastro.candidatos[-1])
    }

    @Test
    void testCadastrarEmpresa() {
        // Given
        Empresa novaEmpresa = new Empresa(
                "Nova Tech",
                "contato@nova.com",
                "987.654.321/0001-06",
                "Brasil",
                "SP",
                "54321-098",
                "Descrição da nova empresa",
                ["Python", "Django"]
        )

        // When
        cadastro.cadastrarEmpresa(novaEmpresa)

        // Then
        assertEquals(6, cadastro.empresas.size())
        assertEquals(novaEmpresa, cadastro.empresas[-1])
    }
}
