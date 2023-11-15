package blog.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.AccountEntity;

@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Long>{
	
	//保存处理 保存账号
	AccountEntity save(AccountEntity accountEntity);
	
	//数据查询 
	//1行だけしかレコードは取得することが出来ない
	//SELECT * FROM account WHERE account_email=?
	AccountEntity findByAccountEmail(String accountEmail);
		
	//1行だけしかレコードは取得することが出来ない
	//SELECT * FROM account WHERE account_email=?And password=?
	AccountEntity findByAccountEmailAndPassword(String email, String passwrod);

}
