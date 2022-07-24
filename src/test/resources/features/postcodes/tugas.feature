Feature: Alterra Test API using web Reqres.io task
  Scenario Outline: Get list source with parameter
    Given Get list source with parameter page "<page>"
    When Send request get list user
    Then Should return status code 200 and Success get list user with page <page>
    Examples:
      |page|
      |1   |
      |2   |
  Scenario Outline: Get list source with exceeds total pages
    Given Get list source with parameter page "<page>"
    When Send request get list user
    Then Should return status code 200 not found and Failed get data
    Examples:
      |page|
      |1000 |
      |2000 |
  Scenario Outline: Get single source with id
    Given Get single source with id "<id>"
    When Send request get single source
    Then Should return status code 404 not found and Failed get source data
    Examples:
      |id|
      |1 |
      |2 |
      |3 |
  Scenario: Post in register with json
    Given Post Create new user in register with valid json schema
    When Send request create new user in register
    Then Should return status code 200 created
  Scenario Outline: Get list register with exceeds total pages
    Given Get list register with parameter page "<page>"
    When Send request get list register
    Then Should return status code 200 not found and Failed get data
    Examples:
      |page|
      |1000 |
      |2000 |
  Scenario Outline: Get single register with id
    Given Get single register with id "<id>"
    When Send request get single register
    Then Should return status code 404 not found and Failed get source data
    Examples:
      |id|
      |1 |
      |2 |
      |3 |
  Scenario: Post in login with json
    Given Post Create new user in register with valid json schema
    When Send request login
    Then Should return status code 200 created

