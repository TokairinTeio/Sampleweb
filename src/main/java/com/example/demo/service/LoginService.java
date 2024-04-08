package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/*チェック処理、DBアクセス(Repositoryクラス呼び出し)*/

/*ログイン画面Service*/

@Service
@RequiredArgsConstructor
public class LoginService {
	/*ユーザー情報テーブルDAO*/
	private final UserInfoRepository repository;
	
	/**
	 * ユーザー情報テーブルキー検索
	 * 
	 * @param loginId ログインID
	 * @return　ユーザー情報テーブルをキー検索した結果（1件）
	 */
	public Optional<UserInfo> searchUserById(String loginId){
		return repository.findById(loginId);
	}
	

}