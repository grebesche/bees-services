package com.guillaume.comments;

import com.guillaume.comments.db.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

	@Autowired
	private CommentsService commentsService;

	@RequestMapping(value = "/comment/{commentId}", method = RequestMethod.GET)
	public Comment getEvent(@PathVariable("commentId") String id) {
		return commentsService.get(id);
	}

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public String createEvent(@RequestBody Comment comment) {
		return commentsService.createComment(comment);
	}
}
