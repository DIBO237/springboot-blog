package com.mongodbtest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodbtest.Repository.BlogRepository;
import com.mongodbtest.Models.Blog;
import com.mongodbtest.Utils.Responses;

class successBlog {
	public String id;
	public String message;

	successBlog(String id, String message) {
		this.id = id;
		this.message = message;

	}
}

@Controller
@RequestMapping("/blog")
class BlogController {

	@Autowired
	private BlogRepository blogRepository;

	// POST BLOG FROM HERE

	@PostMapping("/post")
	@ResponseBody
	public ResponseEntity<Responses<Object>> postBlog(@RequestBody Blog blog) {

		// validations

		String title = blog.getTitle();
		String subject = blog.getSubject();
		String content = blog.getContent();
		String author = blog.getAuthor();

		if (title == null || title.isEmpty()) {

			Responses failureResponse = new Responses(400, "title is empty", null, false);

			return ResponseEntity.badRequest().body(failureResponse);
		}

		if (subject == null || subject.isEmpty()) {

			Responses failureResponse = new Responses(400, "subject is empty", null, false);

			return ResponseEntity.badRequest().body(failureResponse);
		}

		if (content == null || content.isEmpty()) {

			Responses failureResponse = new Responses(400, "Content is empty", null, false);

			return ResponseEntity.badRequest().body(failureResponse);
		}

		if (author == null || author.isEmpty()) {

			Responses failureResponse = new Responses(400, "author is emtpry", null, false);

			return ResponseEntity.badRequest().body(failureResponse);
		}
		
		
		try {
			
			
			Blog postHandles = new Blog(title,subject,content,author);
			
			blogRepository.save(postHandles);
			
			
			successBlog successMSG = new successBlog(postHandles.id, "Blog instered successfully");
			Responses successResponse = new Responses(200, "Successfully submitted", successMSG, true);

			return ResponseEntity.ok(successResponse);
			
		}catch (Exception e) {
			
			Responses failureResponse = new Responses(400, "author is emtpry", null, false);

			return ResponseEntity.internalServerError().body(failureResponse);
		}
		
		
		

		
	}
	
	
	@GetMapping("/getpost")
	@ResponseBody
	public ResponseEntity<Responses<List>> getPost() { 
		
		List <Blog> getallpost = blogRepository.findAll();
		
		Responses successResponse = new Responses(200, "Successfully submitted", getallpost, true);

		return ResponseEntity.ok(successResponse);
		
	}
	

}
