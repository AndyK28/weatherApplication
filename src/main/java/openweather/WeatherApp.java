package openweather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.github.cdimascio.dotenv.Dotenv;

public class WeatherApp {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        String cityName = "Johannesburg";

        try {
            // URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=" + cityId + "&appid=" + apiKey);
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
