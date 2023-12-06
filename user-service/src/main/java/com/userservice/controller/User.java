package com.userservice.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private int userId;
	private String name;
	private Post post;
	private Notification notifications;
	
	public User(int id, String name) {
		this.userId = id;
		this.name = name;
	}
}
