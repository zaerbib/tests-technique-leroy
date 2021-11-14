package adeo.leroymerlin.cdp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false)
public interface EventRepository extends Repository<Event, Long> {
	
	@Modifying
	@Query("delete from Event where id =:eventId")
    void delete(@Param("eventId") Long eventId);

    List<Event> findAllBy();
}
