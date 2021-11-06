Feature:

  Scenario: Get all users
    When all users are requested
    Then a status code is returned
    And 20 users  are returned