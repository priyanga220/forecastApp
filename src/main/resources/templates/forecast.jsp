<html>
<head>
    <meta charset="UTF-8"/>
    <title>Weather forecast</title>

    <link th:rel="stylesheet" th:href="@{assets/select2-develop/dist/css/select2.css}"/>
    <link th:rel="stylesheet" th:href="@{assets/select2-bootstrap4-theme-master/dist/select2-bootstrap4.css}"/>
    <link th:rel="stylesheet" th:href="@{webjars/bootstrap/4.0.0-2/css/bootstrap.min.css} "/>

</head>
<body>
<div th:if="${not #lists.isEmpty(forecastList)}">
    <h2>Weather Forecast</h2>
    <hr>
    <table class="table table-striped">
        <tr>
            <th>Location</th>
            <th>Forecast</th>
        </tr>
        <tr th:each="locForecast : ${forecastList}">
            <td th:text="${locForecast.location}"></td>
            <td th:text="${locForecast.forecast}"></td>
        </tr>
    </table>
</div>

<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
</body>
</html>