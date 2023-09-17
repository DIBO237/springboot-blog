package com.mongodbtest.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodbtest.Models.Author;

public interface AuthorRepo extends MongoRepository<Author,String> {


    
}
