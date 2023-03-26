

import model.Products;
import model.Weather;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        FakeStoreApi api = new FakeStoreApi();
        WeatherApi weatherApi = new WeatherApi();

        Weather weather = weatherApi.getWeather();

        Scanner scan = new Scanner(System.in);


        System.out.println("Enter a product id: ");
        int id = scan.nextInt();
        Products product1 = api.getProduct(id);
        System.out.println(product1);

        System.out.println("Which hour do you want to see the weather for? (0-23)");
        int hour = scan.nextInt();
        LocalDateTime time = weather.getHourly().getTime().get(hour);
        System.out.println(time);
        System.out.println(weather.getHourly().getTemperature_2m().get(hour) + " degrees Celsius");


    }

}
