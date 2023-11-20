Feature: Register with TDD

  @TDDRegister
  Scenario Outline: Register with TDD
    Given User already in register page
    When User fill <firstname>, <lastname>,  <email>,  <password>, check <checkbox>
    And User click on the sign up button
    Then User verify registration <result>

    Examples:
      | firstname  | lastname        | email            | password | checkbox    | result|
      | bokssasd   | wwwwwwwwwwww    | boksadww@gmm.co  | 123boxxx |    yes      | Passed|
      | bokssasd   | dddddddddddd    | bokweeww@gmm.co  | 123boxxx |     no      | Failed|
      | ddddaaaa   | wwwwwwwwwwww    | boksadwwsgmm.co  | 123boxxx |     yes     | Failed|