package br.com.linketinder.cadastro

import br.com.linketinder.candidato.Candidato

class Cadastro {

    List<Candidato> candidatos= []

    void cadastrarCandidato(Candidato candidato){
        candidatos.add(candidato)
    }
}
