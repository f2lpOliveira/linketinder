package br.com.linketinder.dao

import br.com.linketinder.model.entity.Empresa
import groovy.sql.Sql

class EmpresaDAO {

    Sql sql = Sql.newInstance(ConexaoDAO.conexao())

    void dbCreate(Empresa empresa) {
        try {
            sql.execute("INSERT INTO empresas (nome, email, cnpj, pais, estado, cep, descricao) VALUES (?, ?, ?, ?, ?, ?, ?)", [empresa.nome, empresa.email, empresa.cnpj, empresa.pais, empresa.estado, empresa.cep, empresa.descricao])
            println("Empresa adicionada com sucesso!")
        } catch (Exception e) {
            println("Erro ao adicionar empresa: ${e.message}")
        }
    }

    List<Empresa> dbRead() {
        return sql.rows("SELECT * FROM empresas")
    }

    void dbUpdate(String cnpj, Empresa empresa) {
        try {
            sql.execute("UPDATE empresas SET nome = ?, email = ?, cnpj = ?, pais = ?, estado = ?, cep = ?, descricao = ? WHERE cnpj = ?", [
                    empresa.nome,
                    empresa.email,
                    empresa.cnpj,
                    empresa.pais,
                    empresa.estado,
                    empresa.cep,
                    empresa.descricao,
                    cnpj
            ])
            println("Empresa atualizada com sucesso!")
        } catch (Exception e) {
            println("Erro ao atualizar empresa: ${e.message}")
        }
    }

    void dbDelete(String cnpj) {
        try {
            sql.execute("DELETE FROM empresas WHERE cnpj = ?", [cnpj])
            println("Empresa removida com sucesso!")
        } catch (Exception e) {
            println("Erro ao remover empresa: ${e.message}")
        }
    }
}
