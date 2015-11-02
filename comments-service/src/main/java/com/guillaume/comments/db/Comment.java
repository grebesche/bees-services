package com.guillaume.comments.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "text", "dateTime"})
@ToString(exclude = {"replies"})
public class Comment {

	@Id
	private String id;
	private String text;
	private Date dateTime;
	private Set<Comment> replies = new HashSet<>();
}
