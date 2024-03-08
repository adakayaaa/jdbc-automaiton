@regression  @db @rentalService
Feature: Rental Management Service
  @smoke
  Scenario: Get a list of all rentals
    Given the rental service is up and running
    When I request a list of all rentals
    Then I should receive a list containing all rentals in the database

  Scenario: Get an rental by its ID
    Given the rental service is up and running
    When I request the rental with ID 3
    Then I should receive the details of the rental with ID 3

  Scenario: Get rentals by inventory id
    Given the rental service is up and running
    When I request rentals in the 1525 inventory id
    Then I should receive a list of rentals located in the 1525 inventory id

  Scenario Outline: Validate rental record by ID
    Given the rental service is up and running
    When I request the rental with ID <rental_id>
    Then I should receive the rental with customer id <customer_id>,staff id <staff_id>, inventory id <inventory_id>
    Examples:
      | rental_id | customer_id | staff_id | inventory_id |
      | 6         | 549         | 1        | 2792         |
      | 7         | 269         | 2        | 3995         |
      | 12        | 261         | 2        | 1584         |

  Scenario Outline: Get rental's staff id and inventory id by their ID
    Given the rental service is up and running
    When I request the staff id and inventory id of the actor with ID <rental_id>
    Then I should receive the staff id <staff_id> and inventory id <inventory_id> of the rental with ID
    Examples:
      | rental_id | staff_id | inventory_id |
      | 6         | 1        | 2792         |
      | 7         | 2        | 3995         |
      | 12        | 2        | 1584         |

