interface WeatherApp {
    void showTemp();
}

class ExternalWeatherAPI {
    void getTemperatureInFahrenheit() {
        System.out.println("Temperature: 86°F");
    }
}

class WeatherAdapter implements WeatherApp {
    ExternalWeatherAPI api = new ExternalWeatherAPI();

    public void showTemp() {
        api.getTemperatureInFahrenheit();
    }
}

public class AdapterExample5_Weather {
    public static void main(String[] args) {
        WeatherApp app = new WeatherAdapter();
        app.showTemp();
    }
}