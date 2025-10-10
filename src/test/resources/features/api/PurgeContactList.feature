Feature: Purge contacts

  @manualOnly
  Scenario: Purge entire contact list
    Given get user's auth token
    When get the ID of all the contacts
    And delete the whole contact list
    Then receive the 200 response code