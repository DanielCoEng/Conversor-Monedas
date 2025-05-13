import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static <Pair> void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();
        TransformadorMoneda transformador = new TransformadorMoneda();
        NumberFormat formatoMoneda = NumberFormat.getInstance(Locale.US);

        // Clase Par
        class Par<K, V> {
            private final K primero;
            private final V segundo;

            public Par(K primero, V segundo) {
                this.primero = primero;
                this.segundo = segundo;
            }

            public K getPrimero() { return primero; }
            public V getSegundo() { return segundo; }
        }


        // Mapa de opciones: <NúmeroOpción, Par<MonedaBase, MonedaDestino>>
        Map<Integer, Par<String, String>> opciones = Map.of(
                1, new Par<>("USD", "ARS"),  // Dólar => Peso Argentino
                2, new Par<>("ARS", "BRL"),  // Peso Argentino => Real Brasileño
                3, new Par<>("USD", "BRL"),  // Dólar => Real Brasileño
                4, new Par<>("BRL", "USD"),  // Real Brasileño => Dólar
                5, new Par<>("USD", "COP"),  // Dólar => Peso Colombiano
                6, new Par<>("COP", "USD")   // Peso Colombiano => Dólar
        );


        while (true){
            TransformadorMoneda.exibirMenu();
            try {
                int opcion = sc.nextInt();
                if (opcion == 7) break;  // Salir

                if (!opciones.containsKey(opcion)) {
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    continue;
                }

                System.out.print("Ingresa el valor a convertir: ");
                double valor = sc.nextDouble();

                if (valor <= 0) {
                    System.out.println("El valor debe ser positivo.");
                    continue;
                }

                // Obtener monedas del Map
                Par<String, String> monedas = opciones.get(opcion);
                String monedaBase = monedas.getPrimero();
                String monedaDestino = monedas.getSegundo();

                // Llamar a la API
                try {
                    ConversorApi apiResponse = consultaApi.realizarConversion(valor, monedaBase, monedaDestino);
                    Conversor conversor = transformador.transformar(apiResponse);

                    // Mostrar resultado con formato
                    System.out.printf("\n %.2f [%s] = %s [%s]\n\n",
                            valor,
                            conversor.getMonedaBase(),
                            formatoMoneda.format(conversor.getValorConvertido()),
                            conversor.getMonedaAConvertir()
                    );
                } catch (IOException | InterruptedException e) {
                    System.out.println("Error al conectar con la API: " + e.getMessage());
                } catch (RuntimeException e) {
                    System.out.println("Error en la respuesta de la API: " + e.getMessage());
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        }
        System.out.println("¡Gracias por usar el Conversor!");
    }


}



