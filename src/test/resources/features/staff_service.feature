@regression  @db @staffService
Feature: Staff Management Service

  @smoke

  Scenario: Get a list of all staffs
    Given the staff service is up and running
    When I request a list of all staffs
    Then I should receive a list containing all staffs in the database

  Scenario: Get a staff by its ID
    Given the staff service is up and running
    When I request the staff with ID 1
    Then I should receive the details of the staff with ID 1

  Scenario Outline: Validate staff record by ID
    Given the staff service is up and running
    When I request the staff with ID <staff_id>
    Then I should receive the staff with first name "<first_name>" and address id <address_id>
    Examples:
      | staff_id | first_name | address_id |
      | 1        | Mike       | 3          |
      | 2        | Jon        | 4          |

