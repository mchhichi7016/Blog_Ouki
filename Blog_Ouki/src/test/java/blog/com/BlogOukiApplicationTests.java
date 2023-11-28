package blog.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogOukiApplicationTests {
	
	private static BlogOukiApplicationTests blogOuki;
	
	//テストの実行前に
	@BeforeEach
	public void prepare() {
		blogOuki = new BlogOukiApplicationTests();
	}

	@Test
	void contextLoads() {
	}

}
