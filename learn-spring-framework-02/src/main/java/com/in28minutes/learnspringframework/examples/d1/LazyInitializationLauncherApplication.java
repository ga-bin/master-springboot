package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
// lazy annotaion 사용 시 생성자의 호출이 bean주입될 떄 일어나지 않는다.
// 대신 프록시가 주입되는 방식이다.
// lazy에서는 해당 클래스를 사용할 떄마다 생성자의 호출이 일어나며 초기화가 일어난다.
// 초기화 후 해당 로직이 실행되는 방식
// 기본 spring의 초기화 방식은 eager이다 - bean생성시 바로 생성자를 부르고 초기화가 일어난다.
// eager방식은 spring이 시작될 때 에러를 바로 찾아주기 때문에 권장되는 방식이다.
// lazy는 자주 권장되지 않고 자주 사용되지도 않는다.
class ClassB {
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		// LOGIC
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration
@ComponentScan
// 해당하는 패키지에 @Component가 붙은 class를 bean으로 등록해라
// 현재 클래스가 속하는 패키지를 읽어야하는 경우 패키지 명 생략 가능
public class LazyInitializationLauncherApplication {

	
	public static void main(String[] args) {

		
		try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
			System.out.println("Initialization of context is completed");
			context.getBean(ClassB.class).doSomething();
		} 	
	}
}
