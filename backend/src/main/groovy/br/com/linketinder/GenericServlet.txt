package br.com.linketinder

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.nio.charset.StandardCharsets

@WebServlet(urlPatterns = "/linketinder/*")
class GenericServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html")

        String pathInfo = req.getPathInfo()
        if (pathInfo == null || pathInfo.equals("/")) {
            pathInfo = "index.html"
        }

        String htmlContent = getHtmlContent("html" + pathInfo)

        PrintWriter out = resp.getWriter()
        out.println(htmlContent)
    }

    private String getHtmlContent(String path) throws IOException {
        InputStream inputStream = getServletContext().getResourceAsStream(path)
        if (inputStream == null) {
            throw new IOException("Arquivo não encontrado: " + path)
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder content = new StringBuilder()
            String line
            while ((line = reader.readLine()) != null) {
                content.append(line)
            }
            return content.toString()
        }
    }
}
