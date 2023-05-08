package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> { // <entity, idtype>
	
	// jpa를 통해서 사용자 지정 메소드도 설정할 수 있다.
	// jparepository인터페이스를 확장할 경우 직접 작성하는 것보다 훨씬 더 간단해진다(courseJpaRepository와 비교)
	// jpa는 네이밍컨벤션을 따라야한다 메소드명by컬럼명
	
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
	
}
