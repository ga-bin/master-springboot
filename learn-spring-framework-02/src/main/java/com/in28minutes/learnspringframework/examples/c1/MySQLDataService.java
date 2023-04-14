package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// db통신을 하는 것은 @Repository
// @service나 @controller @Repository 등등은 @Component를 구체화 한 것이다.
@Repository
// @Component
@Primary
public class MySQLDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] { 11, 22, 33, 44, 55 };
	}

}
