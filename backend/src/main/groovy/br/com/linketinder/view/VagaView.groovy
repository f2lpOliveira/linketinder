package br.com.linketinder.view

import br.com.linketinder.controller.VagaController
import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.tools.Tools

class VagaView {

    VagaController vagaController = new VagaController()
    Tools tools = new Tools()

    void formularioCadastrarVaga() {

        print "\nDigite o nome da vaga: "
        String nome = tools.entradaDados()

        print "Digite o estado da vaga: "
        String estado = tools.entradaDados()

        print "Digite o CEP da vaga: "
        String cep = tools.entradaDados()

        print "Digite a descrição da vaga: "
        String descricao = tools.entradaDados()

        print "Digite as competências da vaga (separadas por vírgula): "
        List<String> competencias = Arrays.asList(tools.entradaDados().split(',')).collect { it.trim() }

        Vaga vaga = new Vaga(nome, estado, cep, descricao, competencias)

        vagaController.setVagaDAO(vaga)

        println("Cadastro efetuado com sucesso!")
    }
}
