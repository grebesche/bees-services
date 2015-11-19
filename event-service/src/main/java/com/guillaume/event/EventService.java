package com.guillaume.event;

import com.guillaume.event.db.Event;
import com.guillaume.shared.dto.Comment;
import com.guillaume.shared.dto.Reply;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
@Log
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private RestTemplate restTemplate;

	public Event get(Long id) {
		return eventRepository.findOne(id);
	}

	public Long createEvent(Event event) {
		Event saved = eventRepository.save(event);

		Comment comment = new Comment();
		comment.setDateTime(new Date());
		comment.setEventId(saved.getId());
		comment.setText("My new comment");

		Reply reply = new Reply();
		reply.setDateTime(new Date());
		reply.setText("My reply");
		comment.getReplies().add(reply);

		String response = restTemplate.postForObject("http://comments-service/comment",
				comment,
				String.class);

		log.info("Comment ID = " + response);

		return saved.getId();
	}
}
