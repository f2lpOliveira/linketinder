package br.com.linketinder

import br.com.linketinder.DAO.DBOperacoes
import br.com.linketinder.DAO.CandidatosDAO
import br.com.linketinder.DAO.EmpresasDAO
import br.com.linketinder.DAO.StacksDAO
import br.com.linketinder.DAO.VagasDAO

import br.com.linketinder.menuIterativo.Menu

//dbOperacoes = new DBOperacoes()
//dadosCandidatos = new CandidatosDAO(dbOperacoes)
//dadosEmpresas = new EmpresasDAO(dbOperacoes)
//dadosStacks = new StacksDAO(dbOperacoes)
//dadosVagas = new VagasDAO(dbOperacoes)


//dbOperacoes.createTable("candidatos", dadosCandidatos.atributoCandidatos)
//dadosCandidatos.inserirDadosNaTabelaCandidatos()
//dbOperacoes.createTable("empresas", dadosEmpresas.atributoEmpresas)
//dadosEmpresas.inserirDadosNaTabelaEmpresas()
//dbOperacoes.createTable("stacks", dadosStacks.atributoStacks)
//dbOperacoes.createTable("vagas", dadosVagas.atributoVagas)
//dadosCandidatos.excluirCandidato("123.456.789-03")
//dadosCandidatos.atualizarCandidato("123.456.789-03", [
//        nome              : "Kaizen",
//        sobrenome         : "Jutsu",
//        data_de_nascimento: "2004-09-04",
//        email             : "yuji.itadori@example.com",
//        cpf               : "123.456.789-10",
//        pais              : "Japão",
//        cep               : "12345-678",
//        descricao         : "Estudante do primeiro ano do ensino médio.",
//        senha             : "senha123"
//])
//dadosCandidatos.buscarCandidatos("cep = '12345-678'", "empid ASC")





menu = new Menu()
menu.exibirMenu()