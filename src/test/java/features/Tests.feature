Feature: Verify different get operation using RestAssured without BDD

  Scenario: Verify the author of the post
    Given i perform the GET operation of the "/posts"
    Then I should see the author name as "typicode"

  Scenario: Verify the post operation
    Given i perform the post operation of the "/posts"

  Scenario: Verify the post operation for profile with body and path parameter
    Given i perform the post operation of the "/posts/{profile}/profile" with body
       | name |   profile |
       | sams | 2         |
    Then I should see the body has name as "sams"