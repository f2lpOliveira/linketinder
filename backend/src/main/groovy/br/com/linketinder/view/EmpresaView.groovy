package br.com.linketinder.view

import br.com.linketinder.controller.CandidatoController
import br.com.linketinder.controller.EmpresaController
import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaView {

    CandidatoController candidatoController
    EmpresaController empresaController
    EmpresaDAO empresaDAO

    EmpresaView(){
        this.candidatoController = new CandidatoController()
        this.empresaController = new EmpresaController()
        this.empresaDAO = new EmpresaDAO()
    }

    void menuOpcoesEmpresa(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        Boolean condicao = true

        while (condicao) {

            exibirOpcoesEmpresa()
            String opcao = br.readLine()

            switch (opcao) {
                case '1':
                    empresaController.cadastrarEmpresa()
                    break
                case '2':
                    candidatoController.exibirMenuListarCandidatos()
                    break
                case '3':
                    empresaController.atualizarEmpresa()
                    break
                case '4':
                    empresaController.excluirEmpresa()
                    break
                case '0':
                    println ("")
                    condicao = false
                    break
                default:
                    println("Opção Inválida. Tente novamente!")
                    break
            }
        }

    }

    void menuCadastrarEmpresa() {
        Scanner scanner = new Scanner(System.in)

        print "\nDigite o nome da empresa: "
        String nome = scanner.nextLine()

        print "Digite o email da empresa: "
        String email = scanner.nextLine()

        print "Digite o CNPJ da empresa: "
        String cnpj = scanner.nextLine()

        print "Digite o país da empresa: "
        String pais = scanner.nextLine()

        print "Digite o estado da empresa: "
        String estado = scanner.nextLine()

        print "Digite o CEP da empresa: "
        String cep = scanner.nextLine()

        print "Digite a descrição da empresa: "
        String descricao = scanner.nextLine()

        print "Digite as competências da empresa (separadas por vírgula): "
        List<String> competencias = scanner.nextLine().split(',').collect { it.trim() }

        Empresa empresa = new Empresa(nome, email, cnpj, pais, estado, cep, descricao, competencias)
        empresaDAO.dbCreate(empresa)

        println("Cadastro efetuado com sucesso!")
    }

    void menuListarEmpresas() {
        List<Empresa> empresas = empresaDAO.dbRead()

        if (empresas.isEmpty()) {
            println "Não há empresas cadastradas."
        } else {
            println "Empresas cadastradas:"
            empresas.each { empresa ->
                print "Empresa: ${empresa.nome}\nEmail Corporativo: ${empresa.email}\nCNPJ: ${empresa.cnpj}\nPais: ${empresa.pais}\nEstado: ${empresa.estado}\nCEP: ${empresa.cep}\nDescrição da Empresa: ${empresa.descricao}\n\n"
            }
        }
    }

    void menuAtualizarEmpresa() {
        Scanner scanner = new Scanner(System.in)

        print "Digite o CNPJ da empresa que deseja atualizar: "
        String cnpj = scanner.nextLine()

        print "Digite o novo nome da empresa: "
        String nome = scanner.nextLine()

        print "Digite o novo email da empresa: "
        String email = scanner.nextLine()

        print "Digite o novo país da empresa: "
        String pais = scanner.nextLine()

        print "Digite o novo estado da empresa: "
        String estado = scanner.nextLine()

        print "Digite o novo CEP da empresa: "
        String cep = scanner.nextLine()

        print "Digite a nova descrição da empresa: "
        String descricao = scanner.nextLine()

        print "Digite as novas competências da empresa (separadas por vírgula): "
        List<String> competencias = scanner.nextLine().split(',').collect { it.trim() }

        Empresa empresa = new Empresa(nome, email, cnpj, pais, estado, cep, descricao, competencias)
        empresaDAO.dbUpdate(cnpj, empresa)

        println("Empresa atualizada com sucesso!")
    }

    void menuDeletarEmpresa() {
        Scanner scanner = new Scanner(System.in)

        print "Digite o CNPJ da empresa que deseja deletar: "
        String cnpj = scanner.nextLine()

        empresaDAO.dbDelete(cnpj)

        println("Cadastro removido com sucesso!")
    }

    void exibirOpcoesEmpresa(){
        print """
Escolha uma das opções a seguir:
1. Cadastrar
2. Listar Candidatos
3. Atualizar Cadastro
4. Excluir Cadastro
0. Voltar ao Menu Anterior
"""
    }
}
