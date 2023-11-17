package blog.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.BlogDao;
import blog.com.models.entity.AccountEntity;
import blog.com.models.entity.Blog;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	//blog一览 的方法
	//根据accountId查找所有blog并返回
	public List<Blog> selectAll(Long accountId){
		if(accountId == null) {
			return null;
		}else {
			return blogDao.findAll();
		}
	}
	
	//blog登録の方法
	//创建blog
	public boolean createBlog(String blogTitle,
							  String blogType,
							  String blogImage,
							  String blogArticle,
							  Long accountId) {
		if(blogDao.findByBlogTitle(blogTitle) == null) {
			blogDao.save(new Blog(blogTitle,blogType,blogImage,blogArticle,accountId));
			return true;
		}else {
			return false;
		}
	}
	
	
	//获取blog信息
	//ブログ情報 表示の方法
	public Blog getBlogPost(Long blogID) {
		if(blogID == null) {
			return null;
		}else {
			return blogDao.findByBlogId(blogID);
		}
	}
	
	//编辑の内容を保存する方法
	//product_id == null false
	//!=null 更新  true
	//編集した内容を保存するメソッド
	public boolean editBlog(Long blogId,
							String blogTitle,
							String blogType,
							String blogImage,
							String blogArticle,
							Long accountId) {
		if(blogId == null) {
			return false;
		}else {
			//更新処理
			blogDao.save(new Blog(blogId,blogTitle, blogType, blogImage, blogArticle, accountId));
			return true;
		}
	}
	

	//削除
	//productId == null  false
	//削除处理 true
	public boolean deleteBlog(Long blogId) {
		if(blogId == null) {
			return false;//削除失敗しました
		}else {
			blogDao.deleteByBlogId(blogId);
			return true;
		}
	}
	
	
	//
	//统计blog浏览量
	/*int count = 0;
	public int getBlogViewCount(Long blogId) {
		if() {
			count++;
			return count;
		}else {
			return count;
		}
	}*/
	
	
	
	

}
