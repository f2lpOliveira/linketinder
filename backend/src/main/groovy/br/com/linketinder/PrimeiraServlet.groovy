package br.com.linketinder

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = '/primeiraServlet')
class PrimeiraServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter()
        writer.println("<html>")
        writer.println("<body>")
        writer.println("<h1>Essa é a minha primeira servlet!</h1>")
        writer.println("</body>")
        writer.println("</html>")
    }
}
