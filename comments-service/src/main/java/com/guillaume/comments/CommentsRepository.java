package com.guillaume.comments;

import com.guillaume.comments.db.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentsRepository extends MongoRepository<Comment, String> {
}
