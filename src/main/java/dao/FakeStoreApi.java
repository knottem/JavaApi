package dao;

import com.google.gson.Gson;
import model.Products;
import utility.PropertiesLoader;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

public class FakeStoreApi {

    Gson gson = new Gson();
    HttpClient client = HttpClient.newHttpClient();

    PropertiesLoader prop = new PropertiesLoader();

    private HttpRequest getRequest(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }

    public Products getProduct(int id){
        try{
            HttpResponse<String> response = client.send(getRequest(prop.getFakeStoreServer() + id), HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Products.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Products> getAllProducts(){
        try{
            HttpResponse<String> response = client.send(getRequest(prop.getFakeStoreServer()), HttpResponse.BodyHandlers.ofString());
            Products[] products = gson.fromJson(response.body(), Products[].class);
            return new ArrayList<>(Arrays.asList(products));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
