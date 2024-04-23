package com.example.demo.constant;
/**
 * 
 * エラーメッセージID定数クラス
 */
public class MessageConst {
	
	/*共通：入力内容誤り*/
	public static final String FORM_ERROR="common.formError";
	
	/*ログイン画面の入力内容誤り*/
	public static final String LOGIN_WRONG_INPUT="loin.wrongInput";
	
	/*ユーザー登録画面：既に登録されているログインID*/
	public static final String SIGNUP_EXISTED_LOGIN_ID="signup.existed.LoginId";
	
	/*登録成功*/
	public static final String SIGNUP_RESIST_SUCCEED="signup.resistSucceed";
	
	/*ユーザー一覧画面：存在しないログインID*/
	public static final String USERLIST_NON_EXISTED_LOGIN_ID="userList.nonExistedLoginId";
	
	/*ユーザー画面一覧：ユーザー削除完了*/
	public static final String USERLIST_DELETE_SUCCEED="userList.deleteSucceed";
	
	/*ユーザー情報編集画面：存在しないログインID*/
	public static final String UPDATEEDIT_NON_EXISTED_LOGIN_ID="userEdit.nonExistedLoginId";
	
	
	/*更新成功メッセージ*/
	public static final String USEREDIT_UPDATE_SUCCEED ="userEdit.updateSecceed";
	
	/*更新失敗メッセージ*/
	public static final String UPDATEEDIT_UPDATE_FAILED="userEdit.updateFailed";

}
