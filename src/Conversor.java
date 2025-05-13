public class Conversor {

    private String monedaBase;
    private  String monedaAConvertir;
    private Double valorAConvertir;
    private Double valorConvertido;


    public Conversor(ConversorApi conversorApi) {
        this.monedaBase = conversorApi.base_code();
        this.monedaAConvertir = conversorApi.target_code();
        this.valorConvertido = conversorApi.conversion_result();
    }




    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public void setMonedaAConvertir(String monedaAConvertir) {
        this.monedaAConvertir = monedaAConvertir;
    }

    public void setValorAConvertir(Double valorAConvertir) {
        this.valorAConvertir = valorAConvertir;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public Double getValorAConvertir() {
        return valorAConvertir;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }
}
