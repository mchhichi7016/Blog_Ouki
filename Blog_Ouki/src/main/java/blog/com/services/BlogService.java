package blog.com.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import blog.com.models.dao.BlogDao;
import blog.com.models.dao.CommentDao;
import blog.com.models.entity.AccountEntity;
import blog.com.models.entity.Blog;
import blog.com.models.entity.Comment;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;	
	
	@Autowired
	private CommentDao commentDao;
	
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

	
	
	//查询blog方法
	//根据blogTitle查找所有blog并返回
	public List<Blog> searchAll(String blogTitle){
		if(blogTitle == null) {
			
			//空のList<Blog> オブジェクトを返します。
			//返回一个空的List<Blog>对象
			return Collections.emptyList();
		}else {
			//使用findAllByBlogTitle方法
			return blogDao.findByBlogTitleContaining(blogTitle);
		}
	}
	

	//ビュー数
	//接收博客的ID，更新博客的浏览量的方法
	//ブログのIDを受け取り、ブログの閲覧数を更新する方法
	public Blog incrementBlogView(Long blogId) {
		if (blogId == null) {
	        return null;
	    } else {
	        Blog blog = blogDao.findByBlogId(blogId);
	        if (blog != null) {
	            //累加浏览量
	        	//累積回数
	            blog.setBlogView(blog.getBlogView() + 1);
	            blogDao.save(blog);  // 保存更新后的数据
	        }
	        return blog;
	    }
	}
	
	
	//给blog写评论的方法
	//ブログへのコメントの書く方法
	public Comment createComment(Long commentId,
								 String commentContent,
								 LocalDateTime commentTime,
								 Long accountId,
								 Long blogId) {
		if (blogId == null) {
			return null;
		}else {
			Comment comment = new Comment(commentId, commentContent, commentTime, accountId, blogId);
			commentDao.save(comment);
			return comment;
		}
	}
	
	//判断创建评论是否成功的方法
	// コメントの作成が成功したかどうかを判断(はんだん)する方法
	public boolean isCreateComment(String commentContent,
			 					 Long accountId,
			 					 Long blogId) {
		if(blogId == null) {
			return false;
		}else {
			
			Comment comment = new Comment(commentContent, accountId, blogId);
			// 设置 comment_time //comment_time の設定
	        comment.setCommentTime(LocalDateTime.now()); 
	        commentDao.save(comment);
	        
			return true;
		}
	}
	
	//通过blogId获取所有评论
	//blogIdですべてのコメントを取得
	public List<Comment> getCommentsByBlogId(Long blogId){
		if(blogId == null) {
			return null;
		}else {
			return commentDao.findByBlogId(blogId);
		}
	}
	
	
}
