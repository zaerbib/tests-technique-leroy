package adeo.leroymerlin.cdp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SanityCheckWebAppTest {
	
	@Autowired
	private EventController eventController;
	
	/**
	 * just a sanity check
	 * @throws Exception
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(eventController).isNotNull();
	}

}
