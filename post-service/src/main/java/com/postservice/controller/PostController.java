package com.postservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

	@GetMapping("/p")
	public Post getPost() {
		
		Post post = new Post(1,"Post successs");
		
		return post;
	}
}
