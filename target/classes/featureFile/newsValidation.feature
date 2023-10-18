@tag
Feature: News Validation

  Scenario: Validate The Guardian News
    Given I open The Guardian website
    When I retrieve the title of the first news article
    And I search for the title on Google
    Then I should see at least 2 search results

    
  Scenario: Validate if the searched result found on google is more than 2 and also does not guardain webbsite counted in it.
   Given I open The Guardian website
    When I retrieve the title of the first news article
    And I search for the title on Google
    Then I want to print the name of first two sites with available results