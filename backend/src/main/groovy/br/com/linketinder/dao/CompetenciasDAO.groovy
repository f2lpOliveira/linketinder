package br.com.linketinder.dao

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.model.entity.Vaga
import groovy.sql.Sql

class CompetenciasDAO {

    static CandidatoDAO candidatoDAO = new CandidatoDAO()

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

    List<String> listarCompetenciasCandidato(Integer empid) {
        try {
            return sql.rows("SELECT nome FROM competencias " +
                    "INNER JOIN candidato_competencias ON competencias.competencia_id = candidato_competencias.competencia_id " +
                    "WHERE candidato_competencias.candidato_id = ?", [empid]).collect { it.nome };
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    List<Candidato> getCompetenciasCandidato(String cpf) {
        try {
            return sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [cpf]).empid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void removerCompetencias(Integer empid) {
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

    void inserirCompetenciasVaga(Vaga vaga) {
        try {
            vaga.competencias.each { competencia ->
                sql.execute("INSERT INTO competencias (nome) VALUES (?)", [competencia])
            }
        }catch (Exception e){
            e.printStackTrace()
        }
    }

    void associarCompetenciasVaga(Vaga vaga) {
        try {
            Integer vagaId = sql.firstRow("SELECT vaga_id FROM vagas WHERE nome = ? AND estado = ? AND cep = ? AND descricao = ?",
                    [vaga.nome, vaga.estado, vaga.cep, vaga.descricao]).vaga_id

            vaga.competencias.each { competencia ->
                sql.execute("INSERT INTO vagas_competencias (vaga_id, competencia_id) VALUES (?, (SELECT competencia_id FROM competencias WHERE nome = ? ORDER BY competencia_id LIMIT 1))",
                        [vagaId, competencia])
            }
        }catch (Exception e){
            e.printStackTrace()
        }
    }

}
