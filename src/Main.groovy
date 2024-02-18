import br.com.linketinder.DAO.DBOperacoes
//import br.com.linketinder.menuIterativo.Menu

DBOperacoes dbOperacoes = new DBOperacoes()
dbOperacoes.createTable("candidatos")

Map<String, Object> dados = [
        'nome': 'Satoru',
        'sobrenome': 'Gojo',
        'data_de_nascimento': '1989-12-07',
        'email': 'satoru_gojo@jujutsu.co.jp',
        'cpf': '23456789012',
        'pais': 'Japão',
        'cep': '12345678',
        'descricao_pessoal': 'Feiticeiro jujutsu de Grau Especial.',
        'senha': 'senha123'
]

dbOperacoes.insert('candidatos', dados)

//menu = new Menu()
//menu.exibirMenu()