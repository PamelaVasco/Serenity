@OrangeHRM
Feature: Actualizacion de usuario en OrangeHRM
  Scenario: Maria accede y edita el usuario Jasmine.Morgan
    Given que Maria navega por la pagina de login
    When accede con sus credenciales "Admin" y "admin123"
    And busca al usuario "Jasmine.Morgan"
    And edita el campo Username con "Jasmine.Morgan.Test"
    Then valida que se muestre el mensaje "Success"
