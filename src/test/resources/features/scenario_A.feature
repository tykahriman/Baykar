Feature: Users should be able to click on all navbar elements on the Baykartech site and the page should open without any problems.
  Background:
    Given Access to baykartech Home Page

  @test
  Scenario: Click on all navbar elements on the Baykartech site and the page should open without any problems
    Then Click on all navbar elements and verify the pages open without any problems
    And  Close the page
