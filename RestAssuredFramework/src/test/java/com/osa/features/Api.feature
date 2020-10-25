Feature: RestApi Automation

  Scenario: Adding a new User
    Given I want to create a new user with the following information
    Then I want the  new user to be created  through "Post" HTTP Method using the endpoint "/api/users"
      | first name | Justin              |
      | last name  | gathje              |
      | email      | Justin355@gmail.com |
    And Later I validate the HTTP Status code
    Then I verify first name
     |VAL | $.email      | Justin355@gmail.com | 
     |VAL | $.first_name | Justin              |
     |VAL | $.last_name  | gathje              |
     |HEA | target  | QA              |
    Then it should create a new user
