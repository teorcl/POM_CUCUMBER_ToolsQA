Feature: Registro con campos obligatorios en toolsqa
  Como empleado administrativo quiero ingresar al sistema los estudiantes
  para cumplir las politicas administrativas de la universidad.

  Scenario: Registro de un estudiante con los campos obligatorios
    Given que el empleado admin se encuentra en el sitio web de los registros de los estudiantes
    When el empleado admin ingresa los datos en los campos obligatorios y confirma la accion
    Then el sistema deberia mostrar por pantalla el registro del estudiante ingresado