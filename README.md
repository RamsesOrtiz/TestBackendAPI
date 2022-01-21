# TestBackendAPI
 Automation Test from backend - Java 11 + Gradle

#Requirements
Gradle

#Challenge
Test Backend:

- Realizar un único test donde se realicen los pasos abajo mencionados y se incluya en dicho test las aserciones
indicadas en el punto 4. Procurar no hardcodear IDs o nombres de las cervecerías dentro de los métodos.

Pasos:

1- Obtener una lista de cervecerías que contengan el texto "lagunitas" en su nombre.

Para ello, se debe ejecutar el siguiente servicio, indicando el texto a buscar en el queryParam "query".

GET - https://api.openbrewerydb.org/breweries/autocomplete

2- De la lista de resultados del punto 1, tomar aquellos que contengan en la key "name", el valor "Lagunitas Brewing Co".

3- Por cada elemento de la lista anterior, a través del siguiente servicio, pedir el detalle y tomar solo aquel que contenga
"state" = "California".

GET - https://api.openbrewerydb.org/breweries/{id}

Assert:

4-Sobre la cervecería resultante, assertar lo siguiente:"name" = "Lagunitas Brewing Co"
"street" = "1280 N McDowell Blvd"
"phone" = "7077694495"
