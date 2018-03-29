import java.net.*;
import java.io.*;


public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        String api_url = "http://api.openweathermap.org/data/2.5/weather";
        String api_key = "3dd9eb7d424e58b41dc86c4d60dc4273";

        /* пример готового URL
        http://openweathermap.org/data/2.5/weather?q=London,uk&appid=3dd9eb7d424e58b41dc86c4d60dc4273
         */

        try {
            URL myURL = new URL(api_url);
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
        }
        catch (MalformedURLException e) {
            System.out.println("MalformedURLException");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }
        /* Пример респонса
        {"coord":{"lon":-0.13,"lat":51.51},
        "weather":[{"id":300,"main":"Drizzle","description":"light intensity drizzle","icon":"09d"}],
        "base":"stations",
        "main":{"temp":280.32,"pressure":1012,"humidity":81,"temp_min":279.15,"temp_max":281.15},
        "visibility":10000,"wind":{"speed":4.1,"deg":80},
        "clouds":{"all":90},"dt":1485789600,
        "sys":{"type":1,"id":5091,"message":0.0103,"country":"GB","sunrise":1485762037,"sunset":1485794875},
        "id":2643743,"name":"London","cod":200}
         */





    }
}
