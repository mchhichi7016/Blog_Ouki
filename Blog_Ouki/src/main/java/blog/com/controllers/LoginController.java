package blog.com.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
	//@Autowired
	//private AdminService adminService;
	
	//@Autowired
	//private AdminDao adminDao;
	
	//展示login页面
	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}

}