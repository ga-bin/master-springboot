package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}
	
	// bean이 생성되어 의존성주입되지마자 초기화해야한다.
	// @PostConstruct는 의존성주입되지 마자 해당 메소드가 실행되도록 해준다.
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	// 스프링컨테이너에서 해당 bean이 제거되기 전에 실행해야 될 로직은 @PreDestroy로 실행한다.
	@PreDestroy
	public void cleanup() {
		System.out.println("Cleanup");
	}
}

@Component
class SomeDependency {
	public void getReady() {
		System.out.println("Some logic using SomeDependency");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

	
	public static void main(String[] args) {

		
		try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		} 	
	}
}
