package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API
//dispacherservlet은 기본적으로 루트경로(/)에 맵핑되어 있다
// 경로를 찾아주는 것은 DispatcherServletAutoConfiguration이다.
// 잘못된 경로로 요청이 들어왔을 떄 자동으로 에러 페이지를 만들어 던져주 것은 ErrorMvcAutoConfiguration이다
@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	@Autowired
	private HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		// return값은 json으로 넘어간다.
		// restcontroller안에는 @responsebody가 붙어있고 이것에 의해 message converter가 실행된다
		// springboot의 기본 message converter는 jacksonHttpMessageConverters이다
		return new HelloWorldBean("Hello World");
	}
	
	// Path Parameters
	// /user/{id}/todos/{id} => /users/2/todos/200
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	// 여러 언어를 받아들일 수 있도록 한다
	// src/main/resources에 messages_nl.properties등을 설정하고
	// 요청 헤더에 accept-language를 nl로 설정한다.
	// 영어의 경우 nl이 아니라 en 등으로 하면 된다
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
}
