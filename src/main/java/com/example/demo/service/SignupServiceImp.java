package com.example.demo.service;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/*チェック処理、DBアクセス(Repositoryクラス呼び出し)*/

/*ユーザー登録画面Service実装クラス*/

@Service
@RequiredArgsConstructor
public class SignupServiceImp implements SignupService{
	/*ユーザー情報テーブルDAO*/
	private final UserInfoRepository repository;
	/*Dozer Mapper*/
	private final Mapper mapper;
	
	/*PasswordEncoder*/
	/*passwordencoderの中にBeanで定義したBCryp...が入る*/
	private final PasswordEncoder passwordencoder;
	
	
	/**
	 * ユーザー情報テーブル 新規登録
	 * 
	 * @param form 入力情報
	 * @return　登録情報：ユーザー情報Entity,既に登録がある場合はEnpty
	 */
	@Override
	public Optional <UserInfo> resistUserInfo(SignupForm form){
		var userInfoExistedOpt=repository.findById(form.getLoginId());
		if(userInfoExistedOpt.isPresent()) {
			return Optional.empty();  //登録済みならOptinal.empty==trueを返す。なしなら==false
		}
		var userInfo=mapper.map(form, UserInfo.class);
		var encordedPassword=passwordencoder.encode(form.getPassword());
		userInfo.setPassword(encordedPassword);
		userInfo.setAuthority(AuthorityKind.ITEM_WATCHER.getAuthorityKind());

		return Optional.of(repository.save(userInfo));
	}
	

}
