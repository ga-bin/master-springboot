package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		//1: Launch a Spring Context
		// HelloWorldConfiguration class를 spring container로 사용하겠다고 선언
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			//2: Configure the things that we want Spring to manage - @Configuration
			// HelloWorldConfiguration 
			// name - @Bean
			
			// 3: Retruieving Beans managed by Spring
			System.out.println(context.getBean("name")); 
			
			System.out.println(context.getBean("age")); 
			
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2MethodCall"));

			// 파라미터로 넣어도 에러안나고 실행된다
			// @configure @bean쓴 것을 spring이 새로운 bean을 만들어서 di한다.
			// spring container는 spring beans의 관리와 라이프사이클을 담당한다.
			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("person4Parameters"));
			
			System.out.println(context.getBean("person5Qualifier"));
			
			System.out.println(context.getBean("address2"));
			
			// 등록된 bean이 리턴하는 타입으로도 찾을 수 있음
			// System.out.println(context.getBean(Address.class));		
			
			// System.out.println
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			}
		}
	

}
