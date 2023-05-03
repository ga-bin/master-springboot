package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	// todo는 entity, integer는 primary key의 데이터 타입
	
	// id로 데이터를 들고오는 것은 인터페이스에 정의하지 않아도 사용할 수 있지만
	// 그 외의 다른 컬럼으로 값을 가져오는 것은 인터페이스에 정의해야한다.
	public List<Todo> findByUsername(String username);
}
