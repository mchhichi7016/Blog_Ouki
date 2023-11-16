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
@Table(name="account")//表名account //@Table注解，表示它可以被映射到数据库中的一个表
public class AccountEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//@GeneratedValue注解，表示它的值是由数据库自动生成的，不需要手动指定。
	private Long accountId;//PK 属性名称
	
	@NonNull
	private String accountName;
	@NonNull
	private String accountEmail;
	@NonNull
	private String password;

}
