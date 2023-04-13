package com.in28minutes.learnspringframework.test;

import java.io.Serializable;

// plain old java object
// any java object is pojo
class Pojo {
	private String text;
	private int number;
	
	public String toString() {
		return text + ":" + number;
	}
}

// serializable is interface for class serialize
class JavaBean implements Serializable  { //EJB // 3. implement java.io.Serializable
	private static final long serialVersionUID = 1L;

	//1: public no-arg constructor
	public JavaBean() {
		
	}
	
	private String text;
	private int number;

	//2: getters and setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}


public class SpringBeanVsJavaBean {
	

	public static void main(String[] args) {
		
		Pojo pojo = new Pojo();
		
		System.out.println(pojo);
		

	}

	// Spring bean : any java object that is managed by spring
}
