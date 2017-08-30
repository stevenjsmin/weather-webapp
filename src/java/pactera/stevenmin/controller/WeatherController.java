package pactera.stevenmin.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pactera.framework.Ctx;
import pactera.framework.uitl.html.Option;
import pactera.framework.uitl.html.Properties;
import pactera.stevenmin.model.Weather;
import pactera.stevenmin.service.WeatherService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Weather main service Controller
 *
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/index")
    public ModelAndView main() throws Exception {
        ModelAndView mav = new ModelAndView("index");
        Properties htmlProperty = new Properties();
        List<Option> cityOptions = new ArrayList<Option>();

        List<Object> cities = (List<Object>) Ctx.conf.getList("cities");
        for (Object city : cities) {
            cityOptions.add(new Option(city.toString(), city.toString()));
        }
        htmlProperty = new Properties("cityName");
        htmlProperty.setCssClass("form-control");
        htmlProperty.setCssStyle("width: 200px;");
        mav.addObject("cbxCityName", this.generateCmbx(cityOptions, htmlProperty));


        return mav;
    }

    @RequestMapping(value = "/currentWeather", produces = "application/json")
    @ResponseBody
    public Map<String, Object> currentWeather(HttpServletRequest request) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        Weather aWeather = null;

        String cityName = request.getParameter("cityName");
        if (StringUtils.isBlank(cityName)) {
            cityName = "Melbourne";
        }

        try {
            aWeather = weatherService.getCurrentWeather(new Weather(cityName));

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.put("weather", aWeather);
        model.put("weatherDetail", StringUtils.capitalize(aWeather.getWeather().get(0).getDescription()));

        return model;
    }

    private String generateCmbx(List<Option> options, Properties property) {
        StringBuffer selectHtml = new StringBuffer("<select ");
        if (StringUtils.isNotBlank(property.getId())) selectHtml.append("id='" + property.getId() + "' ");
        if (StringUtils.isNotBlank(property.getName())) selectHtml.append("name='" + property.getName() + "' ");
        if (StringUtils.isNotBlank(property.getCssClass()))
            selectHtml.append("class='" + property.getCssClass() + "' ");
        if (StringUtils.isNotBlank(property.getCssStyle()))
            selectHtml.append("style='" + property.getCssStyle() + "' ");
        if (StringUtils.isNotBlank(property.getOnclick()))
            selectHtml.append("onclick='" + property.getOnclick() + "' ");
        if (StringUtils.isNotBlank(property.getOnchange()))
            selectHtml.append("onchange='" + property.getOnchange() + "' ");
        if (property.isMultipleSelect()) selectHtml.append("multiple='multiple' ");
        selectHtml.append("> \n");

        if (options != null) {

            for (Option option : options) {
                if (option.isSelected()) {
                    selectHtml.append("<option value='" + option.getValue() + "' selected>" + option.getName() + "</option>\n");
                } else {
                    selectHtml.append("<option value='" + option.getValue() + "'>" + option.getName() + "</option>\n");
                }
            }
        }
        selectHtml.append("</select>");

        return selectHtml.toString();
    }

}
