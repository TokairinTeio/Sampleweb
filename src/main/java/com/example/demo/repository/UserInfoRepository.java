package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserInfo;

/*DBアクセスを行う*/

/**
 * ユーザー情報テーブルDAO
 */


public interface UserInfoRepository extends JpaRepository <UserInfo,String> {

}
