package blog.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import blog.com.models.entity.AccountEntity;
import blog.com.models.entity.Blog;
import blog.com.services.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private HttpSession session;
	
	//Blog一览
	//
	/*@GetMapping("/blog/list")
	public String getBlogList(Model model) {
		AccountEntity account = (AccountEntity)session.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}else {
			List<Blog>blogList = blogService.selectAll(account.getAccountId());
			model.addAttribute("blogList", blogList);
			model.addAttribute("accountName", account.getAccountName());
		}
	}*/
	

}
