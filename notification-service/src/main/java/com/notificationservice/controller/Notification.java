package com.notificationservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {

	private int notificationId;
	private String notificationDescription;
}
