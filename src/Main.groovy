import br.com.linketinder.DAO.DBOperacoes
import br.com.linketinder.DAO.DadosCandidatos

//import br.com.linketinder.menuIterativo.Menu

dbOperacoes = new DBOperacoes()
dadosCandidatos = new DadosCandidatos(dbOperacoes)

List<String> atributoCandidatos = Arrays.asList(
        "empid SERIAL",
        "nome VARCHAR(100)",
        "sobrenome VARCHAR(100)",
        "data_de_nascimento DATE",
        "email VARCHAR(255)",
        "cpf VARCHAR(15) PRIMARY KEY",
        "pais VARCHAR(100)",
        "cep VARCHAR(15)",
        "descricao TEXT",
        "senha VARCHAR(255)"
)

//Map<String, Object> candidato1 = new HashMap<>()
//candidato1.put("nome", "João")
//candidato1.put("sobrenome", "Silva")
//candidato1.put("data_de_nascimento", "1990-05-15")
//candidato1.put("email", "joao.silva@example.com")
//candidato1.put("cpf", "123.456.789-00")
//candidato1.put("pais", "Brasil")
//candidato1.put("cep", "12345-678")
//candidato1.put("descricao", "Exemplo de descrição para João Silva.")
//candidato1.put("senha", "senha123")

//List<String> atributoEmpresas = Arrays.asList(
//        "empid SERIAL",
//        "nome VARCHAR(10)",
//        "cnpj VARCHAR(14) PRIMARY KEY",
//        "email VARCHAR(50)",
//        "pais VARCHAR(15)",
//        "cep VARCHAR(8)",
//        "descricao VARCHAR(200)",
//        "senha VARCHAR(12)"
//)

//List<String> atributoStacks = Arrays.asList(
//        "empid SERIAL PRIMARY KEY",
//        "candidato_cpf VARCHAR(15)",
//        "stack VARCHAR(100)",
//        "FOREIGN KEY (candidato_cpf) REFERENCES candidatos(cpf)"
//)

//List<String> atributoVagas = Arrays.asList(
//        "empid SERIAL PRIMARY KEY",
//        "nome VARCHAR(100)",
//        "stack VARCHAR(100)",
//        "local VARCHAR(15)",
//        "descricao VARCHAR(200)"
//)

dbOperacoes.createTable("candidatos", atributoCandidatos)
dadosCandidatos.inserirDadosNaTabelaCandidatos()
//dbOperacoes.createTable("empresas", atributoEmpresas)
//dbOperacoes.createTable("stacks", atributoStacks)
//dbOperacoes.createTable("vagas", atributoVagas)



//menu = new Menu()
//menu.exibirMenu()