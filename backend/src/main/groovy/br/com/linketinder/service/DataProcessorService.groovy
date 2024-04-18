package br.com.linketinder.service

import br.com.linketinder.model.entity.Candidato
import com.google.gson.Gson

import javax.servlet.http.HttpServletRequest
import java.nio.charset.StandardCharsets

class DataProcessorService {

    StringBuilder readJsonRequest(HttpServletRequest request) {
        StringBuilder json = new StringBuilder()

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))) {
            String line
            while ((line = reader.readLine()) != null) {
                json.append(line)
            }
        } catch (Exception e) {
            return e.printStackTrace()
        }
        return json
    }

    <T> T converterJsonToObject(String json, Class<T> tipo) {
        Gson gson = new Gson()
        return gson.fromJson(json, tipo)
    }
}
