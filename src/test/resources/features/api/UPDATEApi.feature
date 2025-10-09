Feature: Patch & Put - update

  @PATCH
  Scenario Outline: verify the patch api for the contacts
    Given get user's auth token
    And update contact from "PatchBody.json" in "/contacts/<contactID>" "patch" request
    Then receive the 200 response code
    Examples:
      | contactID                |
      | 68776d81b879610015f9c761 |

  @PUT
  Scenario Outline: verify the put api for the contacts
    Given get user's auth token
    And update contact from "PutBody.json" in "/contacts/<contactID>" "put" request
    Then receive the 200 response code
    Examples:
      | contactID                |
      | 68776d81b879610015f9c761 |

