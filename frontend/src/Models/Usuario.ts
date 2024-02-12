export abstract class Usuario {
    constructor(
        public nome: string,
        public estado: string,
        public cep: string,
        public email: string,
        public competencias: string[],
        public descricao: string
    ) {}

    abstract getObject(): void
}
