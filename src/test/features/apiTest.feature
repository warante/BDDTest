Feature: Ricky and Morty, api tests

  @high @get
  Scenario Outline: Test correctly method get for episodes
    Given user set api URI "<uri>"
    When user set path "<path>" service and page "<page>"
    Then user expects response code "<code>"

    Examples:
      | uri                               | path      | page  | code  |
      | https://rickandmortyapi.com/api   | /episode  | 2     | 200   |
      | https://rickandmortyapi.com/ap    | /episode  | 1     | 404   |

  @low @get
  Scenario Outline: Test episode name
    Given user set api URI "<uri>"
    When user set path "<path>" episode number "<episode>"
    Then user expects response code "<code>"
    And episode name "<name>"
    And episode season "<season>"

    Examples:
      | uri                               | path      | episode | code  | name                    | season  |
      | https://rickandmortyapi.com/api   | /episode  | 17      | 200   | The Ricks Must Be Crazy | S02E06  |
      | https://rickandmortyapi.com/api   | /episode  | 23      | 200   | Rickmancing the Stone   | S03E02  |