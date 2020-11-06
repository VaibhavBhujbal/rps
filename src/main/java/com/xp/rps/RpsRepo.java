package com.xp.rps;

public interface RpsRepo {
    int createGame(Game game);
    Game getGame(int gameId);
    int addRound(int gameId,Round round); //return roundId
}
//Create a Inmemory Implements RpsRepo
