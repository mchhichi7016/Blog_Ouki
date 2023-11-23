package blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.Blog;
import blog.com.models.entity.Comment;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface BlogDao extends JpaRepository<Blog, Long> {
	
	//保存处理 保存blog
	Blog save(Blog blog);
	
	//blog一覧　情報を取得//查看所有的blog
	List<Blog>findAll();
	
	//1行目だけの取得
	//SELECE * FROM product WHERE blogId = ?
	Blog findByBlogId(Long blogId);
		
	//1行目だけの取得
	//SELECE * FROM product WHERE blogtitle = ?
	Blog findByBlogTitle(String blogTitle);
		
	//删除方法
	Blog deleteByBlogId(Long blogId);
	
	//findByBlogTitleContaining模糊查询
	List<Blog>findByBlogTitleContaining(String blogTitle);
	
	//更新するビュー数の方法
	@Transactional
	//修改操作
	@Modifying
	@Query("UPDATE Blog b SET b.blogView = b.blogView + 1 WHERE b.blogId = :blogId")
	void incrementBlogView(Long blogId);
	
	//保存处理 保存Comment
	//Comment save(Comment comment);

}
