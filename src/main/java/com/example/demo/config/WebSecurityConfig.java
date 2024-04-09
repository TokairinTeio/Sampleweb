package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.constant.UrlConst;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
	/*ユーザーname属性*/
	private final String USERNAME_PARAMETER="loginId";
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		
		http.authorizeHttpRequests(
				authorize -> authorize.requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
				   .anyRequest().authenticated())
		    .formLogin(login -> login.loginPage(UrlConst.LOGIN)//自作ログイン画面(Controller)を使うための設定
			.usernameParameter(USERNAME_PARAMETER)//ユーザー名パラメーターのname属性
			.defaultSuccessUrl(UrlConst.MENU));//ログイン成功後のリダイレクトURL
		
		
		return http.build();
	}

}
