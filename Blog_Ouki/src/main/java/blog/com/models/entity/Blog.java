package blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@Entity
@Table(name="blog")//表名blog //@Table注解，表示它可以被映射到数据库中的一个表
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blogId;//PK 属性名称
	
	private String blogTitle;

	private String bolgType;

	private String blogImage;

	private String blogArticle;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;//FK 属性名称
	
	public Blog() {
		
	}

	public Blog(String blogTitle, String bolgType, String blogImage, String blogArticle, Long accountId) {
		this.blogTitle = blogTitle;
		this.bolgType = bolgType;
		this.blogImage = blogImage;
		this.blogArticle = blogArticle;
		this.accountId = accountId;
	}

	public Blog(Long blogId, String blogTitle, String bolgType, String blogImage, String blogArticle, Long accountId) {
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.bolgType = bolgType;
		this.blogImage = blogImage;
		this.blogArticle = blogArticle;
		this.accountId = accountId;
	}
	
}
