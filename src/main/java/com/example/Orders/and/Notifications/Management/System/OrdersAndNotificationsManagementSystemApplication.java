package com.example.Orders.and.Notifications.Management.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrdersAndNotificationsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersAndNotificationsManagementSystemApplication.class, args);
	}

}
