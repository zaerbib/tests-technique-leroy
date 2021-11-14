package adeo.leroymerlin.cdp;

/**
 * In case of those tests, we choose to start application on random port  
 * and listen for a connection and then send an HTTP request (as it would do in production)
 */

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EventControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void findEventsTest() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port, EventListWrapper.class).getEventList()).doesNotContainNull();
	}
	
	@Test
	public void findEventsTest_withParam() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/search/Wa", EventListWrapper.class).getEventList()).hasSizeGreaterThanOrEqualTo(0);
	}
}
