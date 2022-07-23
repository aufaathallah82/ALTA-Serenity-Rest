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
    When Send request get single user
    Then Should return status code 404 not found and Failed get source data
    Examples:
      |id|
      |1 |
      |2 |
      |3 |