interface CadastroCandidato {
    nome: string;
    idade: number;
    cpf: string;
    estado: string;
    cep: string;
    email: string;
    competencias: string[];
    descricao: string;
}

function obterDadosCandidato(): CadastroCandidato | null {
    const cpfParam = new URLSearchParams(window.location.search).get('cpf');
    if (!cpfParam) return null;

    const candidatoJSON = localStorage.getItem(cpfParam);
    if (!candidatoJSON) return null;

    return JSON.parse(candidatoJSON);
}

function preencherPerfilCandidato(candidato: CadastroCandidato): void {
    const nomeElement = document.querySelector('.nome');
    if (nomeElement) nomeElement.textContent = candidato.nome;

    const emailElement = document.querySelector('.email');
    if (emailElement) emailElement.textContent = candidato.email;

    const residenciaElement = document.querySelector('ul.dadosGeograficos');
    if (residenciaElement) {
        residenciaElement.children[0].textContent = candidato.estado + ',';
        residenciaElement.children[1].textContent = candidato.cep;
    }

    const idadeElement = document.querySelector('ul.dadosDemograficos > li:nth-child(1)');
    if (idadeElement) idadeElement.textContent = candidato.idade.toString() + " anos";

    const cpfElement = document.querySelector('ul.dadosDemograficos > li:nth-child(2)');
    if (cpfElement) cpfElement.textContent = candidato.cpf;

    const competenciasElement = document.querySelector('ul.dadosDemograficos > li:nth-child(3) > ul');
    if (competenciasElement) {
        competenciasElement.innerHTML = candidato.competencias.map((competencia, index, array) => {
            if (index < array.length - 1) {
                return `<li class="me-1">${competencia},</li>`;
            } else {
                return `<li class="me-1">${competencia}</li>`;
            }
        }).join('');
    }

    const descricaoElement = document.querySelector('ul.dadosDemograficos > li:nth-child(4) > div');
    if (descricaoElement) descricaoElement.textContent = candidato.descricao;
}

document.addEventListener('DOMContentLoaded', () => {
    const candidato = obterDadosCandidato();
    if (candidato) {
        preencherPerfilCandidato(candidato);
    } else {
        console.error('Candidato não encontrado.');
    }
});
