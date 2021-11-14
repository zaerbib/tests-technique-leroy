package adeo.leroymerlin.cdp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = EventController.class)
public class EventControlletUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EventService eventService;
	
	@Test
	public void testFindEvents() throws Exception {
		mockMvc.perform(get("/api/events/")).andExpect(status().isOk());
	}
	
	@Test
	public void testFindEventWithParam() throws Exception {
		mockMvc.perform(get("/api/events/search/{query}", "Wa")).andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteEvent() throws Exception {
		mockMvc.perform(delete("/api/events/{id}", 1)).andExpect(status().isOk());
	}
	
}
