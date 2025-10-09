Feature:  Get all contacts and user profile from GET api

@test
  Scenario: verify the get api for the contacts
    Given get user's auth token
    When hit the url with auth token
    When pass the "/contacts" url in the request
    Then receive the 200 response code


  Scenario: verify the get api for the user
    Given get user's auth token
    When hit the url with auth token
    When pass the "users/me" url in the request
    Then receive the 200 response code