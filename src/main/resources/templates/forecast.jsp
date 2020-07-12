<html>
<head>
    <meta charset="UTF-8"/>
    <title>Weather forecast</title>
    <link th:rel="stylesheet" th:href="@{webjars/bootstrap/4.0.0-2/css/bootstrap.min.css} "/>
    <link th:href="@{/css/forecast.css}" rel="stylesheet" />

</head>
<body>
        <div class="span6" style="float: none; margin: 0 auto;">
            <div id="forecastCarousel" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                 <li data-target="#forecastCarousel" th:each="locForecast : ${forecastList}" class="${locForecastStat.index == 0} ? active : ''" ></li>
              </ol>
              <div class="carousel-inner">
                <div class="carousel-item text-center" th:classappend="${locForecastStat.index == 0} ? active : ''"  th:each="locForecast : ${forecastList}">
                <p />
                  <img class="d-block   img-fluid loc-img" th:src="@{${'/img/' + locForecast.code + '.jpg'}}" alt="@{${locForecast.location}}"></img>
                  <div class="carousel-caption d-none d-md-block">
                      <h3 th:text="${locForecast.location}"></h3>
                      <p><h5 th:text="${locForecast.summary}"></h5></p>
                      <p th:text="|SUNRISE : ${locForecast.sunriseTime}AM   SUNSET : ${locForecast.sunriseTime}PM   TEMPERATURE[H] : ${locForecast.temperatureHigh}   TEMPERATURE[M] : ${locForecast.temperatureLow}|"></p>
                      <button class="btn btn-primary" onClick="window.location.reload();">Refresh Data</button>
                  </div>
                  <p/>
                </div>
              </div>
              <a class="carousel-control-prev" href="#forecastCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#forecastCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
 </div>

<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>

</body>
</html>