import {CandidatoUsuario} from "../Models/CandidatoUsuario";

export class BDCandidato {
    add(candidato: any): void {
        let candidatos = this.get();
        candidatos.push(candidato);
        localStorage.setItem("candidatos", JSON.stringify(candidatos));
    }

    get(): CandidatoUsuario[] {
        const local = localStorage.getItem("candidatos");
        if (local) {
            return JSON.parse(local);
        } else {
            return [];
        }
    }
}
