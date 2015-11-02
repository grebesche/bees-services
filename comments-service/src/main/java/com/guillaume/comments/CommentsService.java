package com.guillaume.comments;

import com.guillaume.comments.db.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;

	public Comment get(String id) {
		return commentsRepository.findOne(id);
	}

	public String createComment(Comment event) {
		Comment saved = commentsRepository.save(event);
		return saved.getId();
	}
}
