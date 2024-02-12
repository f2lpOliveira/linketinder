import { CandidatoUsuario } from "../Models/CandidatoUsuario";
import { DBUsuario } from "./BDUsuario";

export class BDCandidato implements DBUsuario {
    add(candidato: CandidatoUsuario): void {
        localStorage.setItem(candidato.cpf, JSON.stringify(candidato));
    }
}