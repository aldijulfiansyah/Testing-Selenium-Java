@All

Feature: Register With POM BDD

  @POMRegister1 @Positive
  Scenario: Register with valid input
    Given User is on register page
    Then User fill register data
    And User click signup button
    Then User done register

  @POMRegister2 @Negative
  Scenario: Register with invalid confirm password
    Given User is on register page
    Then User fill invalid register data
    And User click signup button
    Then User failed to register