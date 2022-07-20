Feature: Test API using web Reqres.io
  Scenario Outline: Get list user with parameter
    Given Get list user with parameter page <page>
    When Send request get list user
    Then Should return status code 200 and Success get list user with page <page>
    Examples:
      |page|
      |1   |
      |2   |
  Scenario Outline: Get list user with exceeds total pages
    Given Get list user with parameter page <page>
    When Send request get list user
    Then Should return status code 404 not found and Failed get list user with page <page>
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
    And Success create new user with valid json schema And Validation Json schema
  Scenario Outline: Put update user
    Given Put edit user id <id> with valid json schema
    When Send request put update user
    Then Should return status code 200
    And Success update user with valid json schema And Validation Json schema
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
