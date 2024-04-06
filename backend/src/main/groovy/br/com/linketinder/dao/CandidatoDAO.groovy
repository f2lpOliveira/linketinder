package br.com.linketinder.dao

import br.com.linketinder.model.entity.Candidato
import groovy.sql.Sql

class CandidatoDAO {

    Sql sql = Sql.newInstance(ConexaoDAO.conexao())

    void dbCreate(Candidato candidato) {
        try {
            sql.execute("INSERT INTO candidatos (nome, email, cpf, idade, estado, cep, descricao) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    [candidato.nome, candidato.email, candidato.cpf, candidato.idade, candidato.estado, candidato.cep, candidato.descricao])

            candidato.competencias.each { competencia ->
                sql.execute("INSERT INTO competencias (nome) VALUES (?)", [competencia])
            }

            def empid = sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [candidato.cpf]).empid

            candidato.competencias.each { competencia ->
                sql.execute("INSERT INTO candidato_competencias (candidato_id, competencia_id) VALUES (?, (SELECT competencia_id FROM competencias WHERE nome = ? ORDER BY competencia_id LIMIT 1))",
                        [empid, competencia])
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    List<Candidato> dbRead() {
        try {
            List<Candidato> candidatos = sql.rows("SELECT * FROM candidatos")

            candidatos.each { candidato ->

                def empid = sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [candidato.cpf]).empid

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

            def empid = sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [cpf]).empid

            sql.execute("DELETE FROM candidato_competencias WHERE candidato_id = ?", [empid])

            candidato.competencias.each { competencia ->
                def competenciaId = sql.firstRow("SELECT competencia_id FROM competencias WHERE nome = ?", [competencia])?.competencia_id
                if (competenciaId == null) {
                    sql.execute("INSERT INTO competencias (nome) VALUES (?)", [competencia])
                    competenciaId = sql.firstRow("SELECT competencia_id FROM competencias WHERE nome = ?", [competencia]).competencia_id
                }
                sql.execute("INSERT INTO candidato_competencias (candidato_id, competencia_id) VALUES (?, ?)", [empid, competenciaId])
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    boolean dbDelete(String cpf) {
        try {
            def result = sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [cpf])
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
