Feature: Language Selection
  Background:
    Given Access to baykartech Home Page

  @test
  Scenario: Users switches between languages
    When User switches language to "tr"
    Then Page is displayed in Turkish
    When User switches language to "en"
    Then Page is displayed in English
    And  Close the page