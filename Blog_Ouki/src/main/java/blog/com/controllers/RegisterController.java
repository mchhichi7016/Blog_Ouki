package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.services.AccountService;

@Controller
public class RegisterController {
	
	@Autowired
	private AccountService accountService;
	
	//登録画面 展示注册页面/register
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register.html";
	}
	
	//登録处理
	//保存页面输入的注册信息
	@PostMapping("/register/process")
	public String register(@RequestParam String username,
			  			   @RequestParam String email,
			  			   @RequestParam String password) {
		if(accountService.createAccount(username, email, password)) {
			System.out.println("register成功しました");
			return "login.html";
		}else {
			System.out.println("register失敗しました");
			return "register.html";
		}
	}

}
