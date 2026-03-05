package principal;

import calculos.ConsultaMoneda;
import modelos.Moneda;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        List<String> historial = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        int opcion = 0;
        String menu = """
                ***************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar (USD)          =>> Peso argentino (ARS)
                2) Peso argentino (ARS) =>> Dólar (USD)
                3) Dólar (USD)          =>> Real brasileño (BRL)
                4) Real brasileño (BRL) =>> Dólar (USD)
                5) Dólar (USD)          =>> Peso colombiano (COP)
                6) Peso colombiano (COP) =>> Dólar (USD)
                7) Salir
                
                Elija una opción válida:
                ***************************************************
                """;

        while (opcion != 7) {
            try {
                System.out.println(menu);
                String entrada = lectura.nextLine();
                opcion = Integer.parseInt(entrada);

                if (opcion == 7) break;

                String monedaBase = "";
                String monedaDestino = "";

                // Selección de monedas según la opción del menú
                switch (opcion) {
                    case 1 -> { monedaBase = "USD"; monedaDestino = "ARS"; }
                    case 2 -> { monedaBase = "ARS"; monedaDestino = "USD"; }
                    case 3 -> { monedaBase = "USD"; monedaDestino = "BRL"; }
                    case 4 -> { monedaBase = "BRL"; monedaDestino = "USD"; }
                    case 5 -> { monedaBase = "USD"; monedaDestino = "COP"; }
                    case 6 -> { monedaBase = "COP"; monedaDestino = "USD"; }
                    default -> {
                        System.out.println("⚠️ Opción no válida. Intente de nuevo.");
                        continue;
                    }
                }

                System.out.println("Ingrese el valor que desea convertir:");
                double valorAConvertir = Double.parseDouble(lectura.nextLine());

                // Llamada a la API (HttpClient / GSON)
                Moneda datosApi = consulta.buscarMoneda(monedaBase);

                // Verificación y Cálculo (Map y Tasas)
                if (datosApi.tasasDeConversion().containsKey(monedaDestino)) {
                    double tasa = datosApi.tasasDeConversion().get(monedaDestino);
                    double resultadoFinal = valorAConvertir * tasa;

                    String mensajeResultado = String.format("El valor %.2f [%s] corresponde a =>>> %.2f [%s]",
                            valorAConvertir, monedaBase, resultadoFinal, monedaDestino);

                    System.out.println("\n---------------------------------------------------");
                    System.out.println(mensajeResultado);
                    System.out.println("---------------------------------------------------\n");

                    // Guardado en Historial con Fecha (Paso Extra/Bonus)
                    historial.add(dtf.format(LocalDateTime.now()) + " - " + mensajeResultado);
                } else {
                    System.out.println("❌ No se encontró la tasa para la moneda destino.");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido para el valor o la opción.");
            } catch (Exception e) {
                System.out.println("❌ Ocurrió un error: " + e.getMessage());
            }
        }

        // Mostrar resumen final antes de salir
        if (!historial.isEmpty()) {
            System.out.println("\n--- RESUMEN DE CONVERSIONES REALIZADAS ---");
            historial.forEach(System.out::println);
        }
        System.out.println("\nGracias por usar el conversor. ¡Cerrando programa!");
    }
}