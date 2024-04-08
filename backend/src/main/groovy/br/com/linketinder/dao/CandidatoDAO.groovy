package br.com.linketinder.dao

import br.com.linketinder.model.entity.Candidato
import groovy.sql.GroovyRowResult
import groovy.sql.Sql

class CandidatoDAO {

    Sql sql = Sql.newInstance(ConexaoDAO.conexao())

    void dbCreate(Candidato candidato) {
        try {
            sql.execute("INSERT INTO candidatos (nome, email, cpf, idade, estado, cep, descricao) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    [candidato.nome, candidato.email, candidato.cpf, candidato.idade, candidato.estado, candidato.cep, candidato.descricao])
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    List<Candidato> dbRead() {
        try {
            List<Candidato> candidatos = sql.rows("SELECT * FROM candidatos")

            candidatos.each { candidato ->

                Integer empid = sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [candidato.cpf]).empid

                candidato.competencias = sql.rows("SELECT nome FROM competencias " +
                        "INNER JOIN candidato_competencias ON competencias.competencia_id = candidato_competencias.competencia_id " +
                        "WHERE candidato_competencias.candidato_id = ?", [empid]).collect { it.nome }
            }
            return candidatos
        }catch (Exception e){
            e.printStackTrace()
        }
    }

    void dbUpdate(String cpf, Candidato candidato) {
        try {
            sql.execute("UPDATE candidatos SET nome = ?, email = ?, cpf = ?, idade = ?, estado = ?, cep = ?, descricao = ? WHERE cpf = ?", [
                    candidato.nome,
                    candidato.email,
                    candidato.cpf,
                    candidato.idade,
                    candidato.estado,
                    candidato.cep,
                    candidato.descricao,
                    cpf
            ])
            Integer empid = obterIdCandidato(cpf)
            removerCompetenciasAntigas(empid)
            atualizarCompetencias(empid, candidato.competencias)
        }catch (Exception e) {
            e.printStackTrace()
        }
    }

    Integer obterIdCandidato(String cpf) {
        return sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [cpf]).empid
    }

    void removerCompetenciasAntigas(Integer empid) {
        sql.execute("DELETE FROM candidato_competencias WHERE candidato_id = ?", [empid])
    }

    void atualizarCompetencias(Integer empid, List<String> competencias) {
        competencias.each { competencia ->
            Integer competenciaId = sql.firstRow("SELECT competencia_id FROM competencias WHERE nome = ?", [competencia])?.competencia_id
            if (competenciaId == null) {
                sql.execute("INSERT INTO competencias (nome) VALUES (?)", [competencia])
                competenciaId = sql.firstRow("SELECT competencia_id FROM competencias WHERE nome = ?", [competencia]).competencia_id
            }
            sql.execute("INSERT INTO candidato_competencias (candidato_id, competencia_id) VALUES (?, ?)", [empid, competenciaId])
        }
    }

    boolean dbDelete(String cpf) {
        try {
            GroovyRowResult result = sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [cpf])
            if (result != null) {
                Integer empid = result.empid

                sql.execute("DELETE FROM candidato_competencias WHERE candidato_id = ?", [empid])
                sql.execute("DELETE FROM candidatos WHERE cpf = ?", [cpf])
                return true
            } else {
                return false
            }
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }
}
