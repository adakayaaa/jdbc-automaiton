@regression  @db @filmDetailsService
Feature: Film Details Management Service

  @smoke
  Scenario: Get a list of all film details
    Given the film detail service is up and running
    When I request a list of all film details
    Then I should receive a list containing all film details in the database

  Scenario: Get a film detail by its ID
    Given the film detail service is up and running
    When I request the film detail with title "Academy Dinosaur"
    Then I should receive the details of the film detail with title "Academy Dinosaur"

  Scenario Outline: Validate film detail record by  title
    Given the film detail service is up and running
    When I request the film detail with title "<title>"
    Then I should receive the film detail with release year <release_year> and category "<category>"

    Examples:
      | title            | release_year | category    |
      | Academy Dinosaur | 2006         | Documentary |
      | Ace Goldfinger   | 2006         | Horror      |
      | Adaptation Holes | 2006         | Documentary |

