import br.com.linketinder.DAO.DBOperacoes
import br.com.linketinder.DAO.CandidatosDAO
import br.com.linketinder.DAO.EmpresasDAO
import br.com.linketinder.DAO.StacksDAO
import br.com.linketinder.DAO.VagasDAO

//import br.com.linketinder.menuIterativo.Menu

dbOperacoes = new DBOperacoes()
dadosCandidatos = new CandidatosDAO(dbOperacoes)
dadosEmpresas = new EmpresasDAO(dbOperacoes)
dadosStacks = new StacksDAO(dbOperacoes)
dadosVagas = new VagasDAO(dbOperacoes)


dbOperacoes.createTable("candidatos", dadosCandidatos.atributoCandidatos)
dadosCandidatos.inserirDadosNaTabelaCandidatos()
dbOperacoes.createTable("empresas", dadosEmpresas.atributoEmpresas)
dadosEmpresas.inserirDadosNaTabelaEmpresas()
dbOperacoes.createTable("stacks", dadosStacks.atributoStacks)
dbOperacoes.createTable("vagas", dadosVagas.atributoVagas)



//menu = new Menu()
//menu.exibirMenu()