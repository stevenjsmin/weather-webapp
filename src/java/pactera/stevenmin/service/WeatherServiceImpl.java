package pactera.stevenmin.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pactera.framework.Ctx;
import pactera.stevenmin.model.Weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation class for the actions of Weather service interface.
 *
 * @author Steven
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    /**
     * Get current weather condition <br/>
     * Weather.city property is mandatory for get data
     *
     * @param weather
     * @return
     * @throws Exception
     */
    @Override
    public Weather getCurrentWeather(Weather weather) throws Exception {

        Weather aWeather = null;
        logger.info("Getting weather information : :" + weather.getName());

        String serviceUrl = Ctx.conf.getString("open-weather-map.url");
        String serviceApiKey = Ctx.conf.getString("open-weather-map.api.key");

        StringBuffer fullServiceUrl = new StringBuffer("");
        fullServiceUrl.append(serviceUrl);
        fullServiceUrl.append(weather.getName() + ",au");
        fullServiceUrl.append("&appid=" + serviceApiKey);
        logger.info("Weather webservice call : " + fullServiceUrl.toString());

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(fullServiceUrl.toString());
        HttpResponse response = client.execute(request);

        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();

            try {
                //Read the server response and attempt to parse it as JSON
                Reader reader = new InputStreamReader(content);

                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                Gson gson = gsonBuilder.create();


                aWeather = gson.fromJson(reader, Weather.class);

                SimpleDateFormat sdf = new SimpleDateFormat("E hh:mm a");
                String date = sdf.format(new Date(Long.parseLong(aWeather.getDt()) * 1000));
                aWeather.setDt(date);

                content.close();

            } catch (Exception e) {
                e.printStackTrace();
                aWeather = new Weather();
                aWeather.setMessage("Failure to set weather information :" + e.getMessage());
            }

        } else {
            aWeather = new Weather();
            aWeather.setMessage("Failure to set weather information");
        }

        return aWeather;
    }

}
