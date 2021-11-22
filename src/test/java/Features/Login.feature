@LoginTest
Feature: Register Feature
  Scenario: Correct Register Test
    Given Kullanıcı Hepsiburada.com sitesini ziyaret eder
    When Kullanıcı giriş işlemi yapılır
    And Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
    And Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden ürün seçer
    And Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir
    Then Seçilen ürünlerin sepete eklendiği görülür.