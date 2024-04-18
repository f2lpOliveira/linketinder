package br.com.linketinder.controller

import br.com.linketinder.model.entity.Empresa
import br.com.linketinder.service.EmpresaService
import br.com.linketinder.service.DataProcessorService

import javax.servlet.ServletException

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/empresa", "/empresa/cadastrar"])
class EmpresaController extends HttpServlet {

    EmpresaService empresaService = new EmpresaService()
    DataProcessorService dataProcessorService = new DataProcessorService()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain;charset=UTF-8")

            StringBuilder json = dataProcessorService.readJsonRequest(request)

            Empresa empresa = dataProcessorService.converterJsonToObject(json.toString(), Empresa.class)

            empresaService.inserirEmpresaDAO(empresa)

        }catch (Exception e){
            e.printStackTrace()
        }
    }
}
