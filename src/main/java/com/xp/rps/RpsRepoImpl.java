package com.xp.rps;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

//@Repository
public class RpsRepoImpl implements RpsRepo{
    int gameId = 0;
    HashMap<Integer,Game> gameRecord= new HashMap<>();
    int roundId = 0;

    @Override
    public int createGame(Game game) {

        gameId++;
        game.setId(gameId);
        gameRecord.put(gameId,game);

        return gameId;
    }

    @Override
    public Game getGame(int gameId) {
        return gameRecord.get(gameId);
    }

    @Override
    public int addRound(int gameId, Round round) {
        Game game = gameRecord.get(gameId);
        roundId++;
        round.setId(roundId);
        game.getRoundList().add(round);
        return roundId;
    }
}
