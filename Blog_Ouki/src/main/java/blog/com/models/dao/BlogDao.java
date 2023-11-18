package blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.Blog;
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
	
	//findByBlogTitleContaining模糊查询
	List<Blog>findByBlogTitleContaining(String blogTitle);
		
	//删除方法
	int deleteByBlogId(Long blogId);

}
