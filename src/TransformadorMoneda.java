public class TransformadorMoneda {

    public Conversor transformar(ConversorApi conversorApi){
        return new Conversor(conversorApi);
    }

    public static void exibirMenu(){
        System.out.println("""
                **************************************************************************************
                sea Bienvenido al Conversor de Moneda =)
                
                
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Real Brasileño
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Salir
                Elija una opción válida
                **************************************************************************************
                """);
    }

}
