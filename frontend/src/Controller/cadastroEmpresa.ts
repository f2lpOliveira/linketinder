import { BDEmpresa } from "../DAO/BDEmpresa";
import { CandidatoEmpresa } from "../Models/CandidatoEmpresa";

let nomeEmpresa: string
let emailEmpresa: string
let cnpjEmpresa: string
let paisEmpresa: string
let estadoEmpresa: string
let cepEmpresa: string
let descricaoEmpresa: string
let competenciasEmpresa: string[] = []

const formEmpresa: HTMLFormElement | null = document.forms.namedItem("form2");

formEmpresa?.addEventListener("submit", (event) => {
    event.preventDefault();

    if (validarCamposObrigatoriosEmpresa()) {
        const novaEmpresa = new CandidatoEmpresa(
            nomeEmpresa,
            emailEmpresa,
            cnpjEmpresa,
            paisEmpresa,
            estadoEmpresa,
            cepEmpresa,
            descricaoEmpresa,
            competenciasEmpresa
        );

        const bdEmpresa = new BDEmpresa()
        bdEmpresa.add(novaEmpresa)

        alert("Cadastro realizado com sucesso!");

        window.location.href = `perfilEmpresa.html?cnpj=${encodeURIComponent(cnpjEmpresa)}`;
    } else {
        alert("Por favor, preencha todos os campos obrigatórios.");
    }
});

function validarCamposObrigatoriosEmpresa(): boolean {
    const camposObrigatorios: string[] = ["nome", "email", "cnpj", "pais", "estado", "cep", "descricao"];
    let todosCamposPreenchidos = true;

    camposObrigatorios.forEach((campo) => {
        const input: HTMLInputElement | null = document.getElementById(campo) as HTMLInputElement;
        if (!input || input.value.trim() === "") {
            todosCamposPreenchidos = false;
        }
    });

    return todosCamposPreenchidos;
}

function iniciarListenersEmpresa(): void {
    const camposObrigatorios: string[] = ["nome", "email", "cnpj", "pais", "estado", "cep", "descricao"];
    camposObrigatorios.forEach((campo) => {
        const input: HTMLInputElement | null = document.getElementById(campo) as HTMLInputElement;
        input?.addEventListener("change", () => {
            switch (campo) {
                case "nome":
                    nomeEmpresa = input.value;
                    break;
                case "email":
                    emailEmpresa = input.value;
                    break;
                case "cnpj":
                    cnpjEmpresa = input.value;
                    break;
                case "pais":
                    paisEmpresa = input.value;
                    break;
                case "estado":
                    estadoEmpresa = input.value;
                    break;
                case "cep":
                    cepEmpresa = input.value;
                    break;
                case "descricao":
                    descricaoEmpresa = input.value;
                    break;
                default:
                    break;
            }
        });
    });

    const checkboxes: NodeListOf<HTMLInputElement> = document.querySelectorAll('input[name="competencias[]"]');
    checkboxes.forEach((checkbox) => {
        checkbox.addEventListener("change", () => {
            if (checkbox.checked) {
                competenciasEmpresa.push(checkbox.value);
            } else {
                competenciasEmpresa = competenciasEmpresa.filter((competencia) => competencia !== checkbox.value);
            }
        });
    });
}

iniciarListenersEmpresa();