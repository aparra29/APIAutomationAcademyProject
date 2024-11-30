@active
Feature: Client testing CRUD

  @test1
  Scenario: Change the phone number of the first client named Laura
    Given there are at least 10 registered clients in the system
    When I find the first client named Laura
    And I save her current phone number
    And I send a PUT request to update her phone number
    Then I validate her phone number is different
    And the response should have a status code of 200

  @test3
  Scenario: Update and delete a new client
    When I create a new client
    And I find the newly created client
    And I send a PUT request to update the client
    """
    {
      "name": "Maria",
      "lastName": "Gomez",
      "country": "Spain",
      "city": "Barcelona",
      "email": "ernesto@gmail.com",
      "phone": "0922849013"
    }
    """
    And I send a DELETE request to delete the client
    Then the response should have a status code of 200

Feature: Resource testing CRUD


