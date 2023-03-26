package main;

import dao.FakeStoreApi;
import dao.WeatherApi;
import model.Weather;
import view.InputView;

public class InitApiProgram {

    public void Program() {

        FakeStoreApi api = new FakeStoreApi();
        WeatherApi weatherApi = new WeatherApi();
        Weather weather = weatherApi.getWeather();

        System.out.println("Welcome to the Simple Api Client");
        while (true) {
            System.out.print("1. Get all products\n" +
                    "2. Get product by id\n" +
                    "3. Get weather by hour\n" +
                    "4. Exit\n");
            switch(InputView.getInputView().inputInt("", false)) {
                case 1 -> System.out.println(api.getAllProducts());
                case 2 -> System.out.println(api.getProduct(InputView.getInputView().inputInt("Enter id", true)) + "\n");
                case 3 -> {
                    int dayInt = 0;
                    String day = InputView.getInputView().inputString("Get the temperature for today or tomorrow?", true);
                    if(day.equalsIgnoreCase("tomorrow")) {
                        dayInt = 24;
                        System.out.println("Getting temperature for tomorrow");
                    } else if(day.equalsIgnoreCase("today")) {
                        System.out.println("Getting temperature for today");
                    } else {
                        System.out.println("Invalid input, defaulting to today");
                    }
                    System.out.println(weather.getHourly().getTemperature_2m().get(dayInt+InputView.getInputView().inputInt("Enter hour (0-23)", true)) + "°C");
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid input");
            }
        }
    }
}
