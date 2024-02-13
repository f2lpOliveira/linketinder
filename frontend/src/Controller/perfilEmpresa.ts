import { CandidatoEmpresa } from "../Models/CandidatoEmpresa";
import {CandidatoUsuario} from "../Models/CandidatoUsuario";
import { BDEmpresa } from "../DAO/BDEmpresa";
import {BDCandidato} from "../DAO/BDCandidato";
import { construirEstruturaCandidato } from "./candidatoEstruturaController";
import { criarGraficoBarras } from "./graficoController";

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
    listarCandidatos(candidatos);

    criarGraficoBarras(candidatos);
});

function listarCandidatos(candidatos: CandidatoUsuario[]): void {
    const listaCandidatosElement = document.getElementById("lista-candidatos");

    if (listaCandidatosElement) {
        listaCandidatosElement.innerHTML = '';

        candidatos.forEach((candidato: CandidatoUsuario) => {
            listaCandidatosElement.innerHTML += construirEstruturaCandidato(candidato);
        });
    }
}