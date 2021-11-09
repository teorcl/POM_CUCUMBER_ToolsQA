Feature: Registro con todos los campos en toolsqa
  Como empleado administrativo quiero ingresar al sistema los estudiantes
  para cumplir las politicas administrativas de la universidad.

  Scenario: Registro de un estudiante con todos los campos
    Given que el empleado admin se encuentra en el sitio web donde se hace el registro de los estudiantes
    When el empleado admin ingresa todos los datos del formulario y confirma la accion
    Then el sistema deberia mostrar por pantalla el registro del estudiante ingresado con todos los campos