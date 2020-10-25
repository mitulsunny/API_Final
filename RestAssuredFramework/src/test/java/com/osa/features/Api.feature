Feature: RestApi Automation

  Scenario: Adding a new User
    Given I want to create a new user with the following information
      | first name | Justin              |
      | last name  | gathje              |
      | email      | Justin355@gmail.com |
    Then I want the  new user to be created  through "Post" HTTP Method using the endpoint "/api/users"
    And Later I validate the HTTP Status code
    Then it should create a new user
