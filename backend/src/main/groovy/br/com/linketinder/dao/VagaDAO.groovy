package br.com.linketinder.dao

import br.com.linketinder.model.entity.Vaga
import groovy.sql.Sql

class VagaDAO {

    Sql sql = Sql.newInstance(ConexaoDAO.conexao())

    void dbCreate(Vaga vaga) {
        try {
            sql.execute("INSERT INTO vagas (nome, estado, cep, descricao) VALUES (?, ?, ?, ?)",
                    [vaga.nome, vaga.estado, vaga.cep, vaga.descricao])
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    List<Vaga> dbRead() {
        try {
            List<Vaga> vagas = sql.rows("SELECT * FROM vagas")

            vagas.each { vaga ->

                Integer vagaId = sql.firstRow("SELECT vaga_id FROM vagas WHERE nome = ? AND estado = ? AND cep = ? AND descricao = ?",
                        [vaga.nome, vaga.estado, vaga.cep, vaga.descricao]).vaga_id

                vaga.competencias = sql.rows("SELECT nome FROM competencias " +
                        "INNER JOIN vagas_competencias ON competencias.competencia_id = vagas_competencias.competencia_id " +
                        "WHERE vagas_competencias.vaga_id = ?", [vagaId]).collect { it.nome }
            }
            return vagas
        }catch (Exception e){
            e.printStackTrace()
        }
    }
}



//vaga.competencias.each { competencia ->
//    sql.execute("INSERT INTO competencias (nome) VALUES (?)", [competencia])
//
//    Integer competenciaId = sql.firstRow("SELECT competencia_id FROM competencias WHERE nome = ? ORDER BY competencia_id LIMIT 1", [competencia]).competencia_id
//
//    sql.execute("INSERT INTO vagas_competencias (vaga_id, competencia_id) VALUES (?, ?)", [vagaId, competenciaId])
//}