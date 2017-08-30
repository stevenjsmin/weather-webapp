<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="/resources/css/jquery-ui.css" rel="stylesheet">
<link href="/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/resources/css/bootstrap-dialog.min.css" rel="stylesheet" media="screen">
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/steven_core.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        search();
    });
</script>

<script type="text/javascript">
    function search() {
        var cityName = $('#cityName').val();
        $("#contentsTbl").hide();
        $("#messageTbl").show();
        $.ajax({
            url: "/weather/currentWeather.steven",
            data: "cityName=" + cityName,
            success: callbackCityName
        });
    }

    function callbackCityName(data) {
        var weather = data.weather;
        var weatherDetail = data.weatherDetail;

        var city = weather.name;
        var updatedtime = weather.dt;
        var temperature = weather.main.temp;
        var wind = weather.wind.speed;

        var message = weather.message;

        $("#contentsTbl").show();
        $("#messageTbl").hide();

        $('#city').html(city);
        $('#updatedtime').html(updatedtime);
        $('#weatherDetail').html(weatherDetail);
        $('#temperature').html(temperature + " °C");
        $('#wind').html(wind + " km/h");
    }
</script>

<html>
<head>
    <title>Pactera-Code test</title>
</head>
<body>
<div class="well well-lg">
    <div class="jumbotron">
        <h3>Code Test - Get Current Weather</h3>
        <div class="row">
            <div class="col-sm-2"><c:out value="${cbxCityName}" escapeXml="false"/></div>
            <div class="col-sm-4">
                <button type="button" class="btn btn-warning" onclick="search();">Check</button>
            </div>
        </div>

        <br/>
        <div class="row" id="contentsTbl">
            <div class="col-sm-4">
                <table class="table table-striped">
                    <tbody>
                    <tr>
                        <td style="color: #738182;">City</td>
                        <td><span id="city">-</span></td>
                    </tr>
                    <tr>
                        <td style="color: #738182;">Updated time</td>
                        <td><span id="updatedtime">-</span></td>
                    </tr>
                    <tr>
                        <td style="color: #738182;">Weather</td>
                        <td><span id="weatherDetail">-</span></td>
                    </tr>
                    <tr>
                        <td style="color: #738182;">Temperature</td>
                        <td><span id="temperature">-</span></td>
                    </tr>
                    <tr>
                        <td style="color: #738182;">Wind</td>
                        <td><span id="wind">-</span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row" id="messageTbl">
            <div class="col-sm-4">
                Loading.....
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <span style="font-size: 12px;color: grey;font-weight: bold;margin-left: 10px;">Steven Min</span>
        <span style="font-size: 12px;color: grey;">
        | 0422 632 338 |
            <a href="https://www.linkedin.com/in/stevenmin/" style="color: grey;">https://www.linkedin.com/in/stevenmin/</a>
        </span>
    </div>
</div>

</body>
</html>
