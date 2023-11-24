package blog.com.models.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
//表名comment 
//@Table注解，表示它可以被映射到数据库中的一个表
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;//PK 主キー
	
	private String commentContent;
	
	private LocalDateTime commentTime;
	
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;//FK　外部キー
	
	@Column(name = "blog_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blogId;//FK　外部キー
	
	public Comment() {
		
	}

	public Comment(String commentContent, Long accountId, Long blogId) {

		this.commentContent = commentContent;
		this.accountId = accountId;
		this.blogId = blogId;
		// 默认使用当前时间//デフォルトでは現在時刻が使用される
		//this.commentTime = LocalDateTime.now(); 
	}


	public Comment(Long commentId, String commentContent, LocalDateTime commentTime, Long accountId, Long blogId) {

		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.accountId = accountId;
		this.blogId = blogId;
	}
	
	
	

	

}
