package com.example.demo.service;

import org.apache.catalina.mapper.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/*チェック処理、DBアクセス(Repositoryクラス呼び出し)*/

/*ユーザー登録画面Service*/

@Service
@RequiredArgsConstructor
public class SignupService {
	/*ユーザー情報テーブルDAO*/
	private final UserInfoRepository repository;
	/*Dozer Mapper*/
	private final Mapper mapper;
	
	/**
	 * ユーザー情報テーブル 新規登録
	 * 
	 * @param form 入力情報
	 * @return　ユーザー情報テーブルをキー検索した結果（1件）
	 */
	public UserInfo sresistUserInfo(SignupForm form){
		var userInfo= new UserInfo();
		var mapper= new DozerBeanMapper();
		userInfo.setLoginId(form.getLoginId());
		userInfo.setPassword(form.getPassword());
		return repository.save(userInfo);
	}
	

}
