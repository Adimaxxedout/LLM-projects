import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherFetcher {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java WeatherFetcher <city>");
            return;
        }
        String city = args[0];
        String apiUrl = "https://wttr.in/" + city + "?format=3";
        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }
}