Feature: Verify different Delete operation using RestAssured

  Scenario: Verify DELETE operation after POST

    Given I ensure to Perform POST operation for "/posts" with body as
      | id | title   | author       |
      | 7  | Name    | Ratna kumar  |
    And  I Perform DELETE operation for "/posts/{postid}/"
      | postid |
      | 7      |
    And I perform GET operation with path parameter for "/posts/{postid}"
      | postid |
      | 6      |
    Then I "should not" see the body with title as "Ratna kumar"
