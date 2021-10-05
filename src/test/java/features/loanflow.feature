@Action
Feature: Flujo de Préstamos

  Scenario Outline: Creación de una solicitud de préstamos
    Given Abrimos el navegador Chrome con la web de Fitbank
    And Cerramos sesiones activas, ingresamos el usuario y contraseña
    When Ingresamos a la transacción 06-2100 e ingresamos los datos del deudor, codeudor y garantes, datos del producto y los datos del préstamo
    Then Guardo la transacción
    When Ingresamos a la transacción 06-2000 e ingreso los datos geográficos, datos del préstamo y comentarios
    And Genero el reporte
    Then Guardo la transacción
    When Nos dirigimos a la pestaña de garantias 06-2008, ingresamos los datos de las garantias propuestas
    Then Guardo la transacción
    When Nos dirigimos a la pestaña pestaña de impresión de documentos 06-2016
    Then Guardo la transacción
    And Genero el reporte de checklist y la orden de operación
    And Valido que la orden de operación se haya generado en la transacción 00-0267
    And Ingresamos a la transacción 06-3071, marcamos los checklist habilitados y guardamos la verificacion
    When Ingresamos al formulario 06-3040 y agregamos un comentario
    Then Guardo la transacción
    And Nos dirigimos a la pestaña de análisis de crédito 06-3078, ingresamos valores en riesgos y en activos y pasivos
    Then Guardo la transacción
    And Nos dirigimos a la pestaña de cumplimiento de políticas 06-3080, completo las casillas de políticas del sujeto de crédito, agrego un comentario y completo las políticas adicionales
    Then Guardo la transacción
    Given Abrimos el navegador en modo incógnito
    And Cierro sesiones activas, ingreso el usuario y contraseña en modo incógnito
    When Ingresamos al buzón de autorizaciones 00-2008 y aprobamos la solicitud 00-2009
    And Aprobamos el número de solicitud en aprobación de análisis 06-3033
    And En el navegador normal ingresamos a aprobar la solicitud del préstamo 06-2001 e ingresamos los datos para generar el usuario a aprobar el número de solicitud
    Then Guardo la transacción
    Given Abrimos el navegador en modo incógnito para aprobar el número de crédito
    And Cierro sesiones activas, ingreso el usuario aprobador y contraseña en modo incógnito
    When Ingresamos al buzón de autorizaciones 00-2008, seleccionamos la trasacción correspondiente e ingresamos los datos para generar el número de crédito
    Then Guardo la transacción en modo incógnito y capturo el número de crédito generado
    When Ingresamos a la transacción 06-3002 e ingresamos el número de préstamos y la cuenta a debitar
    And Guardo la transacción
    And Luego ingresamos a la transacción 06-2006 e ingresamos el número de préstamos y las garantías existentes
    And Guardo la transacción
    And Ingresamos a la transacción 06-3005 y llenamos la información del préstamo
    And Guardo la transacción
    And Ahora imprimimos los reportes de los documentos habilitantes
    And Nos dirigimos a la transacción 06-3018 que es ka validación de documentos habilitantes e ingresamos el préstamo
    And Guardo la transacción
    And Por ultimo ingresamos a la transacción 06-6010 forma de desembolso del préstamo
    And Guardo la transacción
    Then Se muestra la transacción 06-4020 y nos da la consulta de datos generales del préstamo
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
