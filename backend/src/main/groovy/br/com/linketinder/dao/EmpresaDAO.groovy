package br.com.linketinder.dao

import br.com.linketinder.model.entity.Empresa
import groovy.sql.Sql

class EmpresaDAO {

    Sql sql = Sql.newInstance(ConexaoDAO.conexao())

    void dbCreate(Empresa empresa) {
        try {
            sql.execute("INSERT INTO empresas (nome, email, cnpj, pais, estado, cep, descricao) VALUES (?, ?, ?, ?, ?, ?, ?)", [empresa.nome, empresa.email, empresa.cnpj, empresa.pais, empresa.estado, empresa.cep, empresa.descricao])
        } catch (Exception e) {
            e.printStackTrace()
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
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    void dbDelete(String cnpj) {
        try {
            sql.execute("DELETE FROM empresas WHERE cnpj = ?", [cnpj])
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
