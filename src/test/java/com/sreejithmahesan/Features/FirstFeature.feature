Feature: Sample Feature for demo purpose of the framework

  @Smoke
  Scenario Outline: Login Test Facebook Homepage

    Give I have launched the Facebook homepage
    And I have entered "<UserName>"
    And I have entered the "<Password>"
    When I click on the login button
    Then the user should be logged  in after authentication with "<Status>"

    @Smoke1
    Examples:
    |UserName|Password|Status|
    |User1   |Pass1   |Fail  |
    |User2   |Pass2   |Fail  |

    @Smoke2
    Examples:
      |UserName|Password|Status|
      |User1   |Pass1   |Fail  |
      |User2   |Pass2   |Fail  |

    @Smoke3
    Examples:
      |UserName|Password|Status|
      |User1   |Pass1   |Fail  |
      |User2   |Pass2   |Fail  |