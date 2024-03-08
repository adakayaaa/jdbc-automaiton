@regression  @db @paymentService
Feature: Payment Management Service

  @smoke

  Scenario: Get a list of all payments
    Given the payment service is up and running
    When I request a list of all payments
    Then I should receive a list containing all payments in the database

  Scenario: Get a payment by its ID
    Given the payment service is up and running
    When I request the payment with ID 17536
    Then I should receive the details of the payment with ID 17536

  Scenario Outline: Validate payment record by ID
    Given the payment service is up and running
    When I request the payment with ID <payment_id>
    Then I should receive the film with rental id <rental_id> and customer id <customer_id>

    Examples:
      | payment_id | rental_id | customer_id |
      | 17527      | 3372      | 346         |
      | 17533      | 3326      | 347         |
      | 17539      | 2987      | 349         |