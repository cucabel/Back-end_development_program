# Dice
* Spring Boot | Spring Data | JPA | REST API | Gradle

The game is played with two dice. If the result of the two dice is 7, the game is won, otherwise, is lost.

In order to play, the user has to register itself as a player with a no repeated name. If the user don't introduce any
name, it is automatically assigned the name "Anonymous". There can be more than one "Anonymous" player.
When the player is created, it is assigned a numeric id and the data of registration.

The player has to be able to see the list of all the games it has played, with the points of each dice, and if it
won or not the game. Furthermore, it is able to know the percent of exit of all the games it plays. 

It is not allowed to delete one game, but it is to delete the list of all the player's games.

It has to be possible to list all the players with its percent of exit.

Implement the next functionalities:
- POST: /players: create a player
- PUT /login: log a player
- POST /players/{id}/games/: a roll of dice
- DELETE /players/{id}: delete a player
- DELETE /players/{id}/games: delete the player's list of games
- GET /players/{id}/games: returns the player's list of games
- GET /players/ranking: returns the list of all the players with its percent of exit 
- GET /players/ranking/loser: returns the least successful player
- GET /players/ranking/winner: returns the most successful player
