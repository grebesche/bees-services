package com.guillaume.event;

import com.guillaume.event.db.Event;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EventApplication.class)
@ActiveProfiles("test")
public class EventApplicationTests {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventService eventService;

	@Before
	public void before() {

	}

	@After
	public void after() {
		eventRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEvent() throws Exception {
		Event event = new Event();
		event.setName("My Event");
		event.setDateTime(LocalDateTime.now());

		Assert.assertNotNull(eventService.createEvent(event));
	}

	@Test
	public void createAndGetEvent() throws Exception {
		String eventName = "My Event";
		LocalDateTime now = LocalDateTime.now();

		Event event = new Event();
		event.setName(eventName);
		event.setDateTime(now);

		Long eventId = eventService.createEvent(event);
		Event eventLoaded = eventService.get(eventId);
		Assert.assertEquals(eventId, eventLoaded.getId());
		Assert.assertEquals(eventName, eventLoaded.getName());
		Assert.assertEquals(now, eventLoaded.getDateTime());
	}
}
