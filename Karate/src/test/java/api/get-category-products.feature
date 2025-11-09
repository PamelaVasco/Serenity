Feature: Validar productos por categoría

Scenario: Validar que hay 6 productos en electronics y que está el id 10
  Given url 'https://fakestoreapi.com/products/category/electronics'
  When method get
  Then status 200
  And match response.length == 6
  And match response[*].id contains 10

Scenario: Ver solo 3 productos como límite
  Given url 'https://fakestoreapi.com/products/category/electronics'
  When method get
  Then status 200
  And def limited = response.slice(0, 3)
  And match limited.length == 3
