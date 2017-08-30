package pactera.stevenmin.model;

import pactera.stevenmin.model.gson.Coord;
import pactera.stevenmin.model.gson.Main;
import pactera.stevenmin.model.gson.Wind;

import java.util.List;

/**
 * This is model for Weather.
 * It designed for compatibility of GSON for parsing feeding data from webserviceß
 */
public class Weather {

    private String name;
    private String code;
    private Coord coord;
    private List<pactera.stevenmin.model.gson.Weather> weather;
    private Main main;
    private Wind wind;
    private String dt;
    private String message;

    public Weather() {
    }

    public Weather(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<pactera.stevenmin.model.gson.Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<pactera.stevenmin.model.gson.Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
