package blog.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.AccountDao;
import blog.com.models.entity.AccountEntity;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;//声明AdminDao adminDao，可以让这个类调用AdminDao接口中定义的方法，来实现对管理员数据的增删改查操作
	
	//新しいアカウントを作成し、データベースに保存する
	//创建新账户，并将其保存到数据库中
	public boolean createAccount(String name, String email, String password) {
		if(accountDao.findByAccountEmail(email)==null) {
			accountDao.save(new AccountEntity(name, email, password));
			return true;
		}else {
			return false;
		}
	}
	
	//loginCheck处理
	public AccountEntity loginCheck(String email, String password) {//2つのパラメータを渡す//传入两个参数
		////アカウントが存在するかどうか、データベースに問い合わせる。
		AccountEntity accountEntity = accountDao.findByAccountEmailAndPassword(email, password);
		if(accountEntity == null) {
			return null;
		}else {
			return accountEntity;//ログイン成功//登录成功
		}
	}
	
	//login处理
		public boolean checkLogin(String email, String password) {//2つのパラメータを渡す//传入两个参数
			////アカウントが存在するかどうか、データベースに問い合わせる。
			AccountEntity accountEntity = accountDao.findByAccountEmailAndPassword(email, password);
			if(accountEntity == null) {
				return false;
			}else {
				return true;//ログイン成功//登录成功
			}
		}
	

}
