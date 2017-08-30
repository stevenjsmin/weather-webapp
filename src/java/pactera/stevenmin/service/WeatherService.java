package pactera.stevenmin.service;

import pactera.stevenmin.model.Weather;

/**
 * Define actions/operations for Weather service
 *
 * @author Steven
 */
public interface WeatherService {

    /**
     * Get current weather condition <br/>
     * Weather.city property is mandatory for get data
     *
     * @param weather
     * @return
     * @throws Exception
     */
    public Weather getCurrentWeather(Weather weather) throws Exception;
}
