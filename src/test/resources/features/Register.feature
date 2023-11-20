@All

  Feature: Register With BDD

    @BDDRegister1 @Positive
    Scenario: Register with valid input
      Given User is on registration page
      Then User fill registration form
      And User click sign up button
      Then User succes register as expected

    @BDDRegister2 @Negative
    Scenario: Register with invalid confirm password
      Given User is on registration page
      Then User fill invalid registration form
      And User click sign up button
      Then User get error register message