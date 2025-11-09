@OrangeHRM
Feature: Actualizacion de usuario en OrangeHRM

  Scenario: Editar el username de Jasmine.Morgan
  Dado que Maria navega por la página de OrangeHRM
  Cuando ella accede con sus credenciales "Admin" y "admin123"
  Entonces ella valida que esta en la seccion Admin/User Management
  Cuando ella busca al usuario "Jasmine.Morgan" y lo edita con "Jasmine.Morgan.Test"
  Entonces valida que el mensaje Success aparece