Feature: Registration

  Scenario Outline: Successful registration
    Given I am using browser "chrome"
    Given I have entered date of birth "11/11/2000"
    And I have entered first name "Staffan"
    And I have entered last name "<last>"
    And I have entered email and confirmed email "staffan821447@mail.com"
    And I have entered password and confirmed password
    And I have <status> terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registrered and verifies <text>

    Examples:
      | last        | status      | text                 |
      | Åberg       | checked     | registrated          |
      |             | checked     | missing last name    |
      | Svensson    | checked     | wrong password       |
      | Abrahamsson | not checked | terms and conditions |


