package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// 프론트 컨트롤러(dispacher servlet)이 requestmapping되어 있는 url을 찾고
	// 다른 controller들은 view와 model을 반환한다
	// dispacher servlet이 설정된 정보에 따라 해당 위치의 view를 찾아서 화면에 보여준다(이 과정에서 viewresolver사용한다)
	@RequestMapping("/login")
	public String goToLoginPage(@RequestParam String name, ModelMap model) {
		// System.out.println("Request param is " + name); // not recommended for prod code
		logger.debug("Request param is {}", name);
		logger.info("I want this printed at info level");
		logger.warn("I want this printed at warn level");
		
		model.put("name", name);
		return "login";
	}
}
