Feature: Test API using web Reqres.io
  Scenario Outline: Get list user with parameter
    Given Get list user with parameter page "<page>"
    When Send request get list user
    Then Should return status code 200 and Success get list user with page <page>
    Examples:
      |page|
      |1   |
      |2   |
  Scenario Outline: Get list user with exceeds total pages
    Given Get list user with parameter page "<page>"
    When Send request get list user
    Then Should return status code 200 not found and Failed get data
    Examples:
     |page|
     |1000 |
     |2000 |
  Scenario Outline: Get single user with id
    Given Get single user with id <id>
    When Send request get single user
    Then Should return status code 200 and Success get single user with id <id>
    Examples:
      |id|
      |1 |
      |2 |
      |3 |
  Scenario: POST create new user with valid json
    Given Post Create new user with valid json schema
    When Send request create new user
    Then Should return status code 201 created
    And Response body should contain name "aufa" and job "QA ID"
  Scenario Outline: Put update user
    Given Put edit user id <id> with valid json schema
    When Send request put update user
    Then Should return status code 200 OK
    And Response body should contain name "aufa" and job "QA ID"
    Examples:
      |id|
      |2 |

  Scenario Outline: Delete user
    Given Delete user id <id>
    When Send request delete user
    Then Should return status code 204 no content
    Examples:
      |id|
      |2 |
  Scenario Outline: Get list user
    Given Get list user with parameter "<parameter>"
    When Send request get list user
    Then Should return status code 200 OK
    And Response body should contain first name "<firstName>" and last name "<lastName>"
    Examples:
      |parameter|firstName|lastName|
      |1        |George  |Bluth    |
      |2        |Michael |Lawson   |
  @regression
  Scenario: Post create user with json
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "aufa" and job "QA ID"
  Scenario Outline: Put update user with json
    Given Put update user with id <id> and with valid json file
    When Send request put update user
    Then Status code should be 200 OK
    And Response body should contain name "aufa" and job "QA ID"
    Examples:
      |id|
      |1 |
      |2 |

