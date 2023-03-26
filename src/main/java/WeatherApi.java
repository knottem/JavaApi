import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Weather;
import utility.LocalDateTimeDeserializer;
import utility.PropertiesLoader;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class WeatherApi {



    HttpClient client = HttpClient.newHttpClient();

    PropertiesLoader prop = new PropertiesLoader();

    private HttpRequest getRequest(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }

    public Weather getWeather(){
        HttpRequest request = getRequest(prop.getWeatherServer());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .create();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Weather.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
