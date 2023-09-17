package com.mongodbtest.Models;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public class Blog {

	@Id
	public String id;

	public String title;
	public String subject;
	public String content;
	public String author;
	public LocalDateTime created_At; // Add timestamp field

	public Blog() {
	}

	public Blog(String title, String subject, String content, String author) {
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.author = author;
		this.created_At = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, title, subject, content, author,created_At);
	}





	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}