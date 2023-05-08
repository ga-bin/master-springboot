package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
	// field injection
	// @Autowired
	Dependency1 dependency1;
	
	// @Autowired
	Dependency2 dependency2;
	
	//setter injection
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter injection - setDependency2");
//		this.dependency2 = dependency2;
//	}


	// contructor injection
	// 생성자 주입 방식은 모든 초기화를 한번에 하기 때문에 추천하는 방법이다.
	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("constructor injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
	public String toString() {
		return "Using " + dependency1 + "and" + dependency2;
	}

}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}

//해당하는 패키지에 @Component가 붙은 class를 bean으로 등록해라
//현재 클래스가 속하는 패키지를 읽어야하는 경우 패키지 명 생략 가능
@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

	
	public static void main(String[] args) {

		
		try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class)); 
		} 	
		
	}
}
