Feature: Login with TDD

  @TDD
  Scenario Outline: Login with TDD
    Given User already in login page
    When User input <username> and <password>
    And User click the login button
    Then User get verify login <result>

    Examples:
    | username        | password        | result |
    | standard_user   | secret_sauce    | Passed |
    | standard_user   | invalidPassword | Failed |
    | invalidUsername | secret_sauce    | Failed |