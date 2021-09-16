@Action
Feature: Inversiones

  Scenario Outline: Creación de una solicitud de inversiones
    Given Abre el web browser Chrome y direcciona a la aplicación
    When Cierro sesiones activas, ingreso el usuario y contraseña
    And Ingreso la transaccion
#    And Ingreso la identificacion del deudor
























    When Ingreso la transacción 06-2000
    Then Ingreso el número de solicitud
    And Ingreso los datos geográficos
    And Ingreso los datos del préstamo y comentarios
    And Genero el reporte
    Then Guardo la transacción
    Examples:
      | caso |
      | 1    |
#      | 2    |
#      | 3    |
#      | 4    |
#      | 5    |
#      | 6    |
#      | 7    |
#      | 8    |
