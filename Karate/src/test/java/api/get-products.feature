Feature: Validar producto estrella en la tienda

Scenario: Validar producto con rate 4.8
  Given url 'https://fakestoreapi.com/products'
  When method get
  Then status 200
  And match response contains { id: 10, rating: { rate: 4.8 }, category: 'electronics', title: 'Silicon Power 256GB SSD 3D NAND A55 SLC Cache performance Boost SATA III 2.5' }
