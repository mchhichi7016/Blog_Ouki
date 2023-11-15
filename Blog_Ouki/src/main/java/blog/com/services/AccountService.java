package blog.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.AccountDao;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;//声明AdminDao adminDao，可以让这个类调用AdminDao接口中定义的方法，来实现对管理员数据的增删改查操作
	
	//新しいアカウントを作成し、データベースに保存する。/创建新账户，并将其保存到数据库中
	
	

}
