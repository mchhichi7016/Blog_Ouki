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
import jakarta.servlet.http.HttpSession;

@Controller//表明这是控制器 且Controller必须位于BlogOukiApplication的同层或者下一层
public class LoginController {
	@Autowired
	private AccountService accountService;
	
	//Session宣言
	@Autowired
	private HttpSession session;
	
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
		
		AccountEntity account = accountService.loginCheck(email, password);
		if(account == null) {
			
			//查询数据库中的所有AdminEntity对象，然后赋值给admin变量
			//List<AccountEntity>account = accountDao.findAll();
			//model.addAttribute("email", email);
			//model.addAttribute("accountList", account);//account未来可能能用到
			
			return "login.html";
		}else {
			session.setAttribute("account", account);
			return "redirect:/blog/list";
		}
	}
	
	//logout ログアウト
	@GetMapping("/logout")
		public String logout() {
		//返回/login
		return "redirect:/login";
	}

}
