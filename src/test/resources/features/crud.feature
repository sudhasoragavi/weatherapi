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

