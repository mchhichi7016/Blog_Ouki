package blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.AccountEntity;
import blog.com.models.entity.Blog;
import blog.com.models.entity.Comment;

@Repository
public interface CommentDao extends JpaRepository<AccountEntity, Long>{
	
	
	//保存评论的方法
	//コメントを保存する方法
	//符合Spring Data JPA的查询方法的命名规则
	//Spring Data JPA準拠のクエリメソッドの命名規則
	Comment save(Comment comment);
	
}
