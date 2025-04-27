Feature: The Internet


  Scenario: I am able to visit The Internet Site
    When I visit the Internet Site url
    Then I should be able to see the Internet Site


  @NOW
  Scenario: I am able to open sections
    Given I visit the Internet Site url
    When I click on link A/B Testing
    Then I should see A/B Testing Page

  @NOW
  Scenario: I am able to open Status Codes
    Given I visit the Internet Site url
    When I click on link Status Codes
    Then I should see Status Codes Page