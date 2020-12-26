Feature: Verify different Put operation using RestAssured

  Scenario: Verify PUT operation after POST

    Given I ensure to Perform POST operation for "/posts" with body as
      | id | title   | author       |
      | 9  | Name    | Ratna kumar  |
    And  I Perform PUT operation for "/posts/{postid}/"
      | id | title   | author |
      | 9  | Name    | kumar  |
    And I perform GET operation with path parameter for "/posts/{postid}"
      | postid |
      | 9      |
    Then I "should not" see the body with title as "kumar"