package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthorityKind {
	
	UNKNOWN("","登録内容が不正"),
	
	ITEM_WATCHER("1","商品の内容を確認できる"),
	
	ITEM_MANAGER("2","商品情報の確認、更新が可能"),
	
	ITEM_AND_USER_MANAGER("3","商品情報の確認、更新、全ユーザーの情報管理が可能");
	
	
	private String AuthorityKind;
	private String value;
	
	
	
	
	

}

