import java.net.*;
import java.io.*;
import java.util.Map;

import com.google.gson.Gson;
class JsonResponse {
    class Coord{
        private String lon;
        private String lat;
    }
    class Weather{
        private int id;
        private String main;
        private String description;
        private String icon;
    }
    private String base;
    static class main{     //Main
        private  double temp;
        private double pressure;
        private double humidity;
        private double tempMin;
        private double tempMax;
        //private double sea_level;
        //private double grnd_level;
        public double getTemp() {
            return temp;
        }
    }
    public String getVisability(){
        return visibility;
    }
    private String visibility;
    class Wind{
        private double speed;
        private double deg;
    }
    class Clouds{
        private int clouds;
    }
//    class Rain{
//        private int rain;
//    }
//    class Snow{
//        private int rain;
//    }
    private int dt;

    class Sys{
        private int type;
        private int id;
        private int message;
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
            while ((inputLine = oReader.readLine())!=null){
                response.append(inputLine);
            }
            oReader.close();
            System.out.println(response.toString());
            Gson jsonParser = new Gson();
            //String json = jsonParser.toJson(response);
            //System.out.println(json.length());
            //System.out.println(json);
            JsonResponse jsonResponse = jsonParser.fromJson(response.toString(),JsonResponse.class);
            System.out.println(jsonResponse.getVisability());


        }
        catch (MalformedURLException e) {
            System.out.println("MalformedURLException");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }



    }
}
