package br.com.linketinder

import br.com.linketinder.controller.MenuController
import br.com.linketinder.dao.ConexaoDAO
import br.com.linketinder.dao.OperacoesDAO
import groovy.sql.Sql

conexaoDAO = new ConexaoDAO()
sqlInstance = new Sql(conexaoDAO.conexao())
operacoesDAO = new OperacoesDAO(sqlInstance)

List<String> camposCandidatos = [
        "empid SERIAL PRIMARY KEY",
        "nome VARCHAR(100)",
        "email VARCHAR(255)",
        "cpf VARCHAR(15) UNIQUE",
        "idade INTEGER",
        "estado VARCHAR(100)",
        "cep VARCHAR(15)",
        "descricao TEXT"
]

List<String> candidatoCompetencias = [
        "candidato_id INTEGER REFERENCES candidatos(empid)",
        "competencia_id INTEGER REFERENCES competencias(competencia_id)"
]

List<String> camposCompetencias = [
        "competencia_id SERIAL PRIMARY KEY",
        "nome VARCHAR(100)"
]

List<String> camposEmpresas = [
        "empid SERIAL PRIMARY KEY",
        "nome VARCHAR(100)",
        "cnpj VARCHAR(50) UNIQUE",
        "email VARCHAR(255)",
        "pais VARCHAR(100)",
        "cep VARCHAR(15)",
        "descricao TEXT"
]

List<String> empresaVagas = [
        "empresa_id INTEGER REFERENCES empresas(empid)",
        "vaga_id INTEGER REFERENCES vagas(vaga_id)"
]

List<String> camposVagas = [
        "vaga_id SERIAL PRIMARY KEY",
        "nome VARCHAR(100)",
        "local VARCHAR(100)",
        "descricao TEXT"
]

//operacoesDAO.createTable("candidatos", camposCandidatos)
//operacoesDAO.createTable("competencias", camposCompetencias)
//operacoesDAO.createTable("candidato_competencias", candidatoCompetencias)
//operacoesDAO.createTable("empresas", camposEmpresas)
//operacoesDAO.createTable("vagas", camposVagas)
//operacoesDAO.createTable("vagas_empresas", empresaVagas)

new MenuController().iniciar()
