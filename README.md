# forecastApp
Weather Forecast Application [Thymeleaf+Bootstrap+SpringBoot+MongoDB+DarkskyAPI]

Displays the Weather Forecast Information for below locations;

- Campbell, CA, 
- Omaha, NE, 
- Austin, TX,
- Niseko, Japan,
- Nara, Japan and
- Jakarta, Indonesia 

Forecast data is fetched from Darksky API [https://darksky.net/dev].
Caches the Forecast Data into a MongoDB database in mongoLab[https://mlab.com/].
Housekeeping is implmented to remove cached forecast records that already 3 days old. 

