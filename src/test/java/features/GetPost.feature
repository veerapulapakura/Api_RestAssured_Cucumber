Feature: Verify different get operation using RestAssured

  Scenario: Verify the author of the post
    Given i perform the GET operation of the "/post"
    And I perform GET for the post number "1"
    Then I should see the author name as "typicode"

  Scenario: Verify contents of all collection
    Given i perform the GET operation of the "/post"
    Then I should see the author names

  Scenario: Verify contents of all collection with path parameter
    Given i perform the GET operation of the "/post"
    Then I should see the correct GET value


  Scenario: Verify contents of all collection with query parameter
    Given i perform the GET operation of the "/post"
    Then I should see the correct GET value of that query parameter