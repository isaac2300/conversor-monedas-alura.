# 💱 Conversor de Monedas - Challenge Alura Latam

Este es un proyecto de consola desarrollado en Java como parte del Challenge de Alura Latam y Oracle Next Education (ONE). El programa permite realizar conversiones de moneda en tiempo real consumiendo una API externa.

## ✨ Características
- **Consumo de API:** Utiliza `HttpClient` para obtener tasas de cambio en tiempo real de *ExchangeRate-API*.
- **Manipulación de JSON:** Implementa la librería `Gson` para el mapeo de datos.
- **Estructura Moderna:** Uso de `Records` y manejo de excepciones.
- **Historial:** Guarda un registro de las conversiones realizadas con fecha y hora.

## 🛠️ Tecnologías utilizadas
- Java 17+
- IntelliJ IDEA
- Librería GSON 2.10.1
- [ExchangeRate-API](https://www.exchangerate-api.com/)

## 🚀 Instalación y uso
1. Clona este repositorio.
2. Obtén tu propia API Key en [ExchangeRate-API](https://www.exchangerate-api.com/).
3. Coloca tu clave en la clase `Configuracion.java` en la variable `API_KEY`.
4. Ejecuta la clase `Principal.java`.

## 📌 Requisitos de Trello cumplidos
- [x] Configuración del entorno Java.
- [x] Creación del menú interactivo.
- [x] Conexión con la API de tasas de cambio.
- [x] Análisis de respuestas JSON con Gson.
- [x] Registro de log de consultas (Historial).
- 