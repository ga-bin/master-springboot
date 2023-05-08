package com.in28minutes.springboot.learnjpaandhibernate.course;

// jakarta.persistence는 줄여서 jpa로 api이다
// hibernate는 jpa를 구현한 것 중 가장 유명한 것
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // 테이블과 javabean을 연결, db 테이블과 이름이 다를 경우 name 속성을 이용하면 된다.
public class Course {

	@Id
	private long id;
	@Column(name="name") // db컬럼명과 같지 않을 떄만 name속성이 필요하다
	private String name;
	@Column(name="author")
	private String author;
	
	// constructor
	public Course() {
		
	}

	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	// getters
	/**
	 * @return
	 */
	public long getId() {
		return id;
	}
	

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	

	// tostring
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
