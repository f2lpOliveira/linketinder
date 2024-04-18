package br.com.linketinder.service

import br.com.linketinder.dao.EmpresaDAO
import br.com.linketinder.model.entity.Empresa

class EmpresaService {

    EmpresaDAO empresaDAO = new EmpresaDAO()

    void inserirEmpresaDAO(Empresa empresa) {
        empresaDAO.dbCreate(empresa)
    }
}
