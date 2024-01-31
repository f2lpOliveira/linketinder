package br.com.linketinder.cadastro

import br.com.linketinder.candidato.Candidato
import br.com.linketinder.empresa.Empresa

class Cadastro {

    List<Candidato> candidatos= []
    List<Empresa> empresas= []

    void cadastrarCandidato(Candidato candidato){
        candidatos.add(candidato)
    }

    void cadastrarEmpresa(Empresa empresa){
        empresas.add(empresa)
    }
}
