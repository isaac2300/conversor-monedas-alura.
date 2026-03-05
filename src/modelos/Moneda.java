package modelos;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Record que representa la respuesta de la API.
 * Mapea el campo "conversion_rates" del JSON a un Map de Java.
 */
public record Moneda(
        @SerializedName("conversion_rates") Map<String, Double> tasasDeConversion
) {
}