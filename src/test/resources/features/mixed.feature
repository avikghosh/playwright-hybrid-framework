Feature: The Internet

  Scenario: Hybrid UI and API Scenario
    When I visit the Internet Site url
    When I click on link A/B Testing
    Then I should see A/B Testing Page
    And I should be able to make api call