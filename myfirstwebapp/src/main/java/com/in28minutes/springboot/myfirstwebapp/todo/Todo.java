package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// @entity는 bean과 database table을 매칭한다.
// name으로 설정하면 클래스이름과 테이블 이름이 다를 경우 매칭시킬 수 있다.
// 각 필드에도 name으로 특정 컬럼명과 이름을 매칭할 수 있다.
@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	@Size(min=10, message="Enter at least 10 characters")
	private String description;
	// 카멜케이스의 경우 db 생성 시 자동으로 스네이크케이스로 바뀌어서 생성된다.
	private LocalDate targetDate;
	private boolean done;


	
	// contructor
	public Todo() {
		
	}
	
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	
	// getter, setter
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}


	// toString
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
	
}
