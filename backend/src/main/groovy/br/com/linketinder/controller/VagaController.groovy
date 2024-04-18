package br.com.linketinder.controller

import br.com.linketinder.model.entity.Vaga
import br.com.linketinder.service.DataProcessorService
import br.com.linketinder.service.VagaService

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/vaga", "/vaga/cadastrar"])
class VagaController extends HttpServlet {

    VagaService vagaService = new VagaService()
    DataProcessorService dataProcessorService = new DataProcessorService()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain;charset=UTF-8")

            StringBuilder json = dataProcessorService.readJsonRequest(request)

            Vaga vaga = dataProcessorService.converterJsonToObject(json.toString(), Vaga.class)

            vagaService.setVagaDAO(vaga)

        }catch (Exception e) {
            e.printStackTrace()
        }
    }






    void exibirFormularioCadastrarVaga() {
        vagaView.formularioCadastrarVaga()
    }

    void listarVagas() {
        vagaView.listarVagas()
    }

    void exibirFormularioCadastrarVagaEmpresa() {
       vagaView.opcaoCadastroEmpresaVaga()
    }


}
