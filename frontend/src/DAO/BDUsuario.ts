import {CandidatoUsuario} from "../Models/CandidatoUsuario";

export interface DBUsuario {
    add(usuario: CandidatoUsuario): void
}