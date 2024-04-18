package br.com.linketinder.controller

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.service.CandidatoService
import br.com.linketinder.service.DataProcessorService

import javax.servlet.ServletException

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/candidato", "/candidato/cadastrar"])
class CandidatoController extends HttpServlet {

    CandidatoService candidatoService = new CandidatoService()
    DataProcessorService dataProcessorService = new DataProcessorService()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain;charset=UTF-8")

            StringBuilder json = dataProcessorService.readJsonRequest(request)

            Candidato candidato = dataProcessorService.converterJsonToObject(json.toString(), Candidato.class)

            candidatoService.inserirCandidatoDAO(candidato)

        }catch (Exception e){
            e.printStackTrace()
        }
    }
}
