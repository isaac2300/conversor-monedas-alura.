package calculos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Moneda;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscarMoneda(String monedaBase) {
        // Usamos la URL dinámica de tu clase Configuracion
        URI direccion = URI.create(Configuracion.obtenerUrl(monedaBase));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Configuración avanzada de GSON según sugerencias de Trello
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            return gson.fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error: No se pudo conectar a la API. " + e.getMessage());
        }
    }
}