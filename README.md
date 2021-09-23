# Pruebas automatizadas en el sitio de Fitbank

## Flujo de préstamos

## Tecnologías:
* Java 8 con Maven.
* [Selenium](https://www.selenium.dev/es/documentation/).
* [Cucumber](https://cucumber.io/docs/cucumber/).

## Documentación:
* [Reportes automáticos](https://www.npmjs.com/package/multiple-cucumber-html-reporter) con la guía del canal [QA Automation](https://youtu.be/y5EUIJOFhXk).
* Validadores [Assert](https://junit.org/junit4/javadoc/4.13/org/junit/Assert.html) de Junit.
* [Condicionales](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html) para controlar elementos del DOM.
* Descargar documentos pdf usando [Class Robot](https://docs.oracle.com/javase/10/docs/api/java/awt/Robot.html).

## Ejecución:
* Clonar el repositorio.
* Ejecutar `npm install` para descargar las dependecias del reporte.
* El archivo de Excel debe agregar su ip, usuario y clave.
* Tener en cuenta que en el archivo `loanflow.feature` contiene el número de repeticiones que hará de acuerdo a las filas del documento de Excel que contiene la clase `Utilities`, en el método `readExcel`.

Ejemplo:

`File file = new File("./src/test/assets/exceldocuments/testRead02.xlsx")` tiene una fila de datos en el Excel, por lo que en el archivo `loanflow.feature`debe tener un caso.

    Examples:
      | caso |
      | 1    |
