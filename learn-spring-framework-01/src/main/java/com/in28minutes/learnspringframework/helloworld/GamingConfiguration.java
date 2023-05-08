package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;

public class GamingConfiguration {
	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
//	var gameRunner = new GameRunner(game);
//	gameRunner.run();
}
