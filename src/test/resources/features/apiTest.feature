Feature: API Testing with Cucumber

  Scenario: Get User Information
    Given I send a GET request to "https://jsonplaceholder.typicode.com/users/1"
    Then the response status code should be 200
    And the response should contain "Leanne Graham"

  Scenario: Create a new user
    Given I send a POST request to "https://jsonplaceholder.typicode.com/users" with body:
    """
    {
      "name": "John Doe",
      "email": "john@example.com"
    }
    """
    Then the response status code should be 201
    And the response should contain "John Doe"