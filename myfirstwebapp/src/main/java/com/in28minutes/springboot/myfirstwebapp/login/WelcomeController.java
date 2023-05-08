package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

	private AuthenticationService authenticationService;

	
	public WelcomeController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	
//	// 프론트 컨트롤러(dispacher servlet)이 requestmapping되어 있는 url을 찾고
//	// 다른 controller들은 view와 model을 반환한다
//	// dispacher servlet이 설정된 정보에 따라 해당 위치의 view를 찾아서 화면에 보여준다(이 과정에서 viewresolver사용한다)
//	@RequestMapping("/login")
//	public String goToLoginPage(@RequestParam String name, ModelMap model) {
//		// System.out.println("Request param is " + name); // not recommended for prod code
//		logger.debug("Request param is {}", name);
//		logger.info("I want this printed at info level");
//		logger.warn("I want this printed at warn level");
//		
//		model.put("name", name);
//		return "login";
//	}
	


	@RequestMapping(value="/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		// SecurityContextHolder는 현재 스레드의 보안 컨텍스트를 제공하는 클래스이다
		// Authentication 객체는 스프링 시큐리티(Spring Security)에서 인증 정보를 나타내는 객체
		// getAuthentication() 메소드는 현재 사용자의 인증 정보를 Authentication 객체로 반환한다
		// authentication.getName() : Authentication 객체의 getName() 메소드는 인증된 사용자의 이름을 문자열로 반환한다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
//	@RequestMapping(value="login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		// Authentication
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);						
//			return "welcome";
//		}
//		
//		model.put("errorMsg", "Id and Password is not matched");
//		return "login";
//	}
	
}
