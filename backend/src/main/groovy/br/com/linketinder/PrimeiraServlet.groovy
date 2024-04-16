package br.com.linketinder

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.nio.charset.StandardCharsets

@WebServlet(urlPatterns = ["/linketinder", "/teste"])
class PrimeiraServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html")

        String htmlContent = getHtmlContent("html/index.html")

        PrintWriter out = resp.getWriter()
        out.println(htmlContent)
    }

    private String getHtmlContent(String path) throws IOException {
        InputStream inputStream = getServletContext().getResourceAsStream(path)
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))

        StringBuilder content = new StringBuilder()
        String line
        while ((line = reader.readLine()) != null) {
            content.append(line)
        }

        reader.close()
        return content.toString()
    }
}
