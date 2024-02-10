interface CadastroEmpresa {
    nome: string;
    email: string;
    cnpj: string;
    pais: string;
    estado: string;
    cep: string;
    descricao: string;
    competencias: string[];
}

function validarCamposObrigatoriosEmpresa(
    nomeEmpresa: string,
    emailEmpresa: string,
    cnpjEmpresa: string,
    paisEmpresa: string,
    estadoEmpresa: string,
    cepEmpresa: string,
    descricaoEmpresa: string,
    competenciasEmpresa: string[]
): boolean {
    return (
        nomeEmpresa !== "" &&
        emailEmpresa !== "" &&
        cnpjEmpresa !== "" &&
        paisEmpresa !== "" &&
        estadoEmpresa !== "" &&
        cepEmpresa !== "" &&
        competenciasEmpresa.length > 0 &&
        descricaoEmpresa !== ""
    );
}

function armazenarDadosEmpresa(empresa: CadastroEmpresa): void {
    localStorage.setItem(empresa.cnpj, JSON.stringify(empresa));
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

let nomeEmpresa: string = "";
let emailEmpresa: string = "";
let cnpjEmpresa: string = "";
let paisEmpresa: string = "";
let estadoEmpresa: string = "";
let cepEmpresa: string = "";
let competenciasEmpresa: string[] = [];
let descricaoEmpresa: string = "";

const formEmpresa: HTMLFormElement | null = document.forms.namedItem("form2");
formEmpresa?.addEventListener("submit", (event) => {
    event.preventDefault();

    if (validarCamposObrigatoriosEmpresa(nomeEmpresa, emailEmpresa, cnpjEmpresa, paisEmpresa, estadoEmpresa, cepEmpresa, descricaoEmpresa, competenciasEmpresa)) {
        const empresa: CadastroEmpresa = {
            nome: nomeEmpresa,
            cnpj: cnpjEmpresa,
            pais: paisEmpresa,
            estado: estadoEmpresa,
            cep: cepEmpresa,
            email: emailEmpresa,
            descricao: descricaoEmpresa,
            competencias: competenciasEmpresa
        };

        armazenarDadosEmpresa(empresa);

        alert("Cadastro realizado com sucesso!");

        window.location.href = `perfilEmpresa.html?cnpj=${encodeURIComponent(cnpjEmpresa)}`;
    } else {
        alert("Por favor, preencha todos os campos obrigatórios.");
    }
});

iniciarListenersEmpresa();