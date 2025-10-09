@ui
Feature: Logout functionality

  Background:
    Given user is already on the "https://thinking-tester-contact-list.herokuapp.com/contactList" page
    And get user's auth token
    Given add user's cookies
    When user verifies home page's ui elements


  Scenario: user can logout
    When user clicks on the logout button
    Then user is on the "https://thinking-tester-contact-list.herokuapp.com/" page