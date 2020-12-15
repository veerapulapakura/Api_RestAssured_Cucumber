Feature:  Verify the post operation for profile with body and path parameter


  Scenario: Verify the post operation for profile with body and path parameter
    Given i perform the post operation of the "/posts/{profileNo}/profile" with body
      | name |   profile |
      | sams |     3     |
    Then I should see the body has name as "sams"