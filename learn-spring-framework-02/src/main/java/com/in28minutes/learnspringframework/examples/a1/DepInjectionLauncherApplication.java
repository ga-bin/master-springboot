package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
// 해당하는 패키지에 @Component가 붙은 class를 bean으로 등록해라
// 현재 클래스가 속하는 패키지를 읽어야하는 경우 패키지 명 생략 가능
// YourBusinessClass
// Dependency1
// Dependency2

class YourBusinessClass {
	
}

class Dependency1 {
	
}

class Dependency2 {
	
}
public class DepInjectionLauncherApplication {

	
	public static void main(String[] args) {

		
		try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		} 	
	}
}
