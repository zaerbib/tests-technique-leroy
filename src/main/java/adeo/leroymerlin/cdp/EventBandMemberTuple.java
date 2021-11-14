package adeo.leroymerlin.cdp;

import java.util.Objects;

public class EventBandMemberTuple {
	private Event event;
	private Band band;
	private Member meber;
	
	public Event getEvent() {
		return event;
	}
	 
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Band getBand() {
		return band;
	}
	
	public void setBand(Band band) {
		this.band = band;
	}
	
	public Member getMeber() {
		return meber;
	}
	
	public void setMeber(Member meber) {
		this.meber = meber;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(band, event);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventBandMemberTuple other = (EventBandMemberTuple) obj;
		return Objects.equals(band, other.band) && Objects.equals(event, other.event);
	}
}
