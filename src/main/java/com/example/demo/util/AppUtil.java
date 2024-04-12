package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * アプリケーション共通クラス
 */

//springvootでメッセージを取得するときは、MessageSourceクラス使用...getMessageメソッドを使いKeyを渡してメッセージをとる
//params...メッセージの中に可変的な置換変数を用意することができる。
//Object...この引数は渡しても渡さなくてもいいという意味になる(...)
//Locale.JAPAN日本語のメッセージをとってくるという意味。messsage.propertiesは様々な言語に対応可
//staticなクラスはDIできない
public class AppUtil {
	/**
	 * メッサージIDからメッセージを取得する
	 * @param messageSource
	 * @param key　メッセージキー
	 * @param params　置換文字
	 * @return　メッセージ
	 */
	public static String getMessage(MessageSource messageSource,String key,Object...params) {
		return messageSource.getMessage(key,params,Locale.JAPAN);
	}
	
	public static String addWildcard(String param) {
		return "%" + param + "%";
	}

}
