import br.com.linketinder.cadastro.Cadastro
import br.com.linketinder.candidato.Candidato
import br.com.linketinder.empresa.Empresa

def app = new Cadastro()

def competenciasCandidato1 = ["GIT/Github", "Scrum", "Kanban", "Scrumban", "Java", "Groovy", "Docker", "HTML/CSS"]
def candidato1 = new Candidato("Freire", "contato@fellipefreire.com.br", "999.999.999-99", 35, "RJ", "26564-010", "Sou disciplinado, com habilidades em gestão do tempo e inteligência emocional. Sou totalmente adaptável a diferentes circustâncias e tenho humildade para reconhecer minhas falhas.", competenciasCandidato1 )

//app.cadastrarCandidato(candidato1)
//app.listarCandidatos()

def competenciasEmpresa1 = ["Ambiente Colaborativo", "Visão de Futuro", "Inovadora"]
def empresa1 = new Empresa("XPTO Software", "contato@xptosoftware.com.br", "99.999.999/0001-99", "Brasil", "SP", "11111-011", "Atua no setor de desenvolvimento de software.", competenciasEmpresa1 )

app.cadastrarEmpresa(empresa1)
app.listarEmpresas()