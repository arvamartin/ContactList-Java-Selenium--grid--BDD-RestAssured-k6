@ui
Feature: Adding new contact functionality

  Background:
    Given user is already on the "https://thinking-tester-contact-list.herokuapp.com/contactList" page
    Given get user's auth token
    Given add user's cookies


  Scenario: user can add new contact to table
    When user verifies home page's ui elements
    When user clicks on add new contact button
    And user enters firstname
    And user enters lastname
    And user enters acceptable email
    And user enters acceptable phone number
    And user clicks on the submit button
    Then user is on the "https://thinking-tester-contact-list.herokuapp.com/contactList" page
    And new contact is in the contact table

