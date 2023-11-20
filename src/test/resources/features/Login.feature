@All
  Feature: Login BDD

    @BDDLogin1 @Positive
    Scenario: Login with valid test data
      Given User is on login page
      When User fill username and password
      And User click login button
      Then User verify login result


    @BDDLogin2 @Negative
    Scenario: Login with invalid test data
      Given User is on login page
      When User fill invalid username and password
      And User click login button
      Then User get error login message