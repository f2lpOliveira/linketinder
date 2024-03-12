package br.com.linketinder.model

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaModel {

    EmpresaDAO empresaDAO = new EmpresaDAO()

    void create() {
        Scanner scanner = new Scanner(System.in)

        print "Digite o nome da empresa: "
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
    }

    void read() {
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

    void update() {
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
    }

    void delete() {
        Scanner scanner = new Scanner(System.in)

        print "Digite o CNPJ da empresa que deseja deletar: "
        String cnpj = scanner.nextLine()

        empresaDAO.dbDelete(cnpj)
    }
}

