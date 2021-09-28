@Action
Feature: Flujo de Préstamos

  Scenario Outline: Creación de una solicitud de préstamos
    Given Abre el web browser Chrome y direcciona a la aplicación
    When Cierro sesiones activas, ingreso el usuario y contraseña
    And Ingreso a la transacción 06-2100 e ingreso los datos del Deudor, Codeudor y Garantes
    And Ahora me dirijo a Datos Producto e ingreso los datos respectivos
    And Procedemos a ingresar los datos del prestamo
    And Guardamos el formulario para crear el número de solicitud
    And Ingreso la transacción 06-2000 e ingreso el número de solicitud
    And Ingreso los datos geográficos
    And Ingreso los datos del préstamo y comentarios
    And Genero el reporte
    And Guardo la transacción
    And Nos dirigimos a la pestaña de garantias 06-2008
    And Ingreso los datos de las garantias propuestas
    And Guardo la transacción
    And Nos dirigimos a la pestaña pestaña de impresión de documentos 06-2016
    And Guardo la transacción
    And Genero el reporte de checklist
    And Genero la orden de operación
    And Valido que la orden de operación se haya generado
    And Consultar la operación 00-0267
    And Ahora nos dirigimos a la transaccion 06-3071 e ingresamos el número de solicitud generado anteriormente
    And Marco los checklist habilitados y guardamos la verificacion
    And Ingresamos al formulario 06-3040
    And Ingresamos el numero de solicitud de análisis de crédito
    And Agregamos un comentario
    And Guardo la transacción
    And Nos dirigimos a la pestaña de analisis de credito 06-3078, en riesgos ingresamos el valor de cero
    And Ahora nos dirigimos a la pestaña de activos y pasivos e ingresamos la informacion correspondiente
    Then Guardo la transacción
    When Selecciono la pestaña de cumplimiento de políticas 06-3080
    Then Completo las casillas de Politícas del Sujeto de Crédito y agrego un comentario
    And Completo las políticas adicionales
    And Guardo la transacción
    And Abrimos el navegador en modo incógnito
    And Cierro sesiones activas, ingreso el usuario y contraseña en modo incógnito
    And Ingresamos al buzón de autorizaciones 00-2008 y seleccionamos la trasacción correspondiente
    And Luego nos dirigimos a la autorizacion de transaccion 00-2009, ingresamos observaciones y aprobamos
    And Ingresamos a la aprobación de análisis de riesgos para aprobar el número de solicitud 06-3033
    And Iniciamos la aprobación de solicitud del préstamo 06-2001
    And Ingresamos los datos para generar el número de crédito
    And Guardo la transacción
    And Abrimos el navegador en modo incógnito para aprobar el número de crédito
    And Cierro sesiones activas, ingreso el usuario aprobador y contraseña en modo incógnito
    And Ingresamos al buzón de autorizaciones 00-2008 y seleccionamos la trasacción correspondiente en incógnito
    And Ingresamos los datos para generar el número de crédito en incógnito
    And Guardo la transacción en incógnito
    And Capturar el número de crédito

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
