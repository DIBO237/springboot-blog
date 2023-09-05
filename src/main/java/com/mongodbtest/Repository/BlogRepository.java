package com.mongodbtest.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodbtest.Models.Blog;


public interface BlogRepository extends MongoRepository<Blog, String> {

}







