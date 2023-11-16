package blog.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.models.dao.AccountDao;
import blog.com.models.entity.AccountEntity;
import blog.com.services.AccountService;

@Controller//表明这是控制器 且Controller必须位于BlogOukiApplication的同层或者下一层
public class LoginController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDao accountDao;
	
	//展示login页面
	@GetMapping(value = "/login")
	public String getLoginPage() {
		return "login.html";
	}
	
	//ログイン処理 login
	//もし入力の内容がDBを検索した結果存在する場合
	//blog.htmlを表示します
	//そうでない場合
	//login.htmlを表示します
	@PostMapping("/login/process")
	public String login(@RequestParam String email,@RequestParam String password, Model model) {
		if(accountService.checkLogin(email, password)) {
			
			//查询数据库中的所有AdminEntity对象，然后赋值给admins变量
			List<AccountEntity>accounts = accountDao.findAll();
			model.addAttribute("email", email);
			//accounts未来可能能用到
			model.addAttribute("accountList", accounts);
			
			return "blog_list.html";
		}else {
			return "login.html";
		}
	}
	
	//logout ログアウト
	@GetMapping("/logout")
		public String logout() {
		//返回/login
		return "redirect:/login";
	}

}
