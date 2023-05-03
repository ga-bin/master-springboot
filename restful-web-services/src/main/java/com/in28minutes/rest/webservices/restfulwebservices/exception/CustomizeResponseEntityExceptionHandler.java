package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

// @ControllerAdvice는 애플리케이션 전역에서 발생하는 예외를 중앙에서 처리할 수 있다
// 이를 통해 예외 처리 코드의 중복을 방지하고, 예외 처리 로직을 모듈화하여 유지보수성을 높일 수 있다
// @ControllerAdvice 클래스는 @ExceptionHandler, @InitBinder, @ModelAttribute 메소드를 포함할 수 있다
// basePackages나 basePackageClasses 속성을 사용하여 적용할 패키지나 클래스를 지정할 수 있다. 이를 통해 예외 처리를 적용할 대상을 세부적으로 지정할 수 있다.
@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	// @ExceptionHandler는 특정 예외에 대한 처리를 담당하는 메소드를 지정할 때 사용된다
	// 예외가 달생하면 스프링은 @ExceptionHandler 메소드를 호출하고 해당 메소드에서 예외를 처리한다.
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		// errorDetails객체와 함께 상태코드 500전달
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR); // 500
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		// errorDetails객체와 함께 상태코드 500전달
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND); // 500
	}
	
	// 토비의 스프링에서 에러처리에 관련해서는 에러를 잡아서 처리하거나, 처리할 수 없는 에러의 경우 빨리 개발자에게 전달하는 것이 필요하다고 했다.
	// 처리할 수 없는 에러를 개발자에게 전달하는 상황에서 약속된 상태 코드를 전달하기 위해 해당 방법을 쓰는 것 같다.
	// 반면 userNotFoundException과 같은 경우에는 사용자에게 해당 유저가 존재하지 않는다 등의 알림을 띄울 수도 있을 것이다. 
	// 에외가 발생했을 경우 서버에서 우회하는 방법을 취하거나, 서버에서는 에러를 던지고 화면 상에서 예외를 처리하도록 하는 방법 등을 사용하면 될 것 같다.
	
	// @Valid 어노테이션을 통한 검증에 실패하는 경우 발생
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(
										LocalDateTime.now()
									  , "Total Errors : " + ex.getErrorCount() + " First Error : " + ex.getFieldError().getDefaultMessage()
									  , request.getDescription(false));
		// request.getDescription(false)은 url과 http method 포함하고 있다
		// 현재 요청에 대한 설명을 문자열로 반환하는 메소드이다
		// 매개변수로 false전달 시 세부 정보는 출력되지 않는다.
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST); // 400
	}
}
