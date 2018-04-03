import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    Temp main;

    public double getTemp() {
        return main.temp;
    }

    private String visibility;
    Wind wind;

    public double getWindSpeed() {
        return wind.speed;
    }

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