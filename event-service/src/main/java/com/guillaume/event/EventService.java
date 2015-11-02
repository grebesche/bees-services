package com.guillaume.event;

import com.guillaume.event.db.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Event get(Long id) {
		return eventRepository.findOne(id);
	}

	public Long createEvent(Event event) {
		Event saved = eventRepository.save(event);
		return saved.getId();
	}
}
