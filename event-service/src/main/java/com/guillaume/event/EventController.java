package com.guillaume.event;

import com.guillaume.event.db.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/event/{eventId}", method = RequestMethod.GET)
	public Event getEvent(@PathVariable("eventId") Long id) {
		return eventService.get(id);
	}

	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public Long createEvent(@RequestBody Event event) {
		return eventService.createEvent(event);
	}
}
