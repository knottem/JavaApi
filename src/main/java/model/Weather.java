package model;
import java.time.LocalDateTime;
import java.util.List;

public class Weather {

    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private double elevation;
    private HourlyUnits hourly_units;
    private Hourly hourly;

    public static class HourlyUnits {
        private String time;
        private String temperature_2m;
    }

    public static class Hourly {
        private List<LocalDateTime> time;
        private List<Double> temperature_2m;

        public List<LocalDateTime> getTime() {
            return time;
        }
        public List<Double> getTemperature_2m() {
            return temperature_2m;
        }

    }

    public Hourly getHourly() {
        return hourly;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", generationtime_ms=" + generationtime_ms +
                ", utc_offset_seconds=" + utc_offset_seconds +
                ", timezone='" + timezone + '\'' +
                ", timezone_abbreviation='" + timezone_abbreviation + '\'' +
                ", elevation=" + elevation +
                ", hourly_units=" + hourly_units +
                ", hourly=" + hourly +
                '}';
    }
}
