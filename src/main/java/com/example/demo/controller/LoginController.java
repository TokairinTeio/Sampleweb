package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;
import com.example.demo.util.AppUtil;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/*Controller画面の入力値を受け取る、Serviceクラスを呼び出す、遷移先の画面を決める*/
/**
 * ログイン画面Constructor
 * 
 */

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	/*ログイン画面service*/
	private final LoginService service;
	
	/*PasswordEncoder*/
	/*passwordencoderの中にBeanで定義したBCryp...が入る*/
	private final PasswordEncoder passwordencoder;
	
	/*メッセージソース*/
	private final MessageSource messageSource;
	
	/*セッション情報*/
	private final HttpSession session;
	
	
	/*初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 * 
	 * 
	 * */
	@GetMapping(UrlConst.LOGIN)
	public String view(Model model,LoginForm form ) {
		
		return "login";
	}
	/*ログインエラー画面表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 * 
	 * 
	 * */
	@GetMapping(value=UrlConst.LOGIN,params="error")//value,paramsを使ってURLを識別する/login...value部?error...params部になる
	public String viewWithError(Model model,LoginForm form ) {
		var errorInfo=(Exception)session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("errorMsg",errorInfo.getMessage());
		return "login";
	}
	
	@PostMapping(UrlConst.LOGIN)
	public String login(Model model,LoginForm form) {
		System.out.println(form.toString());
		var userInfo=service.searchUserById(form.getLoginId());
		//var encoderdPassword=passwordencoder.encode(form.getPassword());
		var isCorrectUserAuth=userInfo.isPresent() 
				//userIdが存在しない時false
				//userIdは取れたが、入力されたPWと登録されたPWが違う時false
				//machs第一引数：入力されたPW(ハッシュ化されていない)　第二引数:userInfoからとってきたハッシュ化されたPW
				&& passwordencoder.matches(form.getPassword(), userInfo.get().getPassword());
		if( isCorrectUserAuth) {
			return "redirect:/menu";
		}else {
			var errorMsg=AppUtil.getMessage(messageSource, MessageConst.LOGIN__WRONG_INPUT);
			model.addAttribute("errorMsg",errorMsg);
			return "login";
		}
	}
	

}
