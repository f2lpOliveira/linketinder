package br.com.linketinder.dao

import br.com.linketinder.model.entity.Candidato
import groovy.sql.Sql

class CompetenciasDAO {

    Sql sql = Sql.newInstance(ConexaoDAO.conexao())

    void inserirCompetenciasCandidato(Candidato candidato) {
        try {
            candidato.competencias.each { competencia ->
                sql.execute("INSERT INTO competencias (nome) VALUES (?)", [competencia])
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    void associarCompetenciasAoCandidato(Candidato candidato) {
        try {
            Integer empid = sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [candidato.cpf]).empid

            candidato.competencias.each { competencia ->
                sql.execute("INSERT INTO candidato_competencias (candidato_id, competencia_id) VALUES (?, (SELECT competencia_id FROM competencias WHERE nome = ? ORDER BY competencia_id LIMIT 1))",
                        [empid, competencia])
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
