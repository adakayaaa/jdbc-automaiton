@regression  @db @filmService
Feature: Film Management Service

  @smoke

Scenario: Get a list of all films
Given the film service is up and running
When I request a list of all films
Then I should receive a list containing all films in the database

Scenario: Get a film by its ID
Given the film service is up and running
When I request the film with ID 1
Then I should receive the details of the film with ID 1

Scenario Outline: Validate film record by ID
Given the film service is up and running
When I request the film with ID <film_id>
Then I should receive the film with title "<title>" and rental_duration <rental_duration>

Examples:
  | film_id | title            | rental_duration |
  | 1       | Academy Dinosaur | 6               |
  | 2       | Ace Goldfinger   | 3               |
  | 9       | Alabama Devil    | 3               |