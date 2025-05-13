import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {


    public ConversorApi realizarConversion(double valor, String codigoBase, String codigoConversion ) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/eac8625c904132b882c3d3b9/pair/"+codigoBase + "/"+codigoConversion +"/" +valor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        //System.out.println(json);

        Gson gson = new GsonBuilder().setFieldNamingPolicy
                        (FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .setPrettyPrinting().create();

        return gson.fromJson(json, ConversorApi.class);
    }

}
