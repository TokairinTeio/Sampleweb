package com.example.demo.entity.converter;

import com.example.demo.constant.UserStatusKind;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserStatusConverter implements AttributeConverter<UserStatusKind,Boolean> {
	
	
	
	/**
	 * 
	 * 引数で受け取ったユーザー状態種別Enumを、利用可否のbooleanに変換する
	 * 
	 * @pram ユーザー種別
	 * @return 引数で受け取ったユーザー状態種別Enumに保管されているboolean
	 */
	//Entityの型からDBの型へ変換
	@Override
	public Boolean convertToDatabaseColumn(UserStatusKind userStatus) {
		return userStatus.isDisabled();
	}
	/**
	 * 引数で受け取った権限種別のコード値を、ユザー状態種別Enumに変換
	 * @param 利用可否
	 * @return 
	 * 
	 */
	
	//DBの値をEntityに変換
	@Override
	public UserStatusKind convertToEntityAttribute(Boolean isDisabled) {
		return isDisabled ? UserStatusKind.DISABLED : UserStatusKind.ENABLED;
	}

}
