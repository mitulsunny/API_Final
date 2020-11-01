Feature: RestApi Automation

  Scenario: Adding a new User
    Given I want to create a new user with the following information
    Then I want the  new user to be created  through "Post" HTTP Method using the endpoint "/api/users"
      | first_name | Justin              |
      | last_name  | gathje              |
      | email      | Justin355@gmail.com |
    Then it should create a new user
    And Later I validate the HTTP Status code
    Then I verify all the VAL
     |VAL | first_name | Justin | 
     |VAL | last_name | gathje  |
     |VAL | email  | Justin355@gmail.com |
     
   Then I want the  new user to be delted  through "delete" HTTP Method using the endpoint "api/users?id=2"
    
     
    
   
