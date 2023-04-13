package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GamingConsole;

public class App03GamingSpringBeansJava {
	public static void main(String[] args) {
		
		
//		var marioGame = new MarioGame();
//		var gameRunner = new GameRunner(marioGame);
//		gameRunner.run();
		
		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			context.getBean(GamingConsole.class).up();
			
			// gamingrunner에 주입된 pacmangame의 run이라는 메소드를 찾아서 실행해준다
			// 스프링 context가 자동으로 GamingConsole과 pacmangame에 bean을 주입하고 실행한다
			// gamingconsole에 주입된 game의 구현 클래스가 바뀐다고 하더라도 이 곳의 코드는 수정될 필요가 없기 떄문에 유지보수에 더 유용하다
			context.getBean(GamingConsole.class).run();
		} 
		
		
	}
	
}
