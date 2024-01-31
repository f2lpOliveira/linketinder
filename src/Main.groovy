import br.com.linketinder.cadastro.Cadastro
import br.com.linketinder.candidato.Candidato

def app = new Cadastro()

def competenciasCandidato1 = ["GIT/Github", "Scrum", "Kanban", "Scrumban", "Java", "Groovy", "Docker", "HTML/CSS"]
def candidato1 = new Candidato("Freire", "contato@fellipefreire.com.br", "999.999.999-99", 35, "RJ", "26564-010", "Sou disciplinado, com habilidades em gestão do tempo e inteligência emocional. Sou totalmente adaptável a diferentes circustâncias e tenho humildade para reconhecer minhas falhas.", competenciasCandidato1 )

app.cadastrarCandidato(candidato1)

app.listarCandidatos()