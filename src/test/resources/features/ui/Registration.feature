@ui
Feature: Registration functionality


  Background:
    Given user is already on the "https://thinking-tester-contact-list.herokuapp.com/addUser" page


  Scenario: user can register with acceptable credentials
    When user enters firstname
    And user enters lastname
    And user enters acceptable email
    And user enters acceptable password
    And user clicks on the submit button
    Then user is on the "https://thinking-tester-contact-list.herokuapp.com/contactList" page


  Scenario: user cannot register with unacceptable credentials
    When user enters firstname
    And user enters lastname
    And user enters unacceptable email
    And user enters unacceptable password
    And user clicks on the submit button
    Then error message is displayed


  Scenario: user interrupts registration process
    When user enters firstname
    And user enters lastname
    And user enters acceptable email
    And user enters acceptable password
    And user clicks on the cancel button
    Then user is on the "https://thinking-tester-contact-list.herokuapp.com/login" page
