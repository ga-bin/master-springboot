package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	// LDAP or Database
	// In Memory
	
	// InMemoryUserDetailsManager 
	// InMemoryUserDetailsManager(UserDetails... users)
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("in28minutes", "dummy");
		UserDetails userDetails2 = createNewUser("ranga", "dummydummy");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
										.passwordEncoder(passwordEncoder)
										.username(username)
										.password(password)
										.roles("USER", "ADMIN")
										.build();
		return userDetails;
	}

	private String username() {
		return "in28minutes";
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// All URLS are protected
	// A login from is shown for unauthroized requests
	// to access hw CSRF disalbe(cross site request for)
	// frames 
	// 이 코드는 모든 요청이 인증을 받아야 한다는 것을 설정하는 것이다
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// spring security 적용시 securityfilterchain이 먼저 돌아서 로그인 페이지로 튕겨주는 것이다
		// securityFilterChain은 Spring security에서 요청을 인증 및 인가하는 필터체인이다. 이 필터체인은 보안관련 작업을 처리하는데 사용된다.
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()); 
				// anyRequest().authenticated()는 모든 요청에 대해 인증을 수행하도록 구성된 것
		http.formLogin(withDefaults());
		http.csrf().disable();
		// CSRF(Cross-site request forgery) 보호를 비활성화하는 코드이다
		// CSRF는 웹 어플리케이션에서 발생할 수 있는 보안 공격으로, 이를 막기 위해 Spring Security에서는 기본적으로 CSRF 보호를 적용
		http.headers().frameOptions().disable();
		// spring Security에서 X-Frame-Options 헤더를 비활성화하는 코드이다
		// Spring Security 기본 설정에서는 브라우저에서 해당 웹 사이트를 iframe으로 로드할 수 없도록 방지하는 기능을 가지고 있는데 이를 비활성화한다.
		return http.build();
	}
}
