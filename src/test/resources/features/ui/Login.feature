@ui
Feature: Login functionality

  Background:
    Given user is already on the "https://thinking-tester-contact-list.herokuapp.com/login" page
    When user verifies login page's ui elements


  Scenario: user can login with already registered credentials
    And user enters "test@freemail.hu" email address
    And user enters "tesztelek" password
    And user clicks on the submit button
    Then user is on the "https://thinking-tester-contact-list.herokuapp.com/contactList" page


  Scenario: user cannot login with not registered credentials
    When user enters "not-registered@gmail.com" email address
    And user enters "notRegistered" password
    And user clicks on the submit button
    Then error message is displayed


  Scenario: user cannot login with empty credentials
    When user enters "" email address
    And user enters "" password
    And user clicks on the submit button
    Then error message is displayed
