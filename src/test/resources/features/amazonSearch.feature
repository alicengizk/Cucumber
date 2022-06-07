Feature: Amazon Search

  @parametre
  Scenario: TC01 kullanici amazona gider
    Given kullanici "amazonUrl" anasayfada
    Then kullanici "Java" icin arama  yapar
    And sonuclarin "Java" icerdigini test eder

