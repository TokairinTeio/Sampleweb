package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatusKind {
	
	/*使用可能*/
	ENABLED(false,"利用可能"),
	
	/*使用不可*/
	DISABLED(true,"利用不可");
	
	/*利用不可か*/
	private boolean isDisabled;
	
	/*画面を表示する説明文*/
	private String displayValue;

}
