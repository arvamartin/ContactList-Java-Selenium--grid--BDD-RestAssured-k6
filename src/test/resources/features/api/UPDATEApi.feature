Feature: Patch & Put - update

  @PATCH
  Scenario Outline: verify the patch api for the contacts
    Given get user's auth token
    And update contact from "PatchBody.json" in "/contacts/<contactID>" "patch" request
    Then receive the 200 response code
    And hit the url with auth token
    And pass the "/contacts" url in the request
    And verify new contact from "PatchBody.json" appeared in GET response
    Examples:
      | contactID                |
      | 692c8ea4e972c80015ce6ef9 |

  @PUT
  Scenario Outline: verify the put api for the contacts
    Given get user's auth token
    And update contact from "PutBody.json" in "/contacts/<contactID>" "put" request
    Then receive the 200 response code
    And hit the url with auth token
    And pass the "/contacts" url in the request
    And verify new contact from "PutBody.json" appeared in GET response
    Examples:
      | contactID                |
      | 692c8d04301b4a0015a02450 |

