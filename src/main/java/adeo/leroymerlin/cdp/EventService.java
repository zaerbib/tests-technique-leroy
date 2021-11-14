package adeo.leroymerlin.cdp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAllBy();
    }

    public void delete(Long id) {
        eventRepository.delete(id);
    }

    public List<Event> getFilteredEvents(String query) {
        List<Event> events = eventRepository.findAllBy().stream()
        									.map(customEvent -> fromEventToTuple(customEvent))
        									.flatMap(Collection::stream)
        									.filter(customEvent -> customEvent.getMeber().getName().contains(query))
        									.map(customEvent -> {
        										Event event = customEvent.getEvent();
        										event.setTitle(event.getTitle()+" ["+event.getBands().size()+"]");
        										
        										event.getBands().forEach(band -> {
        											band.setName(band.getName()+" ["+band.getMembers().size()+"]");
        										});
        										
        										return event;
        									})
        									.collect(Collectors.toList());        
        return events;
    }
    
    /**
     * flatten Event Object
     * operation equivalent to left join of sql
     * @param event
     * @return
     */
    private List<EventBandMemberTuple> fromEventToTuple(Event event) {
    	List<EventBandMemberTuple> tupleList = new ArrayList<EventBandMemberTuple>();
    	
    	event.getBands().forEach(band -> {    		
    		band.getMembers().forEach(member -> {
    			EventBandMemberTuple tuple = new EventBandMemberTuple();
    			
    			tuple.setEvent(event);
    			tuple.setBand(band);
    			tuple.setMeber(member);
    			
    			tupleList.add(tuple);
    		});
    	});
    	
    	return tupleList;
    }
}
