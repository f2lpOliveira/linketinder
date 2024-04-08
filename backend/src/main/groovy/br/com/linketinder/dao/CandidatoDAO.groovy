package br.com.linketinder.dao

import br.com.linketinder.controller.CompetenciasController
import br.com.linketinder.model.entity.Candidato
import groovy.sql.Sql

class CandidatoDAO {

    CompetenciasController competenciasController = new CompetenciasController()

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
            List<Candidato> candidatos = sql.rows("SELECT * FROM candidatos");

            candidatos.each {candidato ->
                Integer empid = competenciasController.getCompetenciasCandidato(candidato.cpf)
                candidato.competencias = competenciasController.listarCompetenciasCandidato(empid)
            }
            return candidatos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            competenciasController.removerCompetenciasCandidato(empid)
            competenciasController.atualizarCompetenciasCandidato(empid, candidato.competencias)
        }catch (Exception e) {
            e.printStackTrace()
        }
    }

    boolean dbDelete(String cpf) {
        try {
            Integer empid = obterIdCandidato(cpf)
            if (empid != null) {

                competenciasController.removerCompetenciasCandidato(empid)

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

    Integer obterIdCandidato(String cpf) {
        return sql.firstRow("SELECT empid FROM candidatos WHERE cpf = ?", [cpf]).empid
    }
}
