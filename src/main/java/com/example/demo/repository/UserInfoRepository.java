package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.constant.UserStatusKind;
import com.example.demo.entity.UserInfo;

/*DBアクセスを行う*/

/**
 * ユーザー情報テーブルDAO
 */


public interface UserInfoRepository extends JpaRepository <UserInfo,String> {
	/**
	 * ログインIDの部分一致検索を行う
	 * @param loginId　ログインID
	 * @return　検索でヒットしたユーザーの情報リスト
	 */
	
	List<UserInfo> findByLoginIdLike(String loginId);
	
	/**
	 * ログインID、アカウント状態の項目を使って検索を行います。
	 * 
	 * 検索条件
	 * ログインID部分一致
	 * アカウント状態：完全一致
	 * 
	 * @param loginId ログインID
	 * @param　userStatusKind アカウント状態
	 * @return　検索でヒットしたユーザー情報のリスト
	 */
	
	List<UserInfo>findByLoginIdLikeAndUserStatusKind(String loginId,UserStatusKind userStatusKind);
	/**
	 * ログインID、アカウント状態の項目を使って検索を行います。
	 * 
	 * 検索条件
	 * ログインID部分一致
	 * アカウント状態：完全一致
	 * 
	 * @param loginId ログインID
	 * @param　userStatusKind アカウント状態
	 * @param authorityKind 権限
	 * @return　検索でヒットしたユーザー情報のリスト
	 */
	
	List<UserInfo>findByLoginIdLikeAndAuthorityKind(String loginId,AuthorityKind authorityKInd);
	
	/**
	 * ログインID、アカウント状態の項目を使って検索を行います。
	 * 
	 * 検索条件
	 * ログインID部分一致
	 * アカウント状態：完全一致
	 * 
	 * @param loginId ログインID
	 * @param　userStatusKind アカウント状態
	 * @param authorityKind 権限
	 * @return　検索でヒットしたユーザー情報のリスト
	 */
	
	List<UserInfo>findByLoginIdLikeAndUserStatusKindAndAuthorityKind(String loginId,AuthorityKind authorityKInd,UserStatusKind userStatusKind);
	
	
	
	
	
	
	
	
	
	
	
	
	

}


