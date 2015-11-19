package com.guillaume.shared.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "text", "dateTime"})
@ToString(exclude = {"replies"})
public class Comment {
	private String id;
	private Long eventId;
	private String text;
	private Date dateTime;
	private Set<Reply> replies = new HashSet<>();
}
