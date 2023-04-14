package com.in28minutes.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;


// 해당하는 패키지에 @Component가 붙은 class를 bean으로 등록해라
// 현재 클래스가 속하는 패키지를 읽어야하는 경우 패키지 명 생략 가능
public class XmlConfigurationContextLauncherApplication {

	
	public static void main(String[] args) {

		
		try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			context.getBean(GameRunner.class).run();
		} 	
	}
}
