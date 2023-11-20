@All

  Feature: Register Ultimate QA

    @Register @Positive
    Scenario: Register with valid input
      Given User is on registration page
      Then User fill registration form
      And User click sign up button
      Then User verify registration result

    @Register2 @Negative
    Scenario: Register with invalid input
      Given User is on registration page
      Then User fill invalid registration form
      And User click sign up button
      Then User get error register message