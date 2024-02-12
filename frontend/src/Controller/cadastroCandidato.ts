import { BDCandidato } from "../DAO/BDCandidato";
import { CandidatoUsuario } from "../Models/CandidatoUsuario";

let nomeCandidato: string
let idadeCandidato: number
let cpfCandidato: string
let estadoCandidato: string
let cepCandidato: string
let emailCandidato: string
let competenciasCandidato: string[] = []
let descricaoCandidato: string

const formCandidato: HTMLFormElement | null = document.forms.namedItem("form1");
formCandidato?.addEventListener("submit", (event) => {
    event.preventDefault();

    if (validarCamposObrigatoriosCandidato()) {
        const novoCandidato = new CandidatoUsuario(
            nomeCandidato,
            idadeCandidato,
            cpfCandidato,
            estadoCandidato,
            cepCandidato,
            emailCandidato,
            competenciasCandidato,
            descricaoCandidato
        );

        const bdCandidato = new BDCandidato()
        bdCandidato.add(novoCandidato)

        alert("Cadastro realizado com sucesso!");

        window.location.href = `perfilCandidato.html?cpf=${encodeURIComponent(cpfCandidato)}`;
    } else {
        alert("Por favor, preencha todos os campos obrigatórios.");
    }
});

function validarCamposObrigatoriosCandidato(): boolean {
    const camposObrigatorios: string[] = ["nome", "idade", "cpf", "estado", "cep", "email", "descricao"];
    let todosCamposPreenchidos = true;

    camposObrigatorios.forEach((campo) => {
        const input: HTMLInputElement | null = document.getElementById(campo) as HTMLInputElement;
        if (!input || input.value.trim() === "") {
            todosCamposPreenchidos = false;
        }
    });

    return todosCamposPreenchidos;
}

function iniciarListenersCandidato(): void {
    const camposObrigatorios: string[] = ["nome", "idade", "cpf", "estado", "cep", "email", "descricao"];
    camposObrigatorios.forEach((campo) => {
        const input: HTMLInputElement | null = document.getElementById(campo) as HTMLInputElement;
        input?.addEventListener("change", () => {
            switch (campo) {
                case "nome":
                    nomeCandidato = input.value;
                    break;
                case "idade":
                    idadeCandidato = parseInt(input.value, 10);
                    break;
                case "cpf":
                    cpfCandidato = input.value;
                    break;
                case "estado":
                    estadoCandidato = input.value;
                    break;
                case "cep":
                    cepCandidato = input.value;
                    break;
                case "email":
                    emailCandidato = input.value;
                    break;
                case "descricao":
                    descricaoCandidato = input.value;
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
                competenciasCandidato.push(checkbox.value);
            } else {
                competenciasCandidato = competenciasCandidato.filter((competencia) => competencia !== checkbox.value);
            }
        });
    });
}

iniciarListenersCandidato();