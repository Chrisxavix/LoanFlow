@Action
Feature: Inversiones

  Scenario Outline: Creación de una solicitud de inversiones
    Given Abre el web browser Chrome y direcciona a la aplicación
    When Cierro sesiones activas, ingreso el usuario y contraseña
    Then Ingreso la transaccion


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
