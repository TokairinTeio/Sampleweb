package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SignupMessage;
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
	 *  @param form　入力チェック
	 * @return　表示画面
	 */
	
	@PostMapping("/signup")
	public void signup(Model model,@Validated SignupForm form,BindingResult bdResult) {
		if(bdResult.hasErrors()) {
			editGuideMessage(model,MessageConst.FORM_ERROR,true);
			return;
		}
		var userInfoOpt=service.resistUserInfo(form);
		var signupMessage= judgeMessages(userInfoOpt);
		var messageId=AppUtil.getMessage(messageSource,signupMessage.getMessageId());
		model.addAttribute("message",messageId);
		model.addAttribute("isError",signupMessage.isError());
		editGuideMessage(model,signupMessage.getMessageId(),signupMessage.isError());
			
	}
	/**
	 * 画面に表示するガイドメッセージを設定する
	 * @param model　モデル
	 * @param messsageId　メッセージID
	 * @param isError　エラー有無
	 */
	private void editGuideMessage(Model model,String messsageId,boolean isError) {
		var message=AppUtil.getMessage(messageSource,messsageId);
		model.addAttribute("message",message);
		model.addAttribute("isError",isError);
	}
	
	private SignupMessage judgeMessages(Optional<UserInfo>userInfoOpt) {
		if(userInfoOpt.isEmpty()) {
			return SignupMessage.EXISITED_LOGIN_ID;
			
		}else {
			return SignupMessage.SUCCEED;
		}
	}
}
	



