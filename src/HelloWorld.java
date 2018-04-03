import java.net.*;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

class JsonResponse {
    class Coord {
        double lon;
        double lat;
    }

    Coord coord;

    class Weather {
        int id;
        String main;
        String description;
        String icon;
    }

    List<Weather> weather;
    private String base;

    class Temp {     //Main
        double temp;
        double pressure;
        double humidity;
        @SerializedName("temp_min")
        double tempMin;
        @SerializedName("temp_max")
        double tempMax;
    }

    Temp main = new Temp();

    public double getTemp() {
        return main.temp;
    }

    public String getVisability() {
        return visibility;
    }

    private String visibility;
    Wind wind;

    class Wind {
        private double speed;
        private double deg;
    }

    Clouds clouds;

    class Clouds {
        private int all;
    }

    private int dt;
    Sys sys;

    class Sys {
        private int type;
        private int id;
        private double message;
        private String country;
        private int sunrise;
        private int sunset;

    }

    private int id;
    private String name;
    private int cod;

    JsonResponse() {
        // no-args constructor
    }
}

/* Пример респонса
        {"coord":{"lon":-0.13,"lat":51.51},
        "weather":[{"id":300,"main":"Drizzle","description":"light intensity drizzle","icon":"09d"}],
        "base":"stations",
        "main":{"temp":280.32,"pressure":1012,"humidity":81,"temp_min":279.15,"temp_max":281.15},
        "visibility":10000,
        "wind":{"speed":4.1,"deg":80},
        "clouds":{"all":90},
        "dt":1485789600,
        "sys":{"type":1,"id":5091,"message":0.0103,"country":"GB","sunrise":1485762037,"sunset":1485794875},
        "id":2643743,"name":"London","cod":200}
         */
public class HelloWorld {
    public static void main(String[] args) {
        String api_url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=3dd9eb7d424e58b41dc86c4d60dc4273";
        String api_key = "3dd9eb7d424e58b41dc86c4d60dc4273";

        try {
            URL myURL = new URL(api_url);
            //URLConnection myURLConnection = myURL.openConnection();
            //myURLConnection.connect();
            HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();

            //myURLConnection.setRequestMethod("GET");

            BufferedReader oReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = oReader.readLine()) != null) {
                response.append(inputLine);
            }
            oReader.close();
            System.out.println(response.toString());
            Gson jsonParser = new Gson();
            //String json = jsonParser.toJson(response);
            //System.out.println(json.length());
            //System.out.println(json);
            JsonResponse jsonResponse = jsonParser.fromJson(response.toString(), JsonResponse.class);
            System.out.println(jsonParser.toJson(jsonResponse));
            System.out.println(jsonResponse.getTemp());


        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        //----------------+
        //                |
        //                |
        // ТУТ БЫЛ СТРЕЛЛ |
        //                |
        //                |
        //----------------+

    }
}
