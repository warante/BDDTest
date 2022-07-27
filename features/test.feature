Feature: Ranking test

  @ranking
  Scenario Outline: Test correctly position in top ranking
    Given user is in filmaffinity
    When user click on top button
    Then verify position "<posicion>", name "<nombre>", director "<director>", point "<nota>"

    Examples:
      | posicion	| nombre 				| director 				| nota	|
      | 1 		    | El padrino 			| Francis Ford Coppola	| 9.0 	|
      | 3           | El padrino. Parte II	| Francis Ford Coppola	| 8.9 	|
      | 5           | Breaking Bad 			| Vince Gilligan 		| 8.8 	|
      | 23          | Ser o no ser      	| Ernst Lubitsch		| 8.5	|

  @smokeTest
  Scenario: Top FilmAffinity web is displayed
    Given user is in filmaffinity
    When user click on top button
    Then verify header tittle

  @searchTest
  Scenario Outline: Search a film
    Given user is in filmaffinity
    When user type the film name "<name>"
    And click on first element
    Then verify title is "<title>"

    Examples:
    | name      | title     |
    | big fish  | Big Fish  |
    | memento   | Memento   |
