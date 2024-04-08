package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/*Controller画面の入力値を受け取る、Serviceクラスを呼び出す、遷移先の画面を決める*/
/**
 * ユーザー登録画面Constructor
 * 
 */

@Controller
@RequiredArgsConstructor
public class SignupController {
	
	/*ユーザー登録service*/
	private final SignupService service;
	
	/*メッセージソース*/
	private final MessageSource messageSource;
	

	
	/*初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 * 
	 * 
	 * */
	@GetMapping("/signup")
	public String view(Model model,SignupForm form ) {
		
		return "signup";
	}
	/**
	 * ユーザー登録
	 * @param model　モデル
	 * @param form　入力情報
	 * @return　表示画面
	 */
	
	@PostMapping("/signup")
	public void signup(Model model,SignupForm form) {
		var userInfoOpt=service.resistUserInfo(form);
		var message=AppUtil.getMessage(messageSource, judgeMessages(userInfoOpt));
		model.addAttribute("message",message);
			
	}
	
	private String judgeMessages(Optional<UserInfo>userInfoOpt) {
		if(userInfoOpt.isEmpty()) {
			return MessageConst.SIGNUP_EXISTED_LOGIN_ID;
			
		}else {
			return MessageConst.SIGNUP_RESIST_SUCCEED;
		}
	}
}
	



