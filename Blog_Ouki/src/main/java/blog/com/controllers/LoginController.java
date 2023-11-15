package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import blog.com.models.dao.AccountDao;

@Controller//表明这是控制器 且Controller必须位于BlogOukiApplication的同层或者下一层
public class LoginController {
	//@Autowired
	//private AccountService accountService;
	
	@Autowired
	private AccountDao accountDao;
	
	//展示login页面
	@GetMapping(value = "/login")
	public String getLoginPage() {
		return "login.html";
	}

}
