package blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="blog")//表名blog //@Table注解，表示它可以被映射到数据库中的一个表
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blogId;//PK 属性名称
	
	@NonNull
	private String blogTitle;
	@NonNull
	private String bolgType;
	@NonNull
	private String blogImage;
	@NonNull
	private String blogArticle;
}