package com.xp.rps;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@JdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Import(JdbcRepo.class) //Somehow @JdbcTest not able to load @Repository, Import to force it happen
@Transactional

public class RpsRepoImplTest {

    @Autowired
    RpsRepo rpsRepoImpl;
    //RpsRepoImpl rpsRepoImpl= new RpsRepoImpl();
    @Test
    public void testGame() {
        Game game = new Game("v1", "v2", 3, "buy");
        int id = rpsRepoImpl.createGame(game);
        game.setId(id);
        //assertEquals(game.getId(), id);

        Game game1 = rpsRepoImpl.getGame(id);
        assertEquals(game1, game);

        Round round1 = new Round(Throw.PAPER,Throw.ROCK,Result.P1_WINS);
        Round round2 = new Round(Throw.PAPER,Throw.ROCK,Result.P1_WINS);

        rpsRepoImpl.addRound(game1.getId(),round1);
        rpsRepoImpl.addRound(game1.getId(),round2);
        Game g = rpsRepoImpl.getGame(game.getId());
        assertEquals(2,g.getRoundList().size());
        assertEquals(Result.P1_WINS,g.getResult());
    }

}
