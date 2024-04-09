package com.example.demo.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;
/**
 * ユーザー情報生成
 */

@Component
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService{
	
	/*ユーザー情報テーブルRepository*/
	private final UserInfoRepository repository;
	
	
	/**
	 * ユーザー情報生成
	 * ＠param usernameログインID
	 * @throws UsernameNotFoundException
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{ //usernameにはログインIdが入る
		var userInfo=repository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));//user情報が取得できなかった時エラーメッセージを表示する。
				
		return User.withUsername(userInfo.getLoginId())
				.password(userInfo.getPassword())
		        .roles("USER")
		        .build();     //セットした情報でuserを作る
	}

}
