@Action
Feature: Inversiones

  Scenario Outline: Creación de una solicitud de inversiones
    Given Abre el web browser Chrome y direcciona a la aplicación
    When Cierro sesiones activas, ingreso el usuario y contraseña
    And Ingreso la transaccion
    And Ingreso la identificacion del deudor
    And Ingreso la identificacion del codeudor y la descripcion
    And Por ultimo ingreso la indentificacion del garante y su descripcion
    And Ahora me dirigo a Datos Producto e ingreso el grupo del producto
    And Luego ingreso el producto
    And Despues ingresamos el id del ejecutivo
    And Escojemos el origen
    And Elegimos el destino de fondos
    And Nos dirigimos a la actividad recepetora e ingresamos la actividad
    And Procedemos a ingresar el monto del credito
    And Ingresamos la frecuecnia del capital
    And Ahora el numero de cuotas
    And Por ultimo calculamos la tasa de interes
    And Guardamos el formulario para crear el numero de solicitud
    And Ingreso la transacción 06-2000
    And Ingreso el número de solicitud
    And Ingreso los datos geográficos
    And Ingreso los datos del préstamo y comentarios
    And Genero el reporte
    And Guardo la transacción
    And Luego de guardar el formulario, nos dirigimos a la pestana de garantias
#    And Ahora vamos a ingresar los datos de las garantias propuestas como la identificacion del garante

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
