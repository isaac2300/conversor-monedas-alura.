package calculos;

public class Configuracion {
    // Reemplaza el texto dentro de las comillas por tu llave real de ExchangeRate-API
    private static final String API_KEY = "";

    public static String obtenerUrl(String monedaBase) {
        // Esta es la URL dinámica que pide el Trello
        return "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaBase;
    }
}