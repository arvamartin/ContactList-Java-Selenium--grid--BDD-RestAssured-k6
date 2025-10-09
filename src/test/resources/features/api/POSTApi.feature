Feature: Post a contact

  Scenario: verify the post api for the contacts
    Given get user's auth token
    And send new contact from "PostBody.json" in "/contacts" post request
    Then receive the 201 response code



