package com.example.demo.entity;



import java.time.LocalDateTime;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.constant.UserStatusKind;
import com.example.demo.entity.converter.UserAuthorityConverter;
import com.example.demo.entity.converter.UserStatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * ユーザー情報Entity
 * */

@Entity
@Table(name="user_info")
@Data
@AllArgsConstructor
public class UserInfo {
	/*ログインID*/
	@Id
	@Column(name="login_id")
	private String loginId;
	/*パスワード*/
	private String password;
	/*ログイン失敗回数*/
//	@Column(name="login_failure_count")
//	private int loginFailureCount=0;
	/*アカウントロック日時*/
	@Column(name="account_locked_time")
	private LocalDateTime accountLockedTime;
	
	/*ユーザー状態種別*/
	@Column(name="is_disabled")
	@Convert(converter=UserStatusConverter.class)
	private UserStatusKind userStatusKind;
	
	/*ユーザー権限種別*/
	@Convert(converter=UserAuthorityConverter.class)
	private AuthorityKind authorityKind;
	
	/*最終更新ユーザー*/
	@Column(name="update_user")
	private String updateUser;
	
	/*デフォルトコンストラクタ*/
	public UserInfo() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
