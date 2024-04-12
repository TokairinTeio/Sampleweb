package com.example.demo.entity.converter;

import com.example.demo.constant.AuthorityKind;

import jakarta.persistence.AttributeConverter;

public class UserAuthorityConverter  implements AttributeConverter<AuthorityKind,String>{
	/*
	 * 
	 * 引数で受け取った権限種別Enumを、権限種別のコード価に変換
	 * 
	 *@param 権限種別Enum
	 *@return 引数で受け取った権限種別Enumに保管されているコード値
	 */
	@Override
	public String convertToDatabaseColumn(AuthorityKind authorityKind) {
		return authorityKind.getCode();
	}
	/*
	 * 
	 * 引数で受け取った権限種別Enumを、権限種別のコード価に変換
	 * 
	 *@param 権限種別のコード
	 *@return 引数で受け取った権限種別コード値から逆引きしたコード値
	 */
	
	
	
	
	@Override
	public AuthorityKind convertToEntityAttribute(String value) {
		return  AuthorityKind.from(value);
	}

}
