import br.com.linketinder.DAO.DBOperacoes
//import br.com.linketinder.menuIterativo.Menu

DBOperacoes dbOperacoes = new DBOperacoes()

List<String> atributoCandidatos = Arrays.asList(
        "empid SERIAL",
        "nome VARCHAR(10)",
        "sobrenome VARCHAR(10)",
        "data_de_nascimento DATE",
        "email VARCHAR(50)",
        "cpf VARCHAR(11) PRIMARY KEY",
        "pais VARCHAR(15)",
        "cep VARCHAR(8)",
        "staks VARCHAR(8)",
        "descricao VARCHAR(200)",
        "senha VARCHAR(12)"
)

List<String> atributoEmpresas = Arrays.asList(
        "empid SERIAL",
        "nome VARCHAR(10)",
        "cnpj VARCHAR(14) PRIMARY KEY",
        "email VARCHAR(50)",
        "pais VARCHAR(15)",
        "cep VARCHAR(8)",
        "descricao VARCHAR(200)",
        "senha VARCHAR(12)"
)

List<String> atributoCompetencias = Arrays.asList(
        "empid SERIAL",
        "stack VARCHAR(10) PRIMARY KEY"
)

List<String> atributoVagas = Arrays.asList(
        "empid SERIAL PRIMARY KEY",
        "nome VARCHAR(100)",
        "stack VARCHAR(100)",
        "local VARCHAR(15)",
        "descricao VARCHAR(200)"
)

dbOperacoes.createTable("candidatos", atributoCandidatos)
dbOperacoes.createTable("empresas", atributoEmpresas)
dbOperacoes.createTable("competencias", atributoCompetencias)
dbOperacoes.createTable("vagas", atributoVagas)



//menu = new Menu()
//menu.exibirMenu()