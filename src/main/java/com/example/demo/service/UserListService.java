package com.example.demo.service;

import java.util.List;

import com.example.demo.constant.UserDeleteResult;
import com.example.demo.dto.UserListInfo;
import com.example.demo.dto.UserSearchInfo;

public interface UserListService {
	
	//ユーザー情報テーブルを全件検索し、ユーザー一覧画面に必要な情報へ変換して返却する
	
	public List<UserListInfo> editUserList();
	
	//ユーザー情報テーブルを全件検索した結果を画面表示用に変換して返却します
	
	public List<UserListInfo> editUserListByParam(UserSearchInfo dto);
	
	//指定されたIdのユーザー情報を削除します
	public UserDeleteResult deleteUserInfoById(String loginId);
}
