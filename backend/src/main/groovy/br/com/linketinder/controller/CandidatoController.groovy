package br.com.linketinder.controller

import br.com.linketinder.model.entity.Candidato
import br.com.linketinder.service.CandidatoService
import br.com.linketinder.service.DataProcessorService

import javax.servlet.ServletException

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet (urlPatterns = ["/candidato", "/candidato/cadastrar"])
class CandidatoController extends HttpServlet {

    CandidatoService candidatoService = new CandidatoService()
    DataProcessorService dataProcessorFacade = new DataProcessorService()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            response.setContentType("text/plain;charset=UTF-8")

            StringBuilder json = dataProcessorFacade.readJsonRequest(request)

            Candidato candidato = dataProcessorFacade.converterJsonToObject(json.toString(), Candidato.class)

            candidatoService.inserirCandidatoDAO(candidato)

        }catch (Exception e){
            e.printStackTrace()
        }
    }

















    void exibirFormularioCadastrarCandidato() {
        interacaoCandidatoView.formularioCadastrarCandidato()
    }

    void listarCandidatos() {
        interacaoCandidatoView.listarCandidatos()
    }

    void exibirFormularioAtualizarCandidato() {
        interacaoCandidatoView.formularioAtualizarCandidato()
    }

    void exibirFormularioDeletarCandidato() {
        interacaoCandidatoView.deletarCandidato()
    }

    List<Candidato> listarCandidatosDAO() {
        return candidatoDAO.dbRead()
    }

    void atualizarCandidatoDAO(String cpf, Candidato candidato) {
        candidatoDAO.dbUpdate(cpf, candidato)
    }

    boolean deletarCandidatoDAO(String cpf) {
        return candidatoDAO.dbDelete(cpf)
    }
}
