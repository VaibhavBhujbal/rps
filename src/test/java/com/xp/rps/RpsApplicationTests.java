package com.xp.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RpsApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	RpsRepoImpl rpsRepoImpl;

	@Test
	void contextLoads() {
	}

	@Test
	void play(){
		ResponseEntity<Round> response = restTemplate.postForEntity("/play",new Round(Throw.ROCK,Throw.PAPER),Round.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertEquals(Result.P2_WINS,response.getBody().getResult());
	}
	@Test
	void createGame(){
		ResponseEntity<Integer> response = restTemplate.postForEntity("/game",
				new Game("Dave","Adam",3,"Buy a tea"),Integer.class);
		int gameId = response.getBody();
		ResponseEntity<Game> response2 = restTemplate.getForEntity("/game/"+gameId,Game.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		Game g = response2.getBody();
		assertEquals("Dave",g.getPlayer1());
	}

	@Test
	void createRound(){
		int gameId = 1;
		ResponseEntity<Integer> response = restTemplate.postForEntity("/game",
				new Game("Dave","Adam",3,"Buy a tea"),Integer.class);
		gameId = response.getBody();
		ResponseEntity<Integer> response2 = restTemplate.postForEntity("/game/"+gameId+"/round",new Round(Throw.PAPER,Throw.ROCK),Integer.class);
		System.out.println("=====================");
		System.out.println(response.getBody());
//		assertEquals(HttpStatus.OK,response.getStatusCode());
//
//		int id= rpsRepoImpl.addRound(gameId,round);
//		assertEquals(id,response.getBody());
	}
}
