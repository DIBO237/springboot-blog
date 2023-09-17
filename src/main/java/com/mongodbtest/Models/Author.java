package com.mongodbtest.Models;
import org.bson.types.ObjectId;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Author {

    @Id
    public String id;
    public String name;
    public List<ObjectId> published_post;
    public LocalDateTime created_At;


    public Author() {
	}

	public Author(String name) {
		this.name = name;
		this.created_At = LocalDateTime.now();
	}

    public String getName() {
		return name;
	}

	public void setName(String names) {
		this.name = names;
	}

    public void addPostId(ObjectId postID) {
          this.published_post.add(postID);
    }

    
}
