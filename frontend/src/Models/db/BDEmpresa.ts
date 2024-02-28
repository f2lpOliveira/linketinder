import {CandidatoEmpresa} from "../CandidatoEmpresa";

export class BDEmpresa {
    add(empresa: any): void {
        let empresas = this.get();
        empresas.push(empresa);
        localStorage.setItem("empresas", JSON.stringify(empresas));
    }

    get(): CandidatoEmpresa[] {
        const local = localStorage.getItem("empresas");
        if (local) {
            return JSON.parse(local);
        } else {
            return [];
        }
    }
}
