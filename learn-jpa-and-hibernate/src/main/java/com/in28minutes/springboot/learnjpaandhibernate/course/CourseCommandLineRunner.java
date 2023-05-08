package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository; 
	
// @Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringJpaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS Now!", "in28miutes"));
		repository.save(new Course(2, "Learn Azure Now!", "in28miutes"));
		repository.save(new Course(3, "Learn DevOps Now!", "in28miutes"));
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
	
		System.out.println(repository.findAll());

		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByName("Learn DevOps Now!"));
	}
	
}
	