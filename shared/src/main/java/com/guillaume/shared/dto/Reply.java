package com.guillaume.shared.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Reply {
	private String text;
	private Date dateTime;
	private Set<Reply> replies = new HashSet<>();
}
