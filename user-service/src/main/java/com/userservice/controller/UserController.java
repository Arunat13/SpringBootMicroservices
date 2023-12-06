package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/u")
	public User getUser() {

		User user = new User(1, "AAAAA");
		
		ServiceInstance instance = loadBalancerClient.choose("notification-service");
		String NoteUri = instance.getUri().toString();
		System.out.println("URI----------------> "+ NoteUri);
		
		ServiceInstance instance2 = loadBalancerClient.choose("post-service");
		String postUri = instance2.getUri().toString();
		

		Notification notification = restTemplate.getForObject(NoteUri + "/notification/note", Notification.class);
		
		Post post =  restTemplate.getForObject(postUri + "/post/p", Post.class);
		
		user.setPost(post);
		user.setNotifications(notification);
		
		return user;
	}
}
