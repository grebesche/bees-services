package com.guillaume.comments;

import com.guillaume.comments.db.Comment;
import com.guillaume.comments.db.Reply;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CommentsApplication.class)
public class CommentsApplicationTests {

	@Autowired
	private CommentsRepository commentsRepository;
	@Autowired
	private CommentsService commentsService;

	@Test
	public void contextLoads() {
		commentsRepository.deleteAll();
	}

	@Test
	public void createComment() throws Exception {
		Comment comment = new Comment();
		comment.setText("My comment");
		comment.setDateTime(new Date());
		Assert.assertNotNull(commentsService.createComment(comment));
	}

	@Test
	public void createAndGetComment() throws Exception {
		String commentName = "My comment";
		Date now = new Date();

		Comment comment = new Comment();
		comment.setText(commentName);
		comment.setDateTime(now);

		String eventId = commentsService.createComment(comment);
		Comment commentLoaded = commentsService.get(eventId);
		Assert.assertEquals(eventId, commentLoaded.getId());
		Assert.assertEquals(commentName, commentLoaded.getText());
		Assert.assertEquals(now, commentLoaded.getDateTime());
	}

	@Test
	public void createCommentWithAReply() throws Exception {
		Comment comment = new Comment();
		comment.setText("My comment");
		comment.setDateTime(new Date());

		Reply reply = new Reply();
		reply.setText("My reply");
		reply.setDateTime(new Date());

		comment.getReplies().add(reply);

		Assert.assertNotNull(commentsService.createComment(comment));
	}

	@Test
	public void createCommentWithAReplyAndLoadThem() throws Exception {
		String commentText = "My comment";
		String replyText = "My reply";
		Date commentTime = new Date();
		Date replyTime = new Date();

		Comment comment = new Comment();
		comment.setText(commentText);
		comment.setDateTime(commentTime);

		Reply reply = new Reply();
		reply.setText(replyText);
		reply.setDateTime(replyTime);

		comment.getReplies().add(reply);

		String commentId = commentsService.createComment(comment);
		Comment loadedComment = commentsService.get(commentId);

		Assert.assertEquals(commentId, loadedComment.getId());
		Assert.assertEquals(commentText, loadedComment.getText());
		Assert.assertEquals(commentTime, loadedComment.getDateTime());
		Assert.assertEquals(1, loadedComment.getReplies().size());
		Reply loadedReply = loadedComment.getReplies().iterator().next();
		Assert.assertEquals(replyText, loadedReply.getText());
		Assert.assertEquals(replyTime, loadedReply.getDateTime());
	}
}