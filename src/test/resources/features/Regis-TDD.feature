Feature: Register with TDD

  @TDDRegister
  Scenario Outline: Register with TDD
    Given User already in register page
    When User fill <firstname>, <lastname>, <email>, <telephone>, <password>, <confirmPass> check <radio>, <checkbox>
    And User click on the sign up button
    Then User verify registration <result>

    Examples:
      | firstname  | lastname        | email             | telephone | password    | confirmPass| radio | checkbox| result |
      | aldans     | dore            | biinocudvsd@gg.co | 628989898 |    binaan21 | binaan21   | yes   | yes     | Passed |
      | aldans     | dore            | biinodulvsd@gg.co | 628989898 |    binaan21 | binaan12   | yes   | yes     | Failed |
      | aldans     | dore            | biinodslvsd@sdsds | 628989898 |    binaan21 | binaan21   | yes   | yes     | Failed |