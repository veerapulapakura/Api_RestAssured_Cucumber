Feature: Verify different get operation using RestAssured without BDD

  Scenario: Verify the author of the post
    Given i perform the GET operation of the "/posts"
    Then I should see the author name as "typicode"