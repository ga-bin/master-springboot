package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// db마다 던져주는 예외 다 다르기 때문에 http의 응답 코드로 예외롤 설정하는 것이 좋다
// 토비의 스프링에서와 마찬가지로 이런 에외들 각각 마다 클래스를 생성하는게 바람직한 방법인지 의문이 든다. 
// 한 클래스 내에서 다른 에러들을 정의하고 예외 코드들을 던져두도록 하는게 더 바람직 할 것 같다.
@ResponseStatus(code = HttpStatus.NOT_FOUND) // NOT_FOUND에 해당하는 404에러 던진다.
public class UserNotFoundException extends RuntimeException {
	// 언체크 예외로 만들기
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
