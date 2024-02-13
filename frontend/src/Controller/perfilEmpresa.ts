import { CandidatoEmpresa } from "../Models/CandidatoEmpresa";
import {CandidatoUsuario} from "../Models/CandidatoUsuario";
import { BDEmpresa } from "../DAO/BDEmpresa";
import {BDCandidato} from "../DAO/BDCandidato";


function preencherPerfilEmpresa(empresa: CandidatoEmpresa): void {
    const nomeElement = document.querySelector('.nome');
    if (nomeElement) nomeElement.textContent = empresa.nome;

    const emailElement = document.querySelector('.email');
    if (emailElement) emailElement.textContent = empresa.email;

    const residenciaElement = document.querySelector('ul.dadosGeograficos');
    if (residenciaElement) {
        residenciaElement.children[0].textContent = empresa.pais + ',';
        residenciaElement.children[1].textContent = empresa.estado + ',';
        residenciaElement.children[2].textContent = empresa.cep;
    }

    const cnpjElement = document.querySelector('.cnpj');
    if (cnpjElement) cnpjElement.textContent = empresa.cnpj;

    const competenciasElement = document.querySelector('.competencias');
    if (competenciasElement) {
        competenciasElement.innerHTML = empresa.competencias.map((competencia, index, array) => {
            if (index < array.length - 1) {
                return `<li class="me-1">${competencia},</li>`;
            } else {
                return `<li class="me-1">${competencia}</li>`;
            }
        }).join('');
    }

    const descricaoElement = document.querySelector('.descricao');
    if (descricaoElement) descricaoElement.textContent = empresa.descricao;
}

document.addEventListener('DOMContentLoaded', () => {
    const bdEmpresa = new BDEmpresa();
    const empresas = bdEmpresa.get();

    const cnpjParam = new URLSearchParams(window.location.search).get("cnpj");
    if (!cnpjParam) {
        console.error("CNPJ não encontrado na URL.");
        return;
    }

    const empresa = empresas.find((c: CandidatoEmpresa) => c.cnpj === cnpjParam);
    if (empresa) {
        preencherPerfilEmpresa(empresa);
    } else {
        console.error('Empresa não encontrada.');
    }

    const bdCandidato = new BDCandidato();
    const candidatos = bdCandidato.get();
    listarCandidato(candidatos);
});

function mascararNome(nome: string): string {
    const primeiroParte = nome.slice(0, 2);
    const resto = nome.slice(2).replace(/./g, '*');
    return primeiroParte + resto;
}

function mascararEmail(email: string): string {
    const partes = email.split('@');
    const primeira_parte = partes[0];
    const tamanho = primeira_parte.length;

    const parte_mascarada = primeira_parte.slice(0, 3) + "***" + primeira_parte.slice(tamanho - 2, tamanho);
    return parte_mascarada + '@' + partes[1];
}

function mascararCPF(cpf: string): string {
    return cpf.replace(/\d/g, '*');
}

function listarCandidato(candidatos: CandidatoUsuario[]): void {
    const listaCandidatosElement = document.getElementById("lista-candidatos");

    if (listaCandidatosElement) {
        listaCandidatosElement.innerHTML = '';

        candidatos.forEach((candidato: CandidatoUsuario) => {
            listaCandidatosElement.innerHTML += `
                <div class="candidato">
                    <h2>${mascararNome(candidato.nome)}</h2>
                    <p>Email: ${mascararEmail(candidato.email)}</p>
                    <p>CPF: ${mascararCPF(candidato.cpf)}</p>                    
                    <p>Competências: ${candidato.competencias.slice(0, -1).join(", ")}${candidato.competencias.length > 1 ? ',' : ''} ${candidato.competencias.slice(-1)}</p>                    
                    <p>Descrição: ${candidato.descricao}</p>
                </div>
            `;
        });
    }
}