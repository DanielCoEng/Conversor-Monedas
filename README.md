<h1 align="center">💰 Conversor de Divisas con API</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-blue" alt="Java">
</p>

<h2>📌 Descripción</h2>
<p>Aplicación de línea de comandos que permite realizar conversiones de divisas en tiempo real utilizando la API de ExchangeRate-API. Soporta conversiones entre dólar (USD), peso argentino (ARS), real brasileño (BRL) y peso colombiano (COP).</p>

<h2>🛫 Ejemplo de Uso: </h2>



https://github.com/user-attachments/assets/79aa4504-7fdf-49ef-a6ce-8179059c6968




<h2>🚀 Características</h2>
<ul>
  <li>Consulta de tasas de cambio en tiempo real</li>
  <li>Interfaz de usuario intuitiva en consola</li>
  <li>Manejo de errores robusto</li>
  <li>Formateo profesional de cantidades monetarias</li>
  <li>Arquitectura limpia y modular</li>
</ul>

<h2>🛠 Estructura del Proyecto</h2>
<pre>
src/
├── main/
│   ├── java/
│   │   ├── Main.java            # Punto de entrada principal
│   │   ├── ConsultaApi.java     # Cliente para la API de divisas
│   │   ├── Conversor.java       # Modelo de datos para conversiones
│   │   ├── ConversorApi.java    # Record para respuesta de la API
│   │   └── TransformadorMoneda.java # Adaptador de datos
</pre>

<h2>📦 Dependencias</h2>
<ul>
  <li>Java 17+</li>
  <li>Gson (para parseo de JSON)</li>
  <li>HttpClient (incluido en Java 11+)</li>
</ul>

<h2>🔧 Configuración</h2>
<ol>
  <li>Obtener una API key gratuita de <a href="https://www.exchangerate-api.com/">ExchangeRate-API</a></li>
  <li>Reemplazar la clave en <code>ConsultaApi.java</code>:
    <pre>String url = "https://v6.exchangerate-api.com/v6/TU_API_KEY/pair/...";</pre>
  </li>
</ol>

<h2>💻 Uso</h2>
<ol>
  <li>Compilar y ejecutar el proyecto:
    <pre>javac Main.java
java Main</pre>
  </li>
  <li>Seleccionar una opción del menú:
    <pre>
*********************************************************************
Bienvenido al Conversor de Moneda =)

1) Dólar => Peso Argentino
2) Peso Argentino => Real Brasileño
3) Dólar => Real brasileño
4) Real brasileño => Dólar
5) Dólar => Peso Colombiano
6) Peso Colombiano => Dólar
7) Salir
*********************************************************************</pre>
  </li>
  <li>Ingresar el valor a convertir y ver el resultado:
    <pre>Ingresa el valor a convertir: 100

100.00 [USD] = 850.50 [ARS]</pre>
  </li>
</ol>

<h2>📚 Documentación de Clases</h2>

<h3><code>ConsultaApi.java</code></h3>
<pre><code>/**
 * Cliente para la API de ExchangeRate
 * @throws IOException Si hay error de conexión
 * @throws InterruptedException Si la conexión es interrumpida
 */
public ConversorApi realizarConversion(double valor, String codigoBase, String codigoConversion) 
    throws IOException, InterruptedException {
    // Implementación...
}</code></pre>

<h3><code>TransformadorMoneda.java</code></h3>
<pre><code>/**
 * Adapta los datos de la API al modelo de la aplicación
 */
public Conversor transformar(ConversorApi conversorApi) {
    return new Conversor(conversorApi);
}</code></pre>


<h2>🤝 Contribuciones</h2>
<p>Las contribuciones son bienvenidas.</p>



<div align="center">
  <sub>Creado por J. Daniel Cortes</sub>
</div>
