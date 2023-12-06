package com.notificationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@GetMapping("/note")
	public Notification getNotification() {
		
		Notification notification = new Notification(1,"Notification success");
		
		return notification;
	}
}
