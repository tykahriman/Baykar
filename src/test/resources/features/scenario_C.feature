Feature: Unit filtering and position search
  Background:
    Given Access to baykartech Home Page

  @test
  Scenario: Unit filtering and position search should be possible in open positions on kariyer.baykartech website
    Given User clicks on Baykar Career All Open Positions button
    When User searches for a position with keyword "Web Software Projects Testing"
    Then Verify that the searched position is displayed
    When User searchs for a position with unit
    Then Verify that the searched position's title contains the keyword
    And  Close the page