import com.example.restservice.RestServiceApplication;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import services.EmployeesDAOTest;


// @Import(EmployeesDAOTest.class)
@ContextConfiguration(classes = RestServiceApplication.class)
public class RestServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
