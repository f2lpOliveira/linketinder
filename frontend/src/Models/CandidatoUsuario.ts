import { Usuario } from "./Usuario";

export class CandidatoUsuario extends Usuario {
    constructor(
        public nome: string,
        public idade: number,
        public cpf: string,
        public estado: string,
        public cep: string,
        public email: string,
        public competencias: string[],
        public descricao: string
    ) {
        super(nome, estado, cep, email, competencias, descricao);
    }

    getObject() {
        return {
            nome: this.nome ,
            idade: this.idade ,
            cpf: this.cpf ,
            estado: this.estado ,
            cep: this.cep ,
            email: this.email ,
            competencias: this.competencias ,
            descricao: this.descricao
        }
    }
}