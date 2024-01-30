Feature: validate CRUD functionality

  Background:
    Given load api key and base url

  Scenario Outline: Validate GET weather functionality

    When I want to get weather details for location <q>
    Then service should return response as <response_code>
    Then service should return "location.name" as <location_name>
    Then service should return "location.lon" as <lon>
    Then service should return "location.lat" as <lat>

    Examples:
    | q          | response_code  |   location_name     |     lon            |    lat         |
    |"SM1"       | 200            |     "Sutton"        |     "-0.19"        |    "51.37"     |

  Scenario Outline: Validate GET weather functionality by providing invalid data
    When I want to get weather details for location <q>
    Then service should return response as <response_code>
    Then service should return "error.code" as <error_code>
    Then service should return "error.message" as <error_message>

    Examples:
      | q            | response_code   | error_code    | error_message                |
      |"0"           | 400             | "1006"        | "No matching location found."|
      | ""           | 400             | "1003"        | "Parameter q is missing."    |

  Scenario Outline: schema Validation
    When I want to get weather details for location <q>
    Then the api response should match the weather response schema
    Examples:
      | q     |
      |"SM1"  |
