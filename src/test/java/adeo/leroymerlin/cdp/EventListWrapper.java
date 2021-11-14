package adeo.leroymerlin.cdp;

import java.util.ArrayList;
import java.util.List;

public class EventListWrapper {
	private List<Event> eventList;
	
	public EventListWrapper() {
		eventList = new ArrayList<>();
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

}
