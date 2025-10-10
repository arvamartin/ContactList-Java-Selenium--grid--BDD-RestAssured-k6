Feature: Delete contact

  Scenario Outline: verify the delete api for the contacts
    Given get user's auth token
    And send DELETE request to "/contacts/<contactID>"
    Then receive the 200 response code
    Examples:
      | contactID                |
      | 68776deb07f0be001530cfcb |