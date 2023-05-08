package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record는 jdk 16버전이상에서 사용가능
// class를 만들 떄 파라미터로 전달한 값들로 생성자를 만들고, getter, setter, tostring을 자동으로 만들어줌
// person.age의 방식으로 getter, setter 사용한다.
record Person (String name, int age, Address address) {}

record Address(String firstLine, String city){}
// configuration 어노테이션을 붙이면 해당 클래스의 인스턴스의 제어를 스프링이 담당한다.
@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ranga";
	}

	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address()); // name, age
		return person;
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) { // name, age, address3
		var person = new Person(name, age, address3); // name, age
		return person;
	}
	
	//No qualifying bean of type 'com.in28minutes.learnspringframework.Address' available: 
	// expected single matching bean but found 2: address2,address3
	// to fix it need to use @Primary
	@Bean
	public Person person4Parameters(String name, int age, Address address) { // name, age, address2
		var person = new Person(name, age, address); // name, age
		return person;
	}
	
	// 예비 bean 주입
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { // name, age, address2
		var person = new Person(name, age, address); // name, age
		return person;
	}
	
	// customize bean name
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier") // 예비 bean으로 등록 시 @Qualifier 사용한다
	public Address address3() {
		return new Address("Motinagar", "Hyderabad");
	}
}
