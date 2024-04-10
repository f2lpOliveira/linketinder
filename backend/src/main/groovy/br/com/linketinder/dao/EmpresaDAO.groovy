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

    boolean dbDelete(String cnpj) {
        try {
            Integer empid = obterIdEmpresa(cnpj)
            if (empid != null) {
                sql.execute("DELETE FROM empresas WHERE cnpj = ?", [cnpj])
                return true
            } else {
                return false
            }
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    Integer obterIdEmpresa(String cnpj) {
        try {
            return sql.firstRow("SELECT empid FROM empresas WHERE cnpj = ?", [cnpj]).empid
        } catch (Exception e) {
            e.printStackTrace()
            return 0
        }
    }
}
